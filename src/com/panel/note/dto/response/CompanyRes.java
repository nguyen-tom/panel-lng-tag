package com.panel.note.dto.response;

import java.util.List;

import com.panel.note.dto.common.CompanyDto;

public class CompanyRes extends BaseRes {
    
    private List<CompanyDto> datas;
    
    

    public List<CompanyDto> getDatas() {
        return datas;
    }

    public void setDatas(List<CompanyDto> datas) {
        this.datas = datas;
    }
    
    
   
}
