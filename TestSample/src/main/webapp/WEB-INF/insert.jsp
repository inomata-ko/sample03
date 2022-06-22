<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/TestSample/insertpage" method="post" >
名前<input type="text" name="Name">
生年月日<input type="text" name="Dateofbirth">
年齢<input type="text" name="Old">
出身地<input type="text" name="Birthplace">
詳細<input type="text" name="Detail">
<input type="submit" value="登録">
</form>
</body>
</html>