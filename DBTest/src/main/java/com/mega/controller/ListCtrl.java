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

@WebServlet("/list")
public class ListCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mSession = request.getSession();
		RequestDispatcher dispatcher = null;
		BoardService boardService = new BoardService();
		if (request.getParameter("flag") != null ) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			if (request.getParameter("flag").equals("edit")) {
				request.setAttribute("b", boardService.getBoardData(idx));

				dispatcher = request.getRequestDispatcher("edit.jsp");

			}else if(request.getParameter("flag").equals("delete")) {
				
				boardService.deleteBoard(idx);
				dispatcher = getList(request);
			}

		} else if (mSession.getAttribute("idx") != null) {

			dispatcher = getList(request);

		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");

		}
		dispatcher.forward(request, response);
		
	}
	
	public RequestDispatcher getList(HttpServletRequest request) {
		
		HttpSession mSession = request.getSession();
		BoardService boardService = new BoardService();
		int myIdx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
		int page = request.getParameter("p") == null ? 0
				: Integer.parseInt(String.valueOf(request.getParameter("p")));
		String stat =String.valueOf(mSession.getAttribute("stat"));
		request.setAttribute("stat",stat);
		request.setAttribute("bArr", boardService.getBoardList(myIdx, page));
		request.setAttribute("total", boardService.getTotalCount());// 총 개수

		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		return dispatcher;
	}
	
}
