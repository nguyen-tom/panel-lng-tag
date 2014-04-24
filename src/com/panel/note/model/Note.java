package com.panel.note.model;
import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PrimaryKey;


import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Note implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    @Attribute(version = true)
    private Long version;
    
    private ModelRef<Type> typeRef =  new ModelRef<Type>(Type.class); 
    private ModelRef<User> userRef = new ModelRef<User>(User.class); 
    
    private long lng;
    private long lat;
    private String key_encode;
    
    
    
    private boolean enable;
    private Date startAt;
    private Date endAt;
    
    private Date createAt;
    private Date updateAt;
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
     * @return the lng
     */
    public long getLng() {
        return lng;
    }
    /**
     * @param lng the lng to set
     */
    public void setLng(long lng) {
        this.lng = lng;
    }
    /**
     * @return the lat
     */
    public long getLat() {
        return lat;
    }
    /**
     * @param lat the lat to set
     */
    public void setLat(long lat) {
        this.lat = lat;
    }
    /**
     * @return the key_encode
     */
    public String getKey_encode() {
        return key_encode;
    }
    /**
     * @param key_encode the key_encode to set
     */
    public void setKey_encode(String key_encode) {
        this.key_encode = key_encode;
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
     * @return the startAt
     */
    public Date getStartAt() {
        return startAt;
    }
    /**
     * @param startAt the startAt to set
     */
    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }
    /**
     * @return the endAt
     */
    public Date getEndAt() {
        return endAt;
    }
    /**
     * @param endAt the endAt to set
     */
    public void setEndAt(Date endAt) {
        this.endAt = endAt;
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
    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }
    /**
     * @return the typeRef
     */
    public ModelRef<Type> getTypeRef() {
        return typeRef;
    }
    /**
     * @return the userRef
     */
    public ModelRef<User> getUserRef() {
        return userRef;
    }
    
   

}
