package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;


@Model(schemaVersion = 1)
public class Detail implements Serializable{

    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    private String description;
    private int price;
    private List<String> imgs;
    private Date createAt;
    private Date updateAt;
    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @return the imgs
     */
    public List<String> getImgs() {
        return imgs;
    }
    /**
     * @return the createAt
     */
    public Date getCreateAt() {
        return createAt;
    }
    /**
     * @return the updateAt
     */
    public Date getUpdateAt() {
        return updateAt;
    }
    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @param imgs the imgs to set
     */
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    /**
     * @param updateAt the updateAt to set
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    
    
}
