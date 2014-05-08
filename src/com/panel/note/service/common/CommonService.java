package com.panel.note.service.common;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.StringUtil;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.CompanyDao;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.model.Agent;
import com.panel.note.model.Company;
import com.panel.note.util.PropertyUtil;



public class CommonService {
    protected static final Logger logger = Logger.getLogger(CommonService.class.getName());
    private CompanyDao companyDao;
    
    public CommonService() {
        super();
        companyDao = new CompanyDao();
    }
    public Company checkShop(String shop_id, String namespace, Errors errorsDto) {
        Error errorDto = new Error();
        errorDto.setCode("InvalidData.CompanyNoneError");
        errorDto.setMessage(ApplicationMessage.get("error.CompanyNoneError"));

        Company company = null;

        if (!StringUtil.isEmpty(shop_id)) {
            NamespaceManager.set("global");

            try {
                company = Memcache.get(shop_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (company == null) {
                company = this.getCompanyByID(shop_id);
                try{
                    Memcache.put(shop_id, company);
                }catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
            if (company == null) {
                errorsDto.setError(errorDto);
                return null;
            }
            NamespaceManager.set(namespace);

            if (Boolean.TRUE.equals(company.getInvalid())) {
                errorsDto.setError(errorDto);
                return company;
            }
        } else {
            errorsDto.setError(errorDto);
            return null;
        }

        return company;
    }
    /**
     * @return companyDao
     */
    public Company getCompanyByID(String shop_id) {
        Company result = null;

        int count = 0;
        boolean retry;
        do {
            retry = false;
            try {
                Key key = Datastore.createKey(Company.class, shop_id);
                result = companyDao.getOrNull(key);
            } catch (RuntimeException e) {
                if (!(e instanceof DatastoreTimeoutException)) {
                    if (! (e instanceof ConcurrentModificationException)) {
                        if (!(e.getClass().getName().contains("ApiProxy$UnknownException") && e.getMessage().contains("datastore_v3"))) {
                            throw e; 
                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e2) {

                    }
                }
                count++;
                if (count <= Integer.parseInt(PropertyUtil.getProperty("MAX_RETRY_COUNT"))) {
                    retry = true;
                } else {
                    throw new IllegalStateException("Retry count exceeded.", e);
                }
            }
        } while (retry);

        return result;
    }
    public Agent checkAgent(Company company,String email,String password,Errors errorsDto){
        List<Agent> listAgent  = company.getOperatorsRef().getModelList();
        Error errorDto  = new Error();
        errorDto.setCode("InvalidParam.InvalidValue");
        errorDto.setMessage(ApplicationMessage.get("error.OperatorNoneError"));
        logger.info("List Agent zise :" + listAgent.size());
        
        if(listAgent.size() == 0){
            errorsDto.setError(errorDto);
        }
        for (Agent agent : listAgent){
            logger.info("List Agent Email :" + agent.getEmail() + " && " +  email);
            logger.info("List Agent Password :" + agent.getPassword() + " && " +  password);
            if(agent.getEmail().equalsIgnoreCase(email) && agent.getPassword().equalsIgnoreCase(password)){
                return agent;
            }
        }
        errorsDto.setError(errorDto);
        return null;
        
    }
    

}
