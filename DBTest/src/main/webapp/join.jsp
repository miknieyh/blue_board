
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<form action="join_ok.jsp" method="post">
		<br>
		<div>
	
			<table class="table table-bordered border-primary">
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">아이디</button>
					</td>
					<td><input type="text" class=" form-control" name="userid">
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">비밀번호</button>
					</td>
					<td><input type="password" class=" form-control" name="passwd">
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">비밀번호확인</button>
					</td>
					<td><input type="password" class=" form-control" name="passwd">
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">이메일</button>
					</td>
					<td><input type="email" class=" form-control" name="email">
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">이름</button>
					</td>
					<td><input type="text" class=" form-control" name="name">
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="btn btn-outline-primary disabled">주소</button>
					</td>
					<td><input type="text" class=" form-control" name="address">
					</td>
				</tr>
				<tr>
					<td colspan="2"><div
						class="d-grid gap-2 d-md-flex justify-content-md-end col-12"><a href="Index.jsp"><input type="button"
							value="취소"></a> <input type="submit" value="회원가입"></div></td>
				</tr>
			</table>
		</div>


		
		</div>
	</form>
</body>
</html>