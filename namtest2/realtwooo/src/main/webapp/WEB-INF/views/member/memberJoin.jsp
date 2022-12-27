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
<h1>회원가입폼</h1>
<form action="/member/memberJoinProc" method="post">
	ID : <input type="text" name="memId"/><br/>
	NAME : <input type="text" name="memName"/><br/>
	PWD : <input type="password" name="memPwd"/><br/>
	PWDCHECK : <input type="password"/><br/>
	PHONE : <input type="text" name="phone"/><br/>
	<button>회원가입</button>
</form>
</body>
</html>