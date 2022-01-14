
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
.noresize{
resize: none; 
}

</style>
<title>Insert title here</title>
</head>
<body>

	<form action="write_action" method="post" enctype="multipart/form-data">
		<div class="list">
			<br>
			<table class="table table-bordered border-primary">
				<tr>
					<td class="d-flex">
						<button type="button" class="btn btn-outline-primary disabled">글제목</button>
						<div class="ms-2 col-9">
							<input type="text" class=" form-control" name="title">
						</div>
					</td>
				</tr>
				<tr>
					<td><button type="button"
							class="btn btn-outline-primary disabled">내용</button>
				</tr>
				<tr>
					<td>
					<div class="form-floating"><textarea class="noresize h-25 form-control textdiv" id="floatingTextarea" name="content" rows="10"></textarea>
					<label for="floatingTextarea">글 내용을 입력해 주세요.</label></div></td>


				</tr>
				<tr><td>첨부파일1 <input type="file" name="myFile"></td></tr>
				<tr><td>첨부파일2 <input type="file" name="myFile"></td></tr>
				<tr>
					<td><div
							class="d-grid gap-2 d-md-flex justify-content-md-end col-12">
							<a href="list"> <input type="button" value="취소">
							</a><input type="submit" value="작성">
						</div></td>
				<tr>
			</table>
		</div>

	</form>


</body>
</html>