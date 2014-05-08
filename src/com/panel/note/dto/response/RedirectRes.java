package com.panel.note.dto.response;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.panel.note.dto.common.Errors;

@Root(name = "response")
public class RedirectRes extends BaseRes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Element(required=false)
    private String redirect; 

    /**
     * @param errors 
     * @param result 
     * @param time 
     * @param redirect 
     */
    public RedirectRes(Long time, Integer result, Errors errors, String redirect) {
        super(time, result, errors);
        this.redirect = redirect;
    }

    public RedirectRes() {
        super();
    }

    
    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

}
