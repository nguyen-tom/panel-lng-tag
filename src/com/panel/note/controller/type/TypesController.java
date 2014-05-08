package com.panel.note.controller.type;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.panel.note.dao.common.TypeDao;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.TypeRes;
import com.panel.note.meta.TypeMeta;
import com.panel.note.model.Type;
import com.panel.note.util.ResponseUtil;



public class TypesController extends Controller {
    
   private static final Logger logger = Logger.getLogger(TypesController.class.getName());
   int result  = 20;
   Errors error = new Errors();
    @Override
    protected Navigation run() throws Exception {
        TypeRes  res = new TypeRes();
        long timeStart  = System.currentTimeMillis();
        logger.info("Start /types [" + timeStart + "]");
       try{
           find();
           result = 10;
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

        List<Type> companies = dao.getList();
        logger.fine("companies : " + companies);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().write(TypeMeta.get().modelsToJson(companies));
        logger.fine("find end");
        return null;
    }

}
