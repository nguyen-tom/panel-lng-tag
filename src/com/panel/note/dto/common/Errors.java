package com.panel.note.dto.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="errors")
public class Errors implements Serializable{

    private static final long serialVersionUID = 1L;
    @ElementList(inline = true, required=false, entry="error")
    private List<Error> error;        

        
    /**
     * 
     */
    public Errors() {
        super();
        this.error = new ArrayList<Error>();
    }

    /**
     * @return errors
     */
    public List<Error> getError() {
        return error;
    }

    /**
     * @param error 
     */
    public void setError(Error value) {
        if (error == null) {
            error = new ArrayList<Error>();
        }
        if(!error.contains(value)){
            error.add(value);
        }
    }
    
    /**
    * 

    * @param value 
    */
    public void setError(List<Error> value) {
        this.error = value;
    }
    
}
