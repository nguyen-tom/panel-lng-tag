package com.panel.note.dao.common;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.panel.note.model.Agent;

public class AgentDao {
    
    public void insertAgent(Key keyCompany,String email,String password,String level){
        Agent agent  = new Agent();
        agent.setEmail(email);
        agent.setPassword(password);
        agent.setLevel(level);
        agent.getCompanyRef().setKey( keyCompany);        
        Key key = Datastore.put(agent);
    }

}
