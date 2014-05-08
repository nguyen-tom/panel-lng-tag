package com.panel.note.controller.auth;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.util.Const;
import com.panel.note.util.ResponseUtil;

public class LoginedController extends Controller{
    private BaseRes baseRes;
    
    
    @Override
    protected Navigation run() throws Exception {
       baseRes  = new BaseRes();
        baseRes.setTime(System.currentTimeMillis());
        int result  = 20;
        if(isGet()){
            if(getSession()){
                result  = 10;
            }
            baseRes.setResult(result);
            Errors errors = new Errors();
            baseRes.setErrors(errors);
            ResponseUtil.dtoToJsonResponse(baseRes, request, response);
            return null;
        }
       Errors errors = new Errors();
       baseRes.setResult(result);
       baseRes.setErrors(errors);
       ResponseUtil.dtoToJsonResponse(baseRes, request, response);
       return null;
        
    }
    public boolean getSession(){
        
        HttpSession session     = request.getSession();
        System.out.println("Session :" + session.getAttribute(Const.LOGIN_DATA));
        if (session.getAttribute(Const.LOGIN_DATA) != null) {
           return true;
        } 
        return false;
        
    }

}
