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

@WebServlet("/detail")
public class DetailCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mSession = request.getSession();
		int my_idx = Integer.parseInt(String.valueOf(mSession.getAttribute("idx")));
		String stat = String.valueOf(mSession.getAttribute("stat"));
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardService boardService = new BoardService();
		request.setAttribute("stat", stat);
		request.setAttribute("b", boardService.getBoardData(idx, my_idx));

		RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
		dispatcher.forward(request, response);

	}

}
