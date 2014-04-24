package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;
@Model(schemaVersion = 1)
public class Item implements Serializable{

    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    private ModelRef<Note> noteRef  = new ModelRef<Note>(Note.class);
    private ModelRef<Language> langRef  = new ModelRef<Language>(Language.class);
    private ModelRef<Detail> detailRef  = new ModelRef<Detail>(Detail.class);
    
    private String content;
    private String note;
    private String countLike;
    private String description;
    
    
    private Date createAt;
    private Date updateAt;
    private boolean enable;
    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }
    /**
     * @return the countLike
     */
    public String getCountLike() {
        return countLike;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
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
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }
    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * @param countLike the countLike to set
     */
    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    /**
     * @return the noteRef
     */
    public ModelRef<Note> getNoteRef() {
        return noteRef;
    }
    /**
     * @return the langRef
     */
    public ModelRef<Language> getLangRef() {
        return langRef;
    }
    /**
     * @param noteRef the noteRef to set
     */
    /**
     * @return the detailRef
     */
    public ModelRef<Detail> getDetailRef() {
        return detailRef;
    }
    
}
