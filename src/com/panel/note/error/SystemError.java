package com.panel.note.error;

import com.panel.note.util.PropertyUtil;

public class SystemError extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String code  = "ES500";
    public SystemError(String code){
        this.code  = code;
    }
    public String getCode(){
        return this.code;
    }
    public String getMessage(){
        return PropertyUtil.getProperty(code);
    }

}
