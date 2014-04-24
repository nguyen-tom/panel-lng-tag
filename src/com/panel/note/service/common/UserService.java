package com.panel.note.service.common;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.error.ModelModifiedException;
import com.panel.note.model.Company;
import com.panel.note.model.Language;
import com.panel.note.model.User;
import com.panel.note.util.Const;
import com.panel.note.util.StrUtil;

public class UserService {
    
    public BaseRes insertUser( BaseRes baseRes,
                               String account,
                               String password,
                               String email,
                               String firstName,
                               String lastName,
                               String keyCompany,
                               String keyLanguage,
                               String address,
                               String mobilePhone,
                               String UIUD,
                               int    permission,
                               String    city){
       
        String code = "200";
        Errors errors = new Errors();
        
        try{
            User user  = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setAddress(address);
            user.setCity(city);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMobilePhone(mobilePhone);
            user.setPermission(permission);
            user.setUIUD(UIUD);
            if(StrUtil.strIsNull(keyLanguage)) throw new ModelModifiedException("EM212");
            //set up Language for User
            Key keyLang  = KeyFactory.stringToKey(keyLanguage);
            Language  language  = Datastore.get(Language.class,keyLang);
            if(language == null)throw new ModelModifiedException("EM212");
            user.getLanguage().setModel(language);
           
            if(!StrUtil.strIsNull(keyCompany)) {
                Key companyKey  = KeyFactory.stringToKey(keyLanguage);
                Company  company  = Datastore.get(Company.class,companyKey);
                if(language != null) user.getCompanyRef().setModel(company);
            }
        }catch(ModelModifiedException e){
            code = e.getCode();
            Error error  = new Error();
            error.setCode(code);
            error.setMessage(e.getMessage());
            errors.setError(error);
        }
       baseRes.setErrors(errors);
       if(code.equalsIgnoreCase("200")) baseRes.setResult(Const.RESULT_OK);
       return baseRes;
    }
}
