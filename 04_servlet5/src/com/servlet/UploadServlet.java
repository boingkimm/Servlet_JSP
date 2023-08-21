package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파일 업로드 기능 구현
		
		/*
		* enctype="multipart/form-data" 지정시
		* request.getParameter(key) 사용 불가
		* request.setCharacterEncoding("utf-8") 사용 불가 -> 61라인에 "utf-8"만 추가
		*/
		
		//apache > Commons FileUpload > User guide
		
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("jakarta.servlet.context.tempdir"); // Or "javax.servlet.context.tempdir" for javax
		factory.setRepository(repository);

		// Create a new file upload handler
//		JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload(factory);  //다른 버전 - 자카르타 삭제
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// Parse the request   //다른 버전 - List<FileItem>로 변경, 예외처리
//		List<DiskFileItem> items = upload.parseRequest(request);
		try {
			List<FileItem> items = upload.parseRequest(request); 
			
			Iterator<FileItem> iter = items.iterator();
			// Process the uploaded items
			while (iter.hasNext() ) {
				FileItem item = iter.next();
			    if (item.isFormField()) {
			    	// type="file" 아닌 것 처리 => type="text"인 것 처리  //한글처리 필요
			        String name = item.getFieldName();
//			        String value = item.getString();
			        String value = item.getString("utf-8");  //한글처리 필요
			        System.out.println("text 데이터: " + name + "\t" + value);
			    } else {
			    	// type="file"인 것 처리  //한글처리 자동
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					System.out.println("fieldName: " + fieldName);
					System.out.println("fileName:" + fileName);
					System.out.println("contentType:" + contentType);
					System.out.println("isInMemory:" + isInMemory);
					System.out.println("sizeInBytes:" + sizeInBytes);
					
					//진짜 특정 경로에 파일 저장 ( c:\\upload )
					File f = new File("c:\\upload", fileName);     //경로지정
					try {
						item.write(f);                             //파일 저장
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}//end while
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}//try-catch
	}//doPost

}//upload
