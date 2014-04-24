package com.panel.note.dto.response;


import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.panel.note.dto.common.Errors;




@Root
public class BaseRes implements Serializable{

    private static final long serialVersionUID = 4768546705685572189L;
    @Element(required=false)
    private Long time;     
    @Element(required=false)
    private Integer result;     
    @Element(required=false)
    private Errors errors;        

   
    public BaseRes(Long time, Integer result, Errors errors) {
        super();
        this.time = time;
        this.result = result;
        this.errors = errors;
    }

    /**
     * 
     */
    public BaseRes() {
        super();
        this.errors = new Errors();
    }

    
     public Long getTime() {
         return time;
     }

     public void setTime(Long time) {
         this.time = time;
     }

    
     public Integer getResult() {
         return result;
     }

     
     public void setResult(Integer result) {
         this.result = result;
     }

     
    public Errors getErrors() {
        if (errors == null) {
            errors = new Errors();
        }
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
