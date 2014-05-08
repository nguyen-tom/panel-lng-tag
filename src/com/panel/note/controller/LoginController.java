package com.panel.note.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.CommonRes;
import com.panel.note.dto.session.LoginData;
import com.panel.note.model.Agent;
import com.panel.note.model.Company;
import com.panel.note.service.common.CommonService;
import com.panel.note.util.Const;
import com.panel.note.util.ResponseUtil;
import com.panel.note.util.StrUtil;

public class LoginController extends Controller{
    private static final Logger logger = Logger.getLogger(LoginController.class.getName()); 
    private long start;
    @Override
    protected Navigation run() throws Exception {
        logParameters();
        
        CommonService service  = new CommonService();
        CommonRes res  = new CommonRes();
        Errors  errorsDto = new Errors();
        start  = System.currentTimeMillis();
        
        errorsDto.setError(new ArrayList<Error>());
        
        
        if (!validateRequest()) {
            res.setTime(start);
            res.setResult(20);
            res.setErrors(errorsDto);
            ResponseUtil.dtoToJsonResponse(res, request, response);
            logger.info("run Error on validate Request");
            return null;
        }
        Company company  = null;
        String shopId  = asString("shop");
        
        company  = service.checkShop(shopId, "global", errorsDto);
        if(errorsDto.getError().size() > 0){
            res.setTime(start);
            res.setResult(20);
            res.setErrors(errorsDto);
            ResponseUtil.dtoToJsonResponse(res, request, response);
            logger.fine("run Error on validate Request");
            return null;
        }
        String email  = asString("user-name");
        String hashed_password = StrUtil.getSigniture(asString("password"), "SHA1");
        Agent  agent  = service.checkAgent(company, email, hashed_password, errorsDto);
        if(errorsDto.getError().size() > 0){
            res.setTime(start);
            res.setResult(20);
            res.setErrors(errorsDto);
            ResponseUtil.dtoToJsonResponse(res, request, response);
            logger.fine("run Error on validate Request");
            return null;
        }
        createSession(agent);
        res.setTime(start);
        res.setResult(10);
        res.setErrors(errorsDto);
        ResponseUtil.dtoToJsonResponse(res, request, response);
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
    private boolean validateRequest() {
        Validators v = new Validators(request);
        v.add("shop", v.required("Required Shop ID"));
        v.add("user-name", v.required("Required Email "));
        v.add("password", v.required("Required Passoword"));
        return v.validate();
    }
    private void createSession(Agent agent){
        HttpSession session = request.getSession();
        LoginData loginData = new LoginData();
        loginData.setSessionEmail(agent.getEmail());
        loginData.setSessionShopId(agent.getCompanyRef().getKey().getName());
        loginData.setSessionLevel(agent.getLevel());
        
        Cookie cookie = new Cookie("token_id",KeyFactory.keyToString(agent.getCompanyRef().getKey()));
               cookie.setMaxAge(60*60); //1 hour
               response.addCookie(cookie);
               cookie = new Cookie("usr_id",KeyFactory.keyToString(agent.getKey()));
               cookie.setMaxAge(60*60); //1 hour
               response.addCookie(cookie);
               cookie = new Cookie("usr_name",agent.getEmail());
               cookie.setMaxAge(60*60); //1 hour
               response.addCookie(cookie);
        
        session.removeAttribute(Const.LOGIN_DATA);
        session.setAttribute(Const.LOGIN_DATA, loginData);
    }
}
