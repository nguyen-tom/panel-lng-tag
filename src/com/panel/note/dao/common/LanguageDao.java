package com.panel.note.dao.common;

import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.FilterCriterion;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.Key;
import com.panel.note.error.ModelModifiedException;
import com.panel.note.error.SystemError;
import com.panel.note.meta.LanguageMeta;
import com.panel.note.model.Language;
import com.panel.note.util.Const;

public class LanguageDao extends DaoBase<Language> {
    private static final Logger logger = Logger.getLogger(LanguageDao.class.getName());
    
    private  String accessNamespace = Const.NAMESPACE_GLOBAL;

    public LanguageDao() {

    }

    public List<Language> get(List<Key> keys) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return get(keys);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }
    public List<Language> get() {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            LanguageMeta m = LanguageMeta.get();
            return Datastore.query(m).asList();
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }

    public Key createKey(String account) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return Datastore.createKey(Language.class, account );
        }finally{
            NamespaceManager.set(beforeNS);
        }

    }

    public List<Language> findList(FilterCriterion fc) {
        String beforeNS = NamespaceManager.get();
        List<Language> list = null;
        try{
            NamespaceManager.set(accessNamespace);
            list = query().filter(fc).asList();
        }finally{
            NamespaceManager.set(beforeNS);
        }
        return list;
    }
    public Future<List<Key>> putAsync(List<Language> models) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return putAsync(models);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }
    public Language findLanguage(String name){
        try{
            NamespaceManager.set(accessNamespace);
            Key key  = this.createKey(name);
            Language findLanguage  = Datastore.get(Language.class,key);
            if(findLanguage != null) return findLanguage;
        }catch(Exception e){
            logger.info(e.toString());
        }
       
      return null;
    }
   public void updateLanguage(Language Language) throws IllegalArgumentException {
       if(Language.getKey() == null){
           logger.info("Key Language Null");
           throw new ModelModifiedException("EM211");
       }
       
   }
   public void insertLanguage(Language lang) throws SystemError{
       
      if(lang.getName() == null) throw new ModelModifiedException("EM203");
      if(lang.getDescription() == null ) throw new ModelModifiedException("EM202");
      if(     lang.getName().equalsIgnoreCase("") || 
              lang.getDescription().equalsIgnoreCase("") 
              ){
          throw new ModelModifiedException("EM208");
      }
       
      String name  = lang.getName();
     if(this.findLanguage(name) ==  null){
          Datastore.put(lang);
      }
     else {
         throw new ModelModifiedException("EM210");
     }
      
   }

}
