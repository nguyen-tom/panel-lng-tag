package com.panel.note.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.panel.note.dto.common.BaseDto;

public class ListObjectRes<T extends BaseDto> extends BaseRes { 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private  List<T> data = new ArrayList<T>();

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
   
    public void add(T elm){
        this.data.add(elm);
    }
}
