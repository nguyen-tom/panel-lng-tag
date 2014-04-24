package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Language implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    private String name;
    
    private String description;
    
    private String keyEncode;
    
    private String currency;
    
    private Date   createAt;
    
    private Date   updateAt;
    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }
    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the keyEncode
     */
    public String getKeyEncode() {
        return keyEncode;
    }
    /**
     * @param keyEncode the keyEncode to set
     */
    public void setKeyEncode(String keyEncode) {
        this.keyEncode = keyEncode;
    }
    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }
    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    /**
     * @return the createAt
     */
    public Date getCreateAt() {
        return createAt;
    }
    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    /**
     * @return the updateAt
     */
    public Date getUpdateAt() {
        return updateAt;
    }
    /**
     * @param updateAt the updateAt to set
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    
    
    

}
