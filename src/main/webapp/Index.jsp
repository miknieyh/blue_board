<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
div {
	width: 500px;
	margin: auto;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="login_ok.jsp" method="post">
		<br>
		<div>
			<table class="table table-bordered border-primary">
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
							<input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" name="userid">
						</div>
						
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
							<input type="password" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" name="passwd">
						</div>
					</td>
				</tr>
				<tr>
					<td><div class="d-grid gap-2">
							<button class="btn btn-primary" type="submit">로그인</button>
							<a href="join.jsp" class="btn btn-primary">회원가입</a>
						</div></td>
				</tr>
			</table>
	</form>
</body>
</html>