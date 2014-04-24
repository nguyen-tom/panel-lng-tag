package com.panel.note.controller.user;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.service.common.UserService;
import com.panel.note.util.ResponseUtil;

public class UserController extends Controller{
    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    int result  = 20;
    Errors error = new Errors();
    private Key key;
    UserService service;
    
    private String account;
    private String password;
    private String strKeyLang;
    private String strKeyCompany;
    private String address;
    private String city;
    private String email;
    private String UIUD;
    private int permission;
    private String mobiPhone;
    private String firstName;
    private String lastName;
    
    
    @Override
    protected Navigation run() throws Exception {
        setup();
        key  = null;
        if(request.getParameter("id") != null && !request.getParameter("id").equalsIgnoreCase("")) key = asKey("id");
        if(isGet()){
            doGet();
            return null;
        }
        if(isPost()){
            doPost();
            return null;
        }
        if(isPut()){
            doPut();
            return null;
        }
        
        return null;
    }
    private void setup(){
        service  = new UserService();
    }
    private void doGet(){
        if(key == null){
            
        }
        
    }
    private void doPost() throws Exception {
        if(key == null){ //add new User
            getParamAdd();
            BaseRes baseRes  = new BaseRes();
            baseRes.setTime(System.currentTimeMillis());
            
           baseRes =  service.insertUser(baseRes, 
                                         account, 
                                         password, 
                                         email, 
                                         firstName, 
                                         lastName,
                                         strKeyCompany, 
                                         strKeyLang, 
                                         address, 
                                         mobiPhone, 
                                         UIUD, 
                                         permission,
                                          city);
           ResponseUtil.dtoToJsonResponse(baseRes, request, response);
        }else{ //delete
            
        }
    }
    private void getParamAdd(){
        account  = asString("acccount");
        password = asString("password");
        email    = asString("email");
        address  = asString("address");
        city     = asString("city");
        strKeyLang = asString("id_lang");
        strKeyCompany = asString("id_company");
        permission    = Integer.parseInt(asString("permission"));
        firstName    = asString("first-name");
        lastName     = asString ("lastName");
        
    }
    private void doDelete(){
        
    }
    private void doPut(){
        
    }
    
    

}
