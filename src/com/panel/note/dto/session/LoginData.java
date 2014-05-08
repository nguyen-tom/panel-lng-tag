package com.panel.note.dto.session;

import java.io.Serializable;

public class LoginData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String sessionEmail;
    private String sessionLevel;
    private String sessionShopId;
    private long   loginAt;
    
    public String getSessionEmail() {
        return sessionEmail;
    }
    public void setSessionEmail(String sessionEmail) {
        this.sessionEmail = sessionEmail;
    }
    public String getSessionLevel() {
        return sessionLevel;
    }
    public void setSessionLevel(String sessionLevel) {
        this.sessionLevel = sessionLevel;
    }
    public String getSessionShopId() {
        return sessionShopId;
    }
    public void setSessionShopId(String sessionShopId) {
        this.sessionShopId = sessionShopId;
    }
    public long getLoginAt() {
        return loginAt;
    }
    public void setLoginAt(long loginAt) {
        this.loginAt = loginAt;
    }
    
    
    
  
}
