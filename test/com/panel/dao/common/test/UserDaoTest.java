package com.panel.dao.common.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.CompanyDao;
import com.panel.note.model.Company;


public class UserDaoTest extends AppEngineTestCase{
    private static CompanyDao dao;
    
    @Before
    public void setup(){
        System.out.println("create Dao ");
        dao  = new CompanyDao();
       
    }
    @Test
    public void run() throws Exception  {
     
     assertThat(dao,is(notNullValue()));
     Company user1  = new Company();
     user1.setName("abcd");
     user1.setTaxCode("7878889");
     user1.setAddress("dasdsakdfsajfsad");
     user1.setVersion(Long.decode("3"));
     Key key  = dao.createKey("abc");
     user1.setKey(key);
     Key key1  = Datastore.put(user1);
         
         
     
    }
}
