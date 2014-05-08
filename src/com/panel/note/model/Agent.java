package com.panel.note.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;


@Model(schemaVersion = 2)
public class Agent  implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    
    @Attribute(version = true)
    private Long version;
    
    
    private String email;
    private String password;
    private String level;
    private ModelRef<Company> companyRef = new ModelRef<Company>(Company.class);
    
    
    
    
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public ModelRef<Company> getCompanyRef() {
        return companyRef;
    }
    
    
    
    

}
