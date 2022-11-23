<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>${user.name}님, 가입을 환영합니다.</h1>
<h1>${user.email}</h1>
<a href="<c:url value='/'/>">홈으로 돌아가기</a>

</body>
</html>