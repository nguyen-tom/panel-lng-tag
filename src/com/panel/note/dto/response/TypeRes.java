package com.panel.note.dto.response;

import java.io.Serializable;
import java.util.List;

import com.panel.note.model.Type;


/**
 * 
 * @author Tom Nguyen
 * @since 18/03/2014
 *
 */
public class TypeRes extends BaseRes implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * list result
     */
    private List<Type> listType;

    /**
     * @return the listType
     */
    public List<Type> getListType() {
        return listType;
    }

    /**
     * @param listType the listType to set
     */
    public void setListType(List<Type> listType) {
        this.listType = listType;
    }
    
    
    
    
}
