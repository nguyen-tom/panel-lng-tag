package com.panel.note.controller.lang;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dto.common.LanguageDto;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.dto.response.ListObjectRes;
import com.panel.note.error.SystemError;
import com.panel.note.model.Language;
import com.panel.note.service.common.LanguageService;
import com.panel.note.util.ResponseUtil;
import com.panel.note.util.StrUtil;

public class LanguageController extends Controller {
    
    private static final Logger logger = Logger.getLogger(LanguageController.class.getName()); 
    private Key key = null ; // default method
    private String name;
    private String description;
    BaseRes baseRes = new BaseRes();
    @Override
    protected Navigation run() throws Exception {
        logParameters();
        logger.log(Level.INFO,"Starting Language Controller >>>>>>>>>");
        baseRes.setTime(System.currentTimeMillis());
        key  = null;
        logger.info("ID : " + request.getParameter("id") );
        if(request.getParameter("id") != null && !request.getParameter("id").equalsIgnoreCase("") && !request.getParameter("id").equalsIgnoreCase("null") ) key = asKey("id");
        if(isPost()){
            doPost();
        }
        if(isGet()){
            if(key ==  null){
                getAllLanguage();
            }
        }
        
        logger.log(Level.INFO,"Finish Controller >>>>>>>>>");
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
 
    private void doPost() throws SystemError, IOException{
        getParameter();
        LanguageService service  = new LanguageService();
        baseRes  = service.insertUser(baseRes, name, description);
        ResponseUtil.dtoToJsonResponse(baseRes, request, response);
        
    }
    private void getParameter(){
        name  = asString("name");
        description = asString("description");
    }
    private boolean validationParam(){
        return StrUtil.strIsNull(name);
        
    }
    private void getAllLanguage() throws IOException{
        ListObjectRes<LanguageDto> baseRes  = new ListObjectRes<LanguageDto>();
        baseRes.setTime(System.currentTimeMillis());
        baseRes = new LanguageService().getAllLanguage(baseRes);
        ResponseUtil.dtoToJsonResponse(baseRes, request, response);
    }

}
