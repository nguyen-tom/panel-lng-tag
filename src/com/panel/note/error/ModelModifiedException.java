package com.panel.note.error;

import com.panel.note.util.PropertyUtil;

public class ModelModifiedException  extends IllegalArgumentException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String code;
    public ModelModifiedException(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public String getMessage(){
       String mes = PropertyUtil.getProperty(code) ;
       return mes;
    }

}
