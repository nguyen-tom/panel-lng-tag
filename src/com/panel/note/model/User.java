package com.panel.note.model;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.jdo.annotations.Index;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;


@Model(schemaVersion = 1)
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int ADMIN_ROOT = 1;
    public static final int COMPANY_ROOT =2;
    public static final int COMPANY_USER = 3;
    
    public static final int USER_GUEST = 4;
    
    
    @Attribute(primaryKey = true)
    private Key key;  
   
    private String account;
    
    private String password;
     
    private ModelRef<Company> companyRef = new ModelRef<Company>(Company.class);
    
    private int permission = USER_GUEST;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private ModelRef<Language> language =  new ModelRef<Language>(Language.class);
    private String UIUD;
    private String email;
    private String mobilePhone;
    private String urlAvatar;
    
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public ModelRef<Company> getCompanyRef() {
        return companyRef;
    }
   
    public int getPermission() {
        return permission;
    }
    public void setPermission(int permission) {
        this.permission = permission;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public ModelRef<Language> getLanguage() {
        return language;
    }
    public String getUIUD() {
        return UIUD;
    }
    public void setUIUD(String uIUD) {
        UIUD = uIUD;
    }
    public static int getAdminRoot() {
        return ADMIN_ROOT;
    }
    public String getUrlAvatar() {
        return urlAvatar;
    }
    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
    
    
    
    

}
