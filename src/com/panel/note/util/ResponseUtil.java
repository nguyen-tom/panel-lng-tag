package com.panel.note.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import net.arnx.jsonic.JSON;

import org.slim3.util.ThrowableUtil;

import com.panel.note.dto.response.BaseRes;

public class ResponseUtil {
    
    private static final String TYPE_JSON = "json";
    private static final String TYPE_XML = "xml";
    private static final String CONTENT_TYPE_JSON = "application/json; charset=";
    private static final String CONTENT_TYPE_XML = "application/xml; charset=";
    
    /*
     * Object to JsonResponse
     */
    public static void dtoToResponse(String format, BaseRes res, HttpServletRequest request, HttpServletResponse response ) throws IOException{
        try {
            if (null != format && format.equalsIgnoreCase(TYPE_XML)) {
                dtoToXmlResponse(res, request, response);
            } else {
                dtoToJsonResponse(res, request, response);
            }
        } catch (Exception e) {
            ThrowableUtil.wrapAndThrow(e);
        }
    }
    
    /*
     * Object to JsonResponse
     */
    public static void dtoToJsonResponse(BaseRes dto,HttpServletRequest request, HttpServletResponse response ) throws IOException{
        
        String encoding = request.getCharacterEncoding();
        if (encoding == null) {
            encoding = PropertyUtil.getProperty("ENCODING");
        }

        response.setContentType(CONTENT_TYPE_JSON +encoding);
        try {
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response
                        .getOutputStream(), encoding));
                Long start = dto.getTime();
                Long stop = System.currentTimeMillis();
                dto.setTime(stop-start);
                out.print(JSON.encode(dto));
                out.flush();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } catch (IOException e) {
            ThrowableUtil.wrapAndThrow(e);
        }
    }
    
    /*
     * Object to XML Response
     */
    public static void dtoToXmlResponse(BaseRes dto,HttpServletRequest request, HttpServletResponse response ) throws Exception{
        
        String encoding = request.getCharacterEncoding();
        if (encoding == null) {
            encoding = PropertyUtil.getProperty("ENCODING");
        }

        response.setContentType(CONTENT_TYPE_XML + encoding);
        try {
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response
                        .getOutputStream(), encoding));
                try {
                      Long start = dto.getTime();
                      //���������������������������������������������������������������������������������
                      Long stop = System.currentTimeMillis();
                      dto.setTime(stop-start);
                    out.print(XMLUtil.dtoToXmlString(dto));
                    out.flush();
                } catch (JAXBException e) {
                    ThrowableUtil.wrapAndThrow(e);
                }
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } catch (IOException e) {
            ThrowableUtil.wrapAndThrow(e);
        }
    }
}
