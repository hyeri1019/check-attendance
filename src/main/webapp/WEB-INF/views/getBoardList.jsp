<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/loginpage' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출결관리 시스템 - 게시판</title>
</head>
<body>
<div align="center">
	<h1>게시글 목록</h1>
	<h3>${loginId}님 환영합니다...<a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
	
	<!-- 검색 파트 -->
	<form action="getBoardList" method="post">
	<table style="width:700;">
		<tr>
			<td align="right">
				<select name="searchCondition">
					<c:forEach items="${conditionMap}" var="option">
						<option value="${option.value}">${option.key}
					</c:forEach>
				</select>
				<input type="text" name="searchKeyword"/>
				<input type="submit" value="검색"/>
			</td>
		</tr>
	</table>
	</form>
	<!-- 검색 파트 종료 -->
	
	<!-- 게시글 목록 출력 -->
	<br>
	<table border="1" style="width:700;">
		<tr>
			<th bgcolor="#7DA2FF" width="100">번호</th>
			<th bgcolor="#7DA2FF" width="200">제목</th>
			<th bgcolor="#7DA2FF" width="150">작성자</th>
			<th bgcolor="#7DA2FF" width="150">등록일</th>
			<th bgcolor="#7DA2FF" width="100">조회수</th>
		</tr>
<!-- Java 코드를 통해 전달된 게시글 목록 데이터를 반복하여 읽어 출력 -->
	<c:forEach items="${boardList}" var="board">
	<tr>	
		<td>${board.seq}</td>
		<td><a href="<c:url value="/getBoard"/>?seq=${board.seq}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td><fmt:formatDate value="${board.regDate}" type="date"/></td>
		<td>${board.readCnt}</td>
	</tr>
	</c:forEach>
	</table>
	<!-- 게시글 목록 출력 종료-->
	<br>
		<a href="<c:url value='/writeBoard'/>">글쓰기</a>
</div>
</body>
</html>