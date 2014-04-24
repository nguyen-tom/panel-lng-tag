package com.panel.note.dao.common;

import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;
import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.FilterCriterion;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyRange;
import com.panel.note.meta.TypeMeta;
import com.panel.note.model.Type;
import com.panel.note.util.Const;


public class TypeDao   extends DaoBase<Type> {
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());

    private String accessNamespace;

    public TypeDao() {

    }

    public TypeDao(String accessNamespace) {
        this.accessNamespace= accessNamespace;
    }

    public static String getAccessNamespace(String shopId, Boolean globalBlackFlg) {
        String namespace = shopId;
        if (globalBlackFlg == null || globalBlackFlg.booleanValue()) {
            namespace = Const.NAMESPACE_FOLE;
        }
        return namespace;
    }

    public List<Type> get(List<Key> keys) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return get(keys);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }

    public Key createKey(String name) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return Datastore.createKey(Type.class,name );
        }finally{
            NamespaceManager.set(beforeNS);
        }

    }
    

    public List<Type> findList(FilterCriterion fc) {
        String beforeNS = NamespaceManager.get();
        List<Type> list = null;
        try{
            NamespaceManager.set(accessNamespace);
            list = query().filter(fc).asList();
        }finally{
            NamespaceManager.set(beforeNS);
        }
        return list;
    }

    public Key allocateId() {
        String namespace = NamespaceManager.get();
        Key key;
        try{
            NamespaceManager.set(accessNamespace);
            KeyRange typeKeys = DatastoreServiceFactory.getDatastoreService().allocateIds("Type", 1);
            key = typeKeys.getStart();
        }finally{
            NamespaceManager.set(namespace);
        }
        return key;
    }

    public Future<List<Key>> putAsync(List<Type> models) {
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            return putAsync(models);
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }
    public List<Type> getList(){
        String beforeNS = NamespaceManager.get();
        try{
            NamespaceManager.set(accessNamespace);
            TypeMeta m = TypeMeta.get();
            return Datastore.query(m).asList();
            
        }finally{
            NamespaceManager.set(beforeNS);
        }
    }
    
    
   

   

}