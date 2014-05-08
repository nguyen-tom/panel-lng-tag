package com.panel.note.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.panel.note.meta.AgentMeta;

@Model(schemaVersion = 2)
public class Company  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    
    @Attribute(version = true)
    private Long version;
    
    private String name;
    private String address;
    private String website;
    private String taxCode;
    private Boolean invalid = false;
    
    
    @Attribute(persistent=false)
    private InverseModelListRef<Agent, Company> operatorsRef =
      new InverseModelListRef<Agent, Company>(Agent.class, AgentMeta.get().companyRef, this);
    
    private Date join;
    
    
    
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getTaxCode() {
        return taxCode;
    }
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
    public Date getJoin() {
        return join;
    }
    public void setJoin(Date join) {
        this.join = join;
    }
    public Boolean getInvalid() {
        return invalid;
    }
    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }
    public InverseModelListRef<Agent, Company> getOperatorsRef() {
        return operatorsRef;
    }
   

}
