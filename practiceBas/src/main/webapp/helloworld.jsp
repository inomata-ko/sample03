<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 現在日時を取得する
java.util.Date now = new java.util.Date();
System.out.println(now.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>hello world(<%= now %>)
dekita?gggggg
</p>
</body>
</html>