package com.panel.note.dto.common;

import java.io.Serializable;

public class LanguageDto extends BaseDto implements Serializable{
 
   /**
     * 
     */
    private static final long serialVersionUID = 1L;
private String name;
   private String description;
   
   
   
public String getKey() {
    return key;
}
public void setKey(String key) {
    this.key = key;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
   
   
   
}
