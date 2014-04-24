package com.panel.note.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class StrUtil {
    public static final String FORMAT_DATETIME = "dd/MM/yyyy HH:mm:ss";

    public static final String ENCODING = PropertyUtil.getProperty("ENCODING");
    
    public static Date string2date(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);  
        try {  
            return sdf.parse(value);  
        } catch (ParseException e) {  
            return null;  
        }  
    } 
    public static String getSigniture(String target, String hash_method) throws Exception {
        String result = "";
        
        if (hash_method.toUpperCase().endsWith("SHA1")) {
            hash_method = "SHA-1";
        }
        
        if (hash_method.toUpperCase().endsWith("SHA256")) {
            hash_method = "SHA-256";
        }
        
        byte[] binary = target.getBytes(Charset.forName("UTF-8"));
        MessageDigest md = null;
        try {
                md = MessageDigest.getInstance(hash_method);
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        }
        byte[] digest = md.digest(binary);
        result = parseByte2HexStr(digest);
        
        return result;
    }
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    public static byte[] parseHex2Byte(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int index = 0; index < bytes.length; index++) {
            bytes[index] =
                (byte) Integer.parseInt(hex.substring(
                    index * 2,
                    (index + 1) * 2), 16);
        }
        return bytes;
    }
    public static String serialize(Object toSerialize) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(toSerialize);

        return StrUtil.parseByte2HexStr(baos.toByteArray());
    }
    public static boolean strIsNull(String argStr) {
        boolean resFlg = false;
        
        if (argStr != null) {
            if (argStr.trim().length() == 0) {
                resFlg = true;
            }
        } else {
            resFlg = true;
        }
        
        return resFlg;
    }
    public static  boolean isValidateEmail(String email){
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(EMAIL_REGEX);
    }


}
