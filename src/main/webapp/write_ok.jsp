<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//String sql = "SELECT * FROM MEMBER";

request.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String content = request.getParameter("content");

int m_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));


String sql = "INSERT INTO MEMO_BOARD(title,content,m_idx,wdate) VALUES('"+title+"','"+content+"','"+m_idx+"',sysdate)";
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(url, "LASTMEGA", "1234");
Statement st = con.createStatement();
int result = st.executeUpdate(sql);
System.out.println(result);

st.close();
con.close();
response.sendRedirect("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>