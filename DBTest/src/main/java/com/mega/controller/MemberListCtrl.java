package com.mega.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mega.BoardService;
import com.mega.MemberService;

@WebServlet("/member_list")
public class MemberListCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mSession = request.getSession();
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = null;
		MemberService memberService = new MemberService();
		if (mSession.getAttribute("idx") != null) {

			int page = request.getParameter("p") == null ? 0
					: Integer.parseInt(String.valueOf(request.getParameter("p")));

			request.setAttribute("b", memberService.getList(page));
			request.setAttribute("total", memberService.getTotalCount());// 총 개수

			if(String.valueOf(request.getParameter("modeBtn")).equals("탈퇴")) {
				String[] checklist = request.getParameterValues("check");
				System.out.println(checklist);
				if(checklist!=null) {
					for(int i=0 ; i< checklist.length ;i++) {
						System.out.println("탈퇴"+i+":"+checklist[i]);
					}
				}
				
			}
			dispatcher = request.getRequestDispatcher("member_list.jsp");

		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");

		}
		dispatcher.forward(request, response);
		
	}
	
	
	
}
