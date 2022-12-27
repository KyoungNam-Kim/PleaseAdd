<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<!-- 만약 session 영역에 vo라는 속성 상자가 있다면....로그아웃, 내정보변경 링크태그, 사용자명이 있어야 한다. -->  
		<c:if test="${vo != null}">
			<a href="/member/logout">로그아웃</a>
			<a href="">정보변경</a>
			<a href="/board/list">게시판보기</a>
			<br />
			<span>${vo.memName} 님 환영합니다.</span>
		</c:if>
		<c:if test="${vo == null}">
			<!-- 만약 session 영역에 vo라는 속성 상자가 없다면 아래있는 내용이 나와야한다.-->
			<a href="/member/loginForm">로그인</a>
			<a href="/member/memberJoin">회원가입</a>
		</c:if>  
</body>
</html>
