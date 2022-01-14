<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//String sql = "SELECT * FROM MEMBER";

System.out.println("ddd: "+request.getParameter("idx"));

request.setCharacterEncoding("utf-8");
int c_idx = Integer.parseInt(request.getParameter("c_idx"));
int b_idx = Integer.parseInt(request.getParameter("b_idx"));
String sql = "DELETE FROM MEMO_COMMENT WHERE idx="+c_idx;
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(url, "LASTMEGA", "1234");
Statement st = con.createStatement();
int result = st.executeUpdate(sql);
System.out.println(result);

st.close();
con.close();
response.sendRedirect("detail?idx="+b_idx);
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