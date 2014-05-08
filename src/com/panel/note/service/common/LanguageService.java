package com.panel.note.service.common;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.dao.common.LanguageDao;
import com.panel.note.dto.common.Error;
import com.panel.note.dto.common.Errors;
import com.panel.note.dto.common.LanguageDto;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.dto.response.ListObjectRes;
import com.panel.note.error.ModelModifiedException;
import com.panel.note.error.SystemError;
import com.panel.note.model.Language;
import com.panel.note.util.Const;

public class LanguageService {

    public BaseRes insertUser(BaseRes baseRes,
            String name,
            String description) throws SystemError{
                String code = "200";
                Errors errors = new Errors();
                
                try{
                      Language language  = new Language();
                      language.setName(name);
                      language.setDescription(description);
                      language.setCreateAt(new Date());
                      language.setUpdateAt(new Date());
                 
               
                   //set up Language for User
                
                   LanguageDao dao  = new LanguageDao();
                   language.setKey(dao.createKey(name));
                   dao.insertLanguage(language);
                
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
   public ListObjectRes<LanguageDto> getAllLanguage(ListObjectRes<LanguageDto> baseRes){
       String code = "200";
       Errors errors = new Errors();
       try{
           LanguageDao dao  = new LanguageDao();
           List<Language> list  = dao.get();
           
           for(Language item : list){
               LanguageDto dto  = new LanguageDto();
               dto.setKey(KeyFactory.keyToString(item.getKey()));
               dto.setName(item.getName());
               dto.setDescription(item.getDescription());
               baseRes.add(dto);
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
