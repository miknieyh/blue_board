<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");
String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

String sql = "SELECT * FROM MEMO_MEMBER WHERE USERID ='"+userid+"'";

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(url, "LASTMEGA", "1234");
Statement st = con.createStatement();
//int result = st.executeUpdate(sql);
	
ResultSet rs = st.executeQuery(sql);

while (rs.next()) {
	String passwd_ok = rs.getString("passwd");
	String passwd = request.getParameter("passwd");
	
	if(passwd.equals(passwd_ok)){
		String m_idx = String.valueOf(rs.getInt("idx"));	
		String isManager = rs.getInt("stat")==10?"manager":"no";
		session.setAttribute("idx",m_idx);
		session.setAttribute("stat",isManager);
		System.out.println("로그인 성공");
		response.sendRedirect("list"); //다음화면으로 전환
	}else{
		System.out.println("비밀번호가 틀렸습니다.");
		response.sendRedirect("Index.jsp");
	}
	
}

rs.close();
st.close();
con.close();


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