<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>上传图片</title>
</head>
<body>
	<form action="/DuXiangLeServer/UpdateUserInfoServlet?userid=1"
		enctype="multipart/form-data" method="post">
		
		<input type="file" name="picFile">
		<input type="text" name="userid">
		<input type="text" name="nickname">
		<input type="text" name="created">
		<input type="text" name="describ">
		 <input type="submit"
			value="上传">
	</form>
</body>
</html>