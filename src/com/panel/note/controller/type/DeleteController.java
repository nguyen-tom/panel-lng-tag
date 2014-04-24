package com.panel.note.controller.type;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class DeleteController extends Controller {
    private static final Logger logger = Logger.getLogger(DeleteController.class.getName());

    @Override
    protected Navigation run() throws Exception {
        logger.info("Delete Type Running ....");
        if ( isDelete()){
            logger.info("System.delete");
            Key key  = asKey("id");
            logger.info("Key [ " + key + "]");
            PrintWriter out = response.getWriter();
            Enumeration headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                
                String paramName = (String)headerNames.nextElement();
                 if(paramName.equalsIgnoreCase("id")){
                     String paramValue = request.getHeader(paramName);
                     key  = KeyFactory.stringToKey(paramValue);
                     logger.info("Key [ " + key + "]");
                     Datastore.delete(key);
                 }
             }
            
            
            //Datastore.delete(key);
        }
        logger.info("Delete Type Completed ");
        return null;
    }

}
