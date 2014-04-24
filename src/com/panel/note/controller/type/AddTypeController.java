package com.panel.note.controller.type;

import java.util.Date;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.TypeDao;
import com.panel.note.dao.common.UserDao;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.model.Type;
import com.panel.note.util.ResponseUtil;


public class AddTypeController extends Controller{

    private static final Logger logger = Logger.getLogger(UserDao.class.getName());
    private Key key  = null;
    private String name_space;
    private String name_key;
    private String name;
    private String desscription;
    private int max;
    private int min;
    private TypeDao typeDao;
    
    @Override
    protected Navigation run() throws Exception {
        
        long timeStart = System.currentTimeMillis();
        logger.info("Start add type  at time " + timeStart );
      
        BaseRes basicRes = new BaseRes();
        typeDao  = new TypeDao("fole");
        
        int result = 20;
        Errors error = null;
        try{
            set_param();
            if(isPost()){
                key = typeDao.allocateId();
                doPost();
            }else if(isPut()){
                key   = asKey("id");
                doPut();
            }
            
           result = 10;
           basicRes.setResult(result);
           basicRes.setErrors(new Errors());
           basicRes.setTime(System.currentTimeMillis());
           ResponseUtil.dtoToResponse("json", basicRes, request, response);
        }catch(Exception e){
            error = new Errors();     
            error.setError(new Error("30",e.toString()));
            basicRes.setResult(result);
            basicRes.setErrors(error);
            basicRes.setTime(System.currentTimeMillis());
            ResponseUtil.dtoToResponse("xml", basicRes, request, response); 
        }
        logger.info("End add  " +  (System.currentTimeMillis() -  timeStart ));
        return null;
    }
    
    private void doPost() throws IllegalArgumentException{
        logger.info("Start ADD TYPE >>>> " );
            Type typeModel  = new Type();
            typeModel.setKey(key);
            typeModel.setName(name);
            typeModel.setCreateAt(new Date());
            typeModel.setUpdateAt(new Date());
            typeModel.setDescription(desscription);
            typeModel.setMinItem(min);
            typeModel.setMaxItem(max);
            typeModel.setEnable(true);
            typeDao.put(typeModel);
    }
    private void doPut() {
        Type typeModel  = new Type();
        typeModel.setKey(key);
        typeModel.setName(name);
        typeModel.setUpdateAt(new Date());
        typeModel.setDescription(desscription);
        typeModel.setMinItem(min);
        typeModel.setMaxItem(max);
        typeModel.setEnable(true);
        typeDao.put(typeModel);   
    }
    private void set_param() throws IllegalArgumentException {
         name             = request.getParameter("name");
         desscription     = request.getParameter("description");
         max              = Integer.parseInt(request.getParameter("maxItem"));
         min              = Integer.parseInt(request.getParameter("minItem"));
        
         System.out.println(" Name[" + asString("name") +"] Max [ " + request.getParameter("max_item") + "] Min [ "+ request.getParameter("min_item") + "]");
        if(name == null || name.equalsIgnoreCase("")) throw new IllegalArgumentException();
    }
}
