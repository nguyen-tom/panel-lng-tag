package com.panel.note.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.dto.response.CommonRes;
import com.panel.note.util.Const;
import com.panel.note.util.ResponseUtil;

public class LogoutController extends Controller  {
    CommonRes res = new CommonRes();
    @Override
    protected Navigation run() throws Exception {
        removeSession();
        res.setTime(System.currentTimeMillis());
        res.setResult(10);
        ResponseUtil.dtoToJsonResponse(res, request, response);
        
        return null;
    }
    private void removeSession(){
        HttpSession session = request.getSession();
        
        session.removeAttribute(Const.LOGIN_DATA);
        
        Cookie cookie = new Cookie("token_id",null);
        cookie.setMaxAge(60*60); //1 hour
        response.addCookie(cookie);
        cookie = new Cookie("usr_id",null);
        cookie.setMaxAge(60*60); //1 hour
        response.addCookie(cookie);
        cookie = new Cookie("usr_name",null);
        cookie.setMaxAge(60*60); //1 hour
        response.addCookie(cookie);
    }

}
