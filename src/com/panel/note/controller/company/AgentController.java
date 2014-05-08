package com.panel.note.controller.company;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.AgentDao;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.model.Company;
import com.panel.note.util.ResponseUtil;
import com.panel.note.util.StrUtil;

public class AgentController extends Controller {
    private static final Logger logger = Logger.getLogger(AgentController.class.getName());
    private BaseRes res  = new BaseRes();
    @Override
    protected Navigation run() throws Exception {
        res.setTime(System.currentTimeMillis());
        logParameters();
        if(isPost()){
            doPost();
        }
        return null;
    }
    public void doPost() throws Exception{
        res.setResult(10);
        NamespaceManager.set("global");
        String company_id = asString("company-id");
        String email      = asString("email");
        String password   = asString("password");
        password  = StrUtil.getSigniture(password, "SHA1");
        
        Key companyKey =  Datastore.createKey(Company.class,company_id);
        logger.info("Password :" + password);
        String level      = asString("level");
        AgentDao agentDao  = new AgentDao();
        agentDao.insertAgent(companyKey, email, password, level);
        ResponseUtil.dtoToJsonResponse(res, request, response);
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
    

}
