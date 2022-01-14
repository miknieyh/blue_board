
<%@page import="com.mega.BoardData"%>
<%@page import="java.util.ArrayList"%>
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
<style>
.list {
	margin: auto;
	width: 500px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="list">
	
		<br>
		<table class="table table-bordered border-primary">
			<tr>
				<td colspan="2"><div
						class="d-grid gap-2 d-md-flex justify-content-md-end col-12">
						
						<c:if test= "${stat=='manager'}"><a href="member_list"><input type="button" value="회원정보"></a></c:if><a href="write.jsp"> <input type="button" value="글쓰기">
						</a><a href="Index.jsp"> <input type="button" value="로그아웃">
						</a>
					</div></td>
				<c:forEach var="b" items="${bArr}">

					<tr>
						<td class="col-1 mt-3 text-center">${b.idx}</td>
						<td class="d-flex"><button type="button"
								class="btn btn-outline-primary disabled">글제목</button>
							<div class="mt-2 col-7 text-center">
								<a href="detail?idx=${b.idx}">${b.title}</a>
							</div> <c:if test="${b.mine|| stat=='manager'}">
								<div class="mt-2">
									<a href="?flag=edit&idx=${b.idx}">[수정]</a> <a
										href="?flag=delete&idx=${b.idx}">[삭제]</a>
								</div>
							</c:if></td>

					</tr>
					<tr>
						<td colspan="2">
							<button type="button" class="btn btn-outline-primary disabled">작성자</button>
							${b.writer}
						</td>
					</tr>
					<tr>
						<td colspan="2"><button type="button"
								class="btn btn-outline-primary disabled">작성시간</button> <fmt:formatDate
								pattern="yyyy-MM-dd (a)hh:mm:ss" value="${b.wdate}" /></td>
					</tr>
					<tr>
						<td colspan="2"><br>${b.content}<br> <br></td>
					</tr>
				</c:forEach>
		</table>
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
		<br>
	</div>


</body>
</html>