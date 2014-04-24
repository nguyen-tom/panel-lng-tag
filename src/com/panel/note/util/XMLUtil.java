package com.panel.note.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
  
public class XMLUtil {  
    
    /*
     * XML String to Object
     */
    public static <T> T xmlStringToDto(String xmlStr,Class<T> clazz) throws Exception{
        Serializer serializer = new Persister();
        T ret = (T)serializer.read(clazz, xmlStr);
         
         return ret;
    }
    
    /*
     * Object to XML String
     */
    public static <T> String dtoToXmlString(T dto) throws Exception{
         String ret = "";
         
         Serializer serializer = new Persister(); 
         ByteArrayOutputStream  out = new ByteArrayOutputStream();
         serializer.write(dto, out);
         
         try {
             ret = out.toString(PropertyUtil.getProperty("ENCODING"));
             //ret = new String(out.toByteArray(), PropertyUtil.getProperty("ENCODING"));
        } catch (UnsupportedEncodingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
         
         return ret;
    }

    public static String escape(String xmlstr) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i < xmlstr.length();i++)
        {
           char c = xmlstr.charAt(i);
           if(c == '&')
               buffer.append("&amp;");
           else if(c == '<')
              buffer.append("&lt;");
           else if(c == '>')
              buffer.append("&gt;");
           else if(c == '"')
              buffer.append("&quot;");
           else if(c == '\'')
              buffer.append("&apos;");
           else
              buffer.append(c);
        }
        return buffer.toString();
    }
} 
