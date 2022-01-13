
<%@page import="com.mega.BoardData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<style>
.list {
	margin: auto;
	width: 500px;
}

.noresize {
	resize: none;
}
</style>
<title>Insert title here</title>
</head>
<body>


	<div class="list">
		<br>
		<table class="table table-bordered border-primary">
			<tr>
				<td><div
						class="d-grid gap-2 d-md-flex justify-content-md-end col-12">
						<a href="list"> <input type="button" value="목록">
						</a>
					</div></td>
			<tr>
			<tr>
				<td class="d-flex">
					<button type="button" class="btn btn-outline-primary disabled">글제목</button>
					<div class="ms-2 mt-2  col-9">
						<div>${b.title}</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><button type="button"
						class="btn btn-outline-primary disabled">내용</button>
			</tr>
			<tr>
				<td>
					<div class="form-floating">
						<div>
							<br>${b.content}</div>
						<br>
					</div>
				</td>
			</tr><c:if test="${b.file1!=''}">
			<tr><td>첨부파일1:<a download href="./upload/${b.file1}">${b.file1}</a></td></tr></c:if>
			<c:if test="${b.file2!=''}">
			<tr><td>첨부파일2:<a download href="./upload/${b.file2}">${b.file2}</a></td></tr></c:if>
			<tr>
				<td>
					<form action="comments_ok.jsp" method="post">
						<input type="hidden" name="idx" value="${b.idx}">
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="댓글을 입력해 주세요"
								aria-label="댓글을 입력해 주세요" aria-describedby="button-addon2"
								name="comments">
							<button class="btn btn-outline-secondary" type="submit"
								id="button-addon2">작성</button>
						</div>
					</form>
				</td>
			</tr>
			<c:forEach var="c" items="${b.cArr}" varStatus="vs">
				<tr>
					<td class="d-flex"><button type="button"
							class="btn btn-outline-primary disabled">${c.writer}</button>
						<div class="mt-2 col-7 text-center">${c.comments}</div> <c:if
							test="${c.mine ||stat=='manager'}">
							<div class="mt-2 col-3">
								<a href="#" id="edit_bt_${vs.index}">[수정]</a> <a
									href="commentdelete.jsp?c_idx=${c.c_idx}&b_idx=${c.idx}">[삭제]</a>
							</div>

						</c:if></td>
				</tr>
				<tr id="edit_box_${vs.index}">
					<td>
						<form action="comment_edit_ok.jsp?idx=${c.c_idx}" method="post">
							<div class="input-group">
							<input type="hidden" name="idx" value="${c.c_idx}">
							<input type="hidden" name="b_idx" value="${c.idx}">
								<input type="text" class="form-control" value="${c.comments}"
									placeholder="댓글을 입력해주세요"
									aria-label="Recipient's username with two button addons"
									name="comments">
								<button class="btn btn-outline-secondary" type="submit">확인</button>
								<button class="btn btn-outline-secondary" type="button"
									id="exit_${vs.index}">취소</button>
							</div>

						</form>
					</td>
				</tr>
				<script>
					$(document).ready(function() {
						$("#edit_box_${vs.index}").hide();

						$("#edit_bt_${vs.index}").click(function() {
							$("#edit_box_${vs.index}").show();
						});
						$("#exit_${vs.index}").click(function() {
							$("#edit_box_${vs.index}").hide();
						});
					});
				</script>

			</c:forEach>

		</table>
	</div>




</body>
</html>