package com.panel.note.service.common;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.dao.common.CompanyDao;
import com.panel.note.dto.common.CompanyDto;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.dto.response.CompanyRes;
import com.panel.note.model.Company;
import com.panel.note.util.Const;


public class CompanyService {
   
    private BaseRes baseRes;
    
    public BaseRes  insertCompany(Company company){
        CompanyDao  dao  = new CompanyDao();
        baseRes = new BaseRes();
        baseRes.setTime(System.currentTimeMillis());
        Error error;
        Errors errors  = new Errors();
        try{
            dao.insetCompany(company);
            baseRes.setResult(Const.RESULT_OK);
            
        }catch(Exception e){
            baseRes.setResult(Const.RESULT_FAIL);
             error  = new Error("20",e.toString());
             errors.setError(error);
             baseRes.setErrors(errors);
        }
        return baseRes;
    }
    public BaseRes updateCompany(Key key,Company company){
        CompanyDao  dao  = new CompanyDao();
        baseRes = new BaseRes();
        baseRes.setTime(System.currentTimeMillis());
        Error error;
        Errors errors  = new Errors();
        try{
            dao.insetCompany(company);
            baseRes.setResult(Const.RESULT_OK);
        }catch(Exception e){
            baseRes.setResult(Const.RESULT_FAIL);
             error  = new Error("20",e.toString());
             errors.setError(error);
             baseRes.setErrors(errors);
        }
        return baseRes;
    }
    public CompanyRes getAllCompanies(){
        CompanyDao  dao  = new CompanyDao();
        CompanyRes companyRes  = new CompanyRes();
        companyRes.setTime(System.currentTimeMillis());
        Error error;
        Errors errors  = new Errors();
        try{
            List<Company> companies  = dao.getAllCompanies();
            List<CompanyDto> compsDto = new LinkedList<CompanyDto>();
            if(companies != null){
                for (Company company : companies){
                    compsDto.add(createCompanyDto(company));
                }
                companyRes.setDatas(compsDto);
            }
           companyRes.setResult(Const.RESULT_OK);
        }catch(Exception e){
            companyRes.setResult(Const.RESULT_FAIL);
            error  = new Error("20",e.toString());
            errors.setError(error);
            companyRes.setErrors(errors);
        }
        return companyRes;
    }
    private CompanyDto createCompanyDto(Company company) throws Exception {
        if(company == null || company.getKey() == null) throw new IllegalArgumentException("Company convert dto error");
       CompanyDto companyDto  = new CompanyDto();
       companyDto.setAddress(company.getAddress());
       companyDto.setKey(KeyFactory.keyToString(company.getKey()));
       companyDto.setName(company.getName());
       companyDto.setTaxCode(company.getTaxCode());
       return companyDto;
       
    }
    

}
