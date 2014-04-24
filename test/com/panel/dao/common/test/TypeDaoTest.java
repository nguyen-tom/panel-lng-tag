package com.panel.dao.common.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;
import com.panel.note.dao.common.TypeDao;
import com.panel.note.model.User;

public class TypeDaoTest extends AppEngineTestCase{
    private TypeDao dao;
    @Before
    public void setup(){
        System.out.println("create Dao ");
        dao  = new TypeDao();
    }
    @Test
    public void run() throws Exception  {
     
     assertThat(dao,is(notNullValue()));
     User user1  = new User();
     double account  = Math.random() * 0.09 * Math.random() ;
     String acc  = String.format("acc-%5f", account);
     user1.setAccount(acc);
     user1.setEmail("nguyen.thom@mulodo.com");
     user1.setPassword("vanthom123");
     user1.setCity("TP HCM");
     try{
        Key key =  dao.createKey("DADIKHKKHH");
        assertThat(key,is(notNullValue()));
     }catch(Exception e){
         System.out.println(e.toString());
     }
     
     
     
     
     
     
    }
}
