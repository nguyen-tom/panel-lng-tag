package com.panel.note.controller;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.util.StringUtil;

import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.GSFileOptions;
import com.google.appengine.api.files.GSFileOptions.GSFileOptionsBuilder;
import com.panel.note.dto.response.BaseRes;
import com.panel.note.util.ResponseUtil;

public class FileController extends Controller {
	private static final String STORAGE_HOST = "http://storage.googleapis.com";

	protected static final Logger logger = Logger
			.getLogger(FileController.class.getName());
	private static Long start = 0l;
	private static final String BUCKET = "note-laguage.appspot.com";

	private String method;
	private int columnSize;

	@Override
	protected boolean isPost() {
		if (StringUtil.isEmpty(method)) {
			return super.isPost();
		} else {
			return method.equalsIgnoreCase("post");
		}
	}
	
	@Override
	protected Navigation run() throws Exception {
		Navigation forward = null;
		logParameters();
		if (isPost()) {
			forward = doPost();
		}

		return forward;
	}
	private void logParameters() {
		if (logger.isLoggable(Level.INFO)) {
			StringBuilder sb = new StringBuilder();
			sb.append("Request start " + request.getMethod() + " "
					+ request.getServletPath() + "\n");
			@SuppressWarnings("unchecked")
			Enumeration<String> names = request.getAttributeNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				sb.append("params[" + name + "] value["
						+ request.getAttribute(name) + "]\n");
			}

			logger.log(Level.INFO, sb.toString());
		}
	}

	private Navigation doPost() throws IOException {
		logger.info("doPost start1.");
		BaseRes res = new BaseRes();
        res.setTime(System.currentTimeMillis());
		try {
			FileItem file = requestScope("csv_file");
			res.setResult(1);
			return uploadCsvFile( file);
				
		} catch (Exception e) {
			logger.info("exception:" + e);
			e.printStackTrace();
			
		}
		
		
		logger.info("doPost finished.");
		ResponseUtil.dtoToJsonResponse(res, request, response);
		return null;

	}
	
	
	private Navigation uploadCsvFile(FileItem csvFile)
			throws IOException {
		Navigation forward = null;
		// PrintWriter printWriter = response.getWriter();

		start = System.currentTimeMillis();
		
		

		try {
			@SuppressWarnings("deprecation")
            GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder()
					.setAcl("public_read")
					.setBucket(BUCKET)
					.setMimeType("image/png")
					.setKey("user_img/" + "sffsf" + "_"
							+ getNowDate() + ".png");
			GSFileOptions fileOptions = optionsBuilder.build();
			FileService fileService = FileServiceFactory.getFileService();
			AppEngineFile engineFile = fileService.createNewGSFile(fileOptions);
			FileWriteChannel writeChannel = fileService.openWriteChannel(
					engineFile, true);
			ByteBuffer byteBuffer = ByteBuffer.wrap(csvFile.getData());
			writeChannel.write(byteBuffer);
			writeChannel.closeFinally();

			// res.setResult(1);
			// printWriter.write(JSON.encode(res));
			// printWriter.flush();
		} catch (IllegalStateException e) {
			logger.warning("Failed to upload GCS. FileName:"
					+ csvFile.getFileName());
			e.printStackTrace();
			// res.setResult(0);
			// printWriter.write(JSON.encode(res));
			// printWriter.flush();
		}

		return forward;
	}

	

	private String getNowDate() {
		Date nowDate = new Date(System.currentTimeMillis());
		TimeZone tz = TimeZone.getTimeZone("OTC");
		SimpleDateFormat simpleNowDate = new SimpleDateFormat("yyyyMMdd_HHmmss");
		simpleNowDate.setTimeZone(tz);

		return simpleNowDate.format(nowDate);
	}
}