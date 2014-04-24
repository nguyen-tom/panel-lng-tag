package com.panel.note.controller.company;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mortbay.log.Log;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.dto.response.CompanyRes;
import com.panel.note.model.Company;
import com.panel.note.service.common.CompanyService;
import com.panel.note.util.ResponseUtil;

public class CompanyController extends Controller {
    
    private static final Logger logger = Logger.getLogger(CompanyController.class.getName());
    int result  = 20;
    Errors error = new Errors();
    private Key key;
    private CompanyService companyService;
    @Override
    protected Navigation run() throws Exception {
        setup();
        key  = null;
        logger.info("ID : " + request.getParameter("id") );
        if(request.getParameter("id") != null && !request.getParameter("id").equalsIgnoreCase("")) key = asKey("id");
        if(isGet()){ // get Company or get ListCompany
            if(key == null){ // get List Company
                getListCompany();
                return null;
            }
            // get CompanyEntity
            getCompany(key);
            
        }else if (isPost()) { // create Comppany or update Company
            if(key == null){ // add new
                String name     = request.getParameter("name");
                String address  = request.getParameter("address");
                String taxcode  = request.getParameter("taxcode");
                String log  = String.format("POST Name[%s] address[%s] tax[%s]", name,address,taxcode);
                logger.info(log);
                Company company = new Company();
                company.setName(name);
                company.setAddress(address);
                company.setTaxCode(taxcode);
                addCompany(company);
            }
            
        }else if (isPut()){ // delete Company with Id
            
        }
        return null;
    }
    private void logParameters() {
        if (logger.isLoggable(Level.INFO)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Request start " + request.getMethod() + " "
                    + request.getServletPath() + "\n");
            @SuppressWarnings("unchecked")
            Enumeration<String> names = request.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                sb.append("params[" + name + "] value["
                        + request.getAttribute(name) + "]\n");
            }

            logger.log(Level.INFO, sb.toString());
        }
    }
    private void setup(){
        logger.info(" >>>> Start Company Controller");
        logParameters() ;
        companyService  = new CompanyService();
    }
    private void getMethodParam(){
        
    }
    private void getListCompany(){
        CompanyRes companyRes  = companyService.getAllCompanies();
        try {
            ResponseUtil.dtoToJsonResponse(companyRes, request, response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    private void getCompany(Key id){
        
    }
    private void updateCompany(Company company,String key){
        
    }
    public void addCompany(Company company){
        BaseRes companyRes  = companyService.insertCompany(company);
        try {
            ResponseUtil.dtoToJsonResponse(companyRes, request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
