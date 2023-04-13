<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/join.css" rel="stylesheet" type="text/css"/>
<title>회원가입</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/script.js"></script>
<div class="all">
	<h4>회원가입</h4>
	<form method="post" action="join.do">
		<input type="hidden" name="seq">
		<span id="nametext">이름</span>
		<input id="name" type="text" name="name" placeholder="홍길동">
		<span id="jumintext">주민등록번호</span>
		<input id="jumin" type="text" name="jumin" placeholder="123456-1234567">
		<span id="idtext">아이디</span>
		<input id="id" type="text" name="id" placeholder="4자 이상">
		<span id="pwdtext">비밀번호</span>
		<input id="pwd" type="text" name="pwd" placeholder="7자 이상 14자 이하">
		<input class="submit" type="submit" value="확인" onclick="return joinCheck()">
	</form>
</div>
</body>
</html>