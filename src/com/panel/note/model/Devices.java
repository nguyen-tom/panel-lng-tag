package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Devices implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    private ModelRef<Note> noteRef  = new ModelRef<Note>(Note.class);
    /**
     * longitude khi thiet bi quet 
     */
    private long lng;
    
    /**
     * latitude khi thiet bi quet 
     */
    private long lat;
    
    /**
     * UIUD cua device
     */
    @Attribute()
    private String UIUD;
    
    /**
     * time create
     */
    private Date scanAt;
    
    /**
     * platfrom cua thiet thi
     */
    private String platform;

    private String header;

    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * @return the lng
     */
    public long getLng() {
        return lng;
    }

    /**
     * @return the lat
     */
    public long getLat() {
        return lat;
    }

    /**
     * @return the uIUD
     */
    public String getUIUD() {
        return UIUD;
    }

    /**
     * @return the scanAt
     */
    public Date getScanAt() {
        return scanAt;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(long lng) {
        this.lng = lng;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(long lat) {
        this.lat = lat;
    }

    /**
     * @param uIUD the uIUD to set
     */
    public void setUIUD(String uIUD) {
        UIUD = uIUD;
    }

    /**
     * @param scanAt the scanAt to set
     */
    public void setScanAt(Date scanAt) {
        this.scanAt = scanAt;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the noteRef
     */
    public ModelRef<Note> getNoteRef() {
        return noteRef;
    }

    
    
}
