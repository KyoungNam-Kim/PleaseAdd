<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인폼</h1>
<form action="/member/login" method="post">
	ID : <input type="text" name="memId"/><br/>
	PWD: <input type="text" name="memPwd"/><br/>
	 <input type="submit"  value="로그인"/> 
	 <input type="submit"  value="입력취소"/>
 
</form>
</body>
</html>