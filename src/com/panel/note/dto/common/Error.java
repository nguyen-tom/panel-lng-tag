package com.panel.note.dto.common;

import java.io.Serializable;

import org.simpleframework.xml.Element;

import org.simpleframework.xml.Root;
@Root(name="error")
public class Error implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Element(required=false)
    private String code;
    
    @Element(required=false)
    private String message;
    
    /**
     * @param code
     * @param message
     */
    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    /**
     * 
     */
    public Error() {
        super();
    }

    /**

     */
     public String getCode() {
         return code;
     }

     /**

     */
     public void setCode(String code) {
         this.code = code;
     }

     /**

     */
     public String getMessage() {
         return message;
     }

     /**

     */
     public void setMessage(String message) {
         this.message = message;
     }
    

}
