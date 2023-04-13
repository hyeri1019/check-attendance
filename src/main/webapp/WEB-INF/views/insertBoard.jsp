<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/loginpage' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출결관리 시스템 - 게시판</title>
</head>
<body>
  <div align="center">
	<h1>게시글 등록</h1>
	  <a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
	<hr>

	  <form action="<c:url value='/insertBoard'/>" method="post" enctype="multipart/form-data">
	<table border="1">
	  <tr>
	    <td bgcolor="#7DA2FF" width="70">제목</td>
	    <td align="left"><input type="text" name="title" id="title"></td>
	  </tr>
	  <tr>
	    <td bgcolor="#7DA2FF">작성자</td>
	    <td align="left"><input type="text" name="writer" id="writer" size="10"/></td>
	  </tr>
	  <tr>
	    <td bgcolor="#7DA2FF">내용</td>
	    <td align="left"><textarea name="content" id="content" cols="40" rows="10"></textarea></td>
	  </tr>
	  <tr>
	  	<td bgcolor="#7DA2FF">첨부파일</td>
	  	<td align="left"><input type="file" name="uploadFile" accept="image/*"></td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
			<button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
	  </td>
	  </tr>
	</table>
	</form>
	<hr>
	<a href="<c:url value="/getBoardList"/>">게시글 목록 가기</a>
  </div>
  <script>
	  let formCheck = function() {

		  //getElementByID - html 태그 내에 해당 id를 가지고 있는 요소를 찾음
		  let form = document.getElementById("form");
		  if(form.title.value=="") {
			  alert("제목을 입력해 주세요.");
			  form.title.focus();
			  return false;
		  }
		  if(form.content.value=="") {
			  alert("내용을 입력해 주세요.");
			  form.content.focus();
			  return false;
		  }
		  return true;
	  }

	  // 작성한 게시물을 저장(POST)
	  $("#writeBtn").on("click", function(){
		  let form = $("#form");
		  form.attr("action", "<c:url value='/insertBoard'/>");
		  form.attr("method", "post");
		  if(formCheck())
			  form.submit();
	  });


	  // 삭제
	  $("#removeBtn").on("click", function(){
		  if(!confirm("삭제하시겠습니까?")) return;
		  let form = $("#form");
		  form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
		  form.attr("method", "post");
		  form.submit();
	  });
	  //. 목록버튼
	  $("#listBtn").on("click", function(){
		  location.href="<c:url value='/board'/>?page=${page}&pageSize=${pageSize}";
	  });
  </script>

</body>
</html>