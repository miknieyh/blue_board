<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>멤버 목록</title>
<style>
.list {
	margin: auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="list">
	<form action="member_list" method ="get">
	<input type="hidden" name="mode" value="0">
		<table class="table table-bordered border-primary"
			 border="1">
			<tr>
				<td colspan="8"><div
						class="d-grid gap-2 d-md-flex justify-content-md-end col-12">
						<a href="list?stat=manager"> <input type="button" value="목록">
						</a>
						<input type="submit" name = "modeBtn" value="탈퇴">
						<input type="submit" name = "modeBtn" value="블랙">
					</div></td>
			<tr>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>주소</th>
				<th>가입일</th>
				<th>상태</th>
				<th>선택</th>
			</tr>
			<c:forEach var="b" items="${b}" varStatus="vs">
				<tr>
					<td>${b.idx}</td>
					<td>${b.userid}</td>
					<td>${b.name}</td>
					<td>${b.email}</td>
					<td>${b.address}</td>
					<td><fmt:formatDate pattern="yyyy-mm-dd" value="${b.wdate}" /></td>
					<td><c:choose> <c:when test="${b.stat==2}">블랙</c:when><c:when test="${b.stat==1}">일반</c:when><c:when test="${b.stat==10}">관리자</c:when></c:choose></td>
					<td><input type="checkbox" name="check" value="${b.idx}"></td>
				</tr>

			</c:forEach>
		</table>
		</form>
		<c:set var="total" value="${total}" />
		<c:set var="num" value="${param.p==null?1:param.p}" />
		<c:set var="sp" value="${num-(num%5)}" />

		<div class="w-100">
			<ul class="nav d-flex justify-content-center">
				<c:if test="${sp>4}">
					<li class="ml-2"><a href="?p=${num-5}">◀</a></li>
				</c:if>

				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(sp+i)*10<=total}">
						<li class="ml-2"><a href="?p=${sp+i}"> ${sp+i+1} </a></li>
					</c:if>
				</c:forEach>
				<c:if test="${(sp+5)*10<=total}">
					<li class="ml-2"><a href="?p=${num+5}">▶</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</body>
</html>