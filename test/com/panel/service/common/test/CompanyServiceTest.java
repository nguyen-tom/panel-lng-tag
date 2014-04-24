package com.panel.service.common.test;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;
import static org.junit.Assert.*;
import com.panel.note.service.common.CompanyService;
import static org.hamcrest.CoreMatchers.*;

public class CompanyServiceTest extends AppEngineTestCase {
   
    private  CompanyService service  = new CompanyService();
    
    @Test
    public void run() {
       assertThat(service,is(notNullValue()));
       
    }
    

}
