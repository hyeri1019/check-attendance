<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/login.css" rel="stylesheet" type="text/css"/>
<title>로그인</title>
</head>
<body>
<div class="all">
	<h4>로그인</h4>
	<form action="<c:url value="/loginpage/login"/>" method="post" onsubmit="return formCheck(this);">
		<input class="id" type="text" name="id" placeholder="  아이디">
		<input class="pwd" type="password" name="pwd" placeholder="  비밀번호">
		<input class="submit" type="submit" value="로그인">
	</form>
	<span class="foot">
		아직 계정이 없나요?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	<a href="join.jsp" class="join">회원가입하기</a> 
</div>


</body>
</html>