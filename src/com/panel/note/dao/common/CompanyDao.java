package com.panel.note.dao.common;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.Key;
import com.panel.note.meta.CompanyMeta;
import com.panel.note.model.Company;
import com.panel.note.model.Type;
import com.panel.note.util.Const;

public class CompanyDao extends DaoBase<Company> {
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());
   
    public void insetCompany(Company company) throws Exception{
            String name  = company.getName();
            String address  = company.getAddress();
            if(name == null || name.equalsIgnoreCase("")) throw new IllegalArgumentException("Error Name Company");
            if(address == null || address.equalsIgnoreCase("") )  throw new IllegalArgumentException("Error Address Company");
            NamespaceManager.set(Const.NAMESPACE_GLOBAL);
            Key key = Datastore.put(company);
            if(key == null) throw new  IllegalArgumentException("Insert Company Error ");
    }
    public Company getCompany(String name) throws Exception{
        try{
            if(name == null || name.equalsIgnoreCase("")) throw new IllegalArgumentException("Error Name Company");
            NamespaceManager.set(Const.NAMESPACE_GLOBAL);
            Key key  = createKey(name);
            return Datastore.get(Company.class,key);
        }catch(Exception e){
            throw e;
        }
    }
    public Company getCompany(Key key) throws Exception{
        try{
            if(key == null) throw new IllegalArgumentException("Error Name Company");
            NamespaceManager.set(Const.NAMESPACE_GLOBAL);
            return Datastore.get(Company.class,key);
        }catch(Exception e){
            throw e;
        }
    }
    public List<Company> getAllCompanies() throws Exception {
        try{
            NamespaceManager.set(Const.NAMESPACE_GLOBAL);
            return Datastore.query(Company.class).asList();
        }catch(Exception e){
            throw e;
        }
        
    }
    
    public Key createKey(String name) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(Const.NAMESPACE_GLOBAL);
            return Datastore.createKey(Type.class,name );
        }finally{
            NamespaceManager.set(beforeNS);
        }

    }

}
