package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Type  implements Serializable {
    
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    
    private String name;
    private String description;
    private int maxItem;
    private int minItem;
    private boolean enable;
    
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
     * @return the maxItem
     */
    public int getMaxItem() {
        return maxItem;
    }
    /**
     * @param maxItem the maxItem to set
     */
    public void setMaxItem(int maxItem) {
        this.maxItem = maxItem;
    }
    /**
     * @return the minItem
     */
    public int getMinItem() {
        return minItem;
    }
    /**
     * @param minItem the minItem to set
     */
    public void setMinItem(int minItem) {
        this.minItem = minItem;
    }
    /**
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }
    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
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
