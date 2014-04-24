package com.panel.note.controller.type;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.TypeDao;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.TypeRes;
import com.panel.note.meta.TypeMeta;
import com.panel.note.model.Type;

public class GetTypeController extends Controller{
    private static final Logger logger = Logger.getLogger(TypesController.class.getName());
    int result  = 20;
    Errors error = new Errors();
     @Override
     protected Navigation run() throws Exception {
         TypeRes  res = new TypeRes();
         long timeStart  = System.currentTimeMillis();
         logger.info("Start /getType [" + timeStart + "]");
        try{
            if(isPost()){
                logger.info("do Post /getType [" + timeStart + "]");
                find();
                result = 10;
            }
        }catch(Exception e){
           result = 20;
           error.setError(new Error("30",e.toString())); 
        }
        
      
        logger.info("End /types [" + ( System.currentTimeMillis() - timeStart) + "]");
         return null;
     }
     
     private Navigation find() throws Exception {
         TypeDao dao = new TypeDao("fole");
         logger.fine("find start");
         String k  = asString("id");
         logger.info("Id :" + k);
         Key key  = asKey("id");
         Type type = dao.get(key);
         logger.info("Type with " + key + " : " + type);
         response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
         response.getWriter().write(TypeMeta.get().modelToJson(type));
         logger.fine("find end");
         return null;
     }

 }
