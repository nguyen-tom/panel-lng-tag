package com.panel.note.dto.common;

import java.io.Serializable;

public class CompanyDto extends BaseDto implements Serializable{
   
    private String name;
    private String address;
    private String taxCode;
    
    
    
    
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
    public String getTaxCode() {
        return taxCode;
    }
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
    
    
    
}
