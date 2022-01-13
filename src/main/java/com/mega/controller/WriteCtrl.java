package com.mega.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mega.BoardService;

@MultipartConfig(	
	fileSizeThreshold = 1024 * 1204,
	maxFileSize = 1024 * 1204 * 10,
	maxRequestSize = 1024 * 1204 * 10 * 5
)
@WebServlet("/write_action")
public class WriteCtrl extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession mSession = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int m_idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
		System.out.println("title: "+title);
		System.out.println("content: "+content);
		String files="";
		// 파일 여러개 받는 거 		
		Collection<Part> parts=	request.getParts(); 
		
		for (Part p : parts) {
			if(p.getName().equals("myFile") && p.getSize() >0 ) {  //데이터가 myFile이고 파일이 있을때만 ! 
				
				String path = request.getServletContext().getRealPath("/upload");   //파일 저장 경로
				String fileName = p.getSubmittedFileName(); //파일 이름 중복 해결
				
				files += fileName+",";
				
				System.out.println("path: "+path);		
				
				InputStream is = p.getInputStream();
				File tempFile = new File(path);
				if(!tempFile.exists()) {
					tempFile.mkdirs(); //폴더가 없다면 폴더 만들어 달라는 뜻
				}
				FileOutputStream fos = new FileOutputStream(path +File.separator +fileName);
				
				int size = 0;
				byte[] buffer = new byte[1024];
				while((size= is.read(buffer)) != -1) {			
					fos.write(buffer, 0, size);
				}
				
				is.close();
				fos.close();
				
			}
		}
		if(files.length()>2) { // 파일명이 2 보다 클 때(0으로 해도 상관은 없음)
			files = files.substring(0,files.length()-1); // 콤마를 없애기 위한 것 
		}
		System.out.println(files);
		
		BoardService boardservice = new BoardService();
		
		boardservice.insertBoard(title, content, m_idx, files);
		
		response.sendRedirect("list");
		
//파일 하나 일때 		
//		Part p = request.getPart("myFile");
		
//		if(p.getName().equals("myFile") && p.getSize() >0 ) {  //데이터가 myFile이고 파일이 있을때만 ! 
//			
//			String path = request.getServletContext().getRealPath("/upload");
//			String fileName = p.getSubmittedFileName(); //파일 이름 중복 해결
//			System.out.println("path: "+path);		
//			
//			InputStream is = p.getInputStream();
//			File tempFile = new File(path);
//			if(!tempFile.exists()) {
//				tempFile.mkdirs(); //폴더가 없다면 폴더 만들어 달라는 뜻
//			}
//			FileOutputStream fos = new FileOutputStream(path +File.separator +fileName);
//			
//			int size = 0;
//			byte[] buffer = new byte[1024];
//			while((size= is.read(buffer)) != -1) {			
//				fos.write(buffer, 0, size);
//			}
//			
//			is.close();
//			fos.close();
//			
//		}
//		
		

	}	

}
