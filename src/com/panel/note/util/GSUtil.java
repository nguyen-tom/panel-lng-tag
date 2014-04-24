package com.panel.note.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.upload.FileItem;
import org.slim3.util.ThrowableUtil;

import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.LockException;
import com.google.appengine.api.files.GSFileOptions.GSFileOptionsBuilder;

public class GSUtil {
    
    private static final String CHARSET_DEFAULT = "UTF8";

    private GSUtil(){}
    
    
    public static void saveFileToGCS(byte[] data, GSFileOptionsBuilder builder) throws Exception{
        if (data == null || builder == null) {
            throw new NullPointerException("The data parameter and the builder parameter must NOT be empty.");
        }
        FileService fileService = FileServiceFactory.getFileService();
        AppEngineFile gsFile = fileService.createNewGSFile(builder.build());
        
        FileWriteChannel channel = null;
        try {
            channel = fileService.openWriteChannel(gsFile, true);
            channel.write(ByteBuffer.wrap(data));
            channel.closeFinally();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (channel != null) {
                channel.close();
            }
        }
    }

    public static List<String> getLines(String storagePath) throws FileNotFoundException, LockException, IOException {
        return getLines(storagePath, CHARSET_DEFAULT);
    }
    
    public static List<String> getLines(String storagePath,String charset) throws FileNotFoundException, LockException, IOException{
        List<String> lines = new ArrayList<String>();
        
        FileReadChannel channel = null;
        BufferedReader reader = null;
        try {
            
            AppEngineFile appEngineFile = new AppEngineFile(storagePath);
            FileService fileService = FileServiceFactory.getFileService();
            channel = fileService.openReadChannel(appEngineFile, false);
            reader = new BufferedReader(Channels.newReader(channel,charset));
            lines = readLines(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (channel != null && channel.isOpen()) {
                channel.close();
            }
        }
        return lines;
    }
    
    
    public static List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = BlobUtil.buildRecord(reader)) != null) {
            lines.add(line);
        }
        return lines;
    }


}
