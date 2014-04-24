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
import com.panel.note.model.User;
import com.panel.note.util.Const;
import com.panel.note.util.StrUtil;

public class UserDao  extends DaoBase<User> {
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());
    //default user must input in global
   private  String accessNamespace = Const.NAMESPACE_GLOBAL;

    public UserDao() {

    }

    public List<User> get(List<Key> keys) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return get(keys);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }

    public Key createKey(String account,String passowrd) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return Datastore.createKey(User.class, account + passowrd);
        }finally{
            NamespaceManager.set(beforeNS);
        }

    }

    public List<User> findList(FilterCriterion fc) {
        String beforeNS = NamespaceManager.get();
        List<User> list = null;
        try{
            NamespaceManager.set(accessNamespace);
            list = query().filter(fc).asList();
        }finally{
            NamespaceManager.set(beforeNS);
        }
        return list;
    }
    public Future<List<Key>> putAsync(List<User> models) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return putAsync(models);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }
    public User findUser(String account,String passowrd){
        Key key  = this.createKey(account,passowrd);
       // User findUser  = Datastore.get(User.class,key);
       // if(findUser != null) return findUser;
        return null;
    }
   public void updateUser(User user) throws IllegalArgumentException {
       if(user.getKey() == null){
           logger.info("Key User Null");
           throw new ModelModifiedException("EM211");
       }
       
   }
   public void insertUser(User user) throws SystemError{
       
      if(user.getAccount() == null) throw new ModelModifiedException("EM203");
      if(user.getPassword() == null ) throw new ModelModifiedException("EM202");
      if(     user.getPassword().equalsIgnoreCase("") || 
              user.getAccount().equalsIgnoreCase("") || 
              user.getEmail().equalsIgnoreCase("") ){
          throw new ModelModifiedException("EM208");
      }
       if(!StrUtil.isValidateEmail(user.getEmail())) throw new IllegalArgumentException("EM209");
      String account  = user.getAccount();
      String password = user.getPassword();
     if(this.findUser(account,password) ==  null){
          Datastore.put(user);
      }
     else {
         throw new ModelModifiedException("EM210");
     }
      
   }
   
   

   

}