package com.panel.note.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.LinkedList;
import java.util.List;

import org.slim3.controller.upload.FileItem;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.LockException;

public final class BlobUtil {

    public static List<String> loadCSV(String inputPath) throws FileNotFoundException, LockException, IOException {
        FileService fileService = FileServiceFactory.getFileService();
        AppEngineFile file = new AppEngineFile(inputPath);
        FileReadChannel readChannel = fileService.openReadChannel(file, false);
        
        List<String> lines = new LinkedList<String>();
        BufferedReader reader =
                new BufferedReader(Channels.newReader(readChannel, "UTF8"));
        String inputLine;
         while ( ( inputLine = buildRecord(reader)) != null) {
             lines.add(inputLine);
         }
        readChannel.close();
        return lines;
        // Now read from the file using the Blobstore API
//        BlobKey blobKey = fileService.getBlobKey(file);
//        BlobstoreService blobStoreService = BlobstoreServiceFactory.getBlobstoreService();
//        String segment = new String(blobStoreService.fetchData(blobKey, 30, 40));
    }

   
    public static LinkedList<String> splitRecord(String src, String delimeter) {
        LinkedList<String> dest = new LinkedList<String>(); 
        String[] columns = src.split(delimeter,-1);
        int maxlen = columns.length;
        int startPos, endPos, columnlen;
        StringBuilder buff = new StringBuilder();
        String column;
        boolean isInString, isEscaped;
        for (int index = 0; index < maxlen; index++) {
            column = columns[index];
            if ((endPos = column.indexOf("\"")) < 0){
                dest.addLast(column);
            } else {
                isInString = (endPos == 0);
                isEscaped = false;
                columnlen = column.length();
                buff.setLength(0);
                startPos = (isInString) ? 1 : 0;
                while (startPos < columnlen) {
                    if (0 <= (endPos = column.indexOf("\"", startPos))) {
                        buff.append((startPos < endPos) ? column.substring(
                                startPos, endPos) : isEscaped ? "\"" : "");
                        isEscaped = !isEscaped;
                        isInString = !isInString;
                        startPos = ++endPos;
                    } else {
                        buff.append(column.substring(startPos));
                        if (isInString && index < maxlen - 1) {
                            column = columns[++index];
                            columnlen = column.length();
                            buff.append(delimeter);
                            startPos = 0;
                        } else {
                            break;
                        }
                    }
                }
                dest.addLast(buff.toString());
            }
        }
        return dest;
    }

    public static String buildRecord(BufferedReader reader) throws IOException {
        String result = reader.readLine();
        int pos;
        if (result != null && 0 < result.length()
                && 0 <= (pos = result.indexOf("\""))) {
            boolean inString = true;
            String rawline = result;
            String newline = null;
            StringBuilder buff = new StringBuilder();
            while (true) {
                while (0 <= (pos = rawline.indexOf("\"", ++pos))) {
                    inString = !inString;
                }
                if (inString && (newline = reader.readLine()) != null) {
                    buff.append(rawline);
                    buff.append(" ");
                    pos = -1;
                    rawline = newline;
                    continue;
                } else {
                    if (inString || 0 < buff.length()) {
                        buff.append(rawline);
                        if (inString) {
                            buff.append("\"");
                        }
                        result = buff.toString();
                    }
                    break;
                }
            }
        }
        return result;
    }
    public BlobKey writeBlobData(byte[] bytes) throws IOException {
        FileService fileService = FileServiceFactory.getFileService();
        AppEngineFile file = fileService.createNewBlobFile("text/plain");
        boolean lock = true;
        FileWriteChannel writeChannel = fileService
                .openWriteChannel(file, lock);
        writeChannel.write(ByteBuffer.wrap(bytes));
        writeChannel.closeFinally();
        return fileService.getBlobKey(file);
    }

}
