<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>출결관리 시스템 - 게시판</title>
</head>
<body>
<div align="center">
  <h1>게시글 상세</h1>
  <a href="logout.do">log-out</a>
  <hr>
  <form action="updateBoard.do" method="post" enctype="multipart/form-data">
    <input name="seq" type="hidden" value="${board.seq}"/>
    <table border="1">
      <tr>
        <th bgcolor="#7DA2FF" width="150">제목</th>
        <td><input type="text" name="title" id="title" value="${board.title}"/></td>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">작성자</th>
        <!--  <td><input type="text" name="writer" value="${board.writer}" readonly="readonly"/></td> -->
        <td>${board.writer}</td>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">내용</th>
        <td>
          <textarea name="content" id="content" cols="40" rows="10">${board.content}</textarea>
        </td>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">첨부파일 미리보기</th>
        <c:choose>
          <c:when test="${empty board.fileName}">
            <td>첨부파일 없음</td>
          </c:when>
          <c:otherwise>
            <td><img src="images/${board.fileName}"></td>
            <%-- <c:set var="fileName" value="${board.fileName}" />
            <c:set var="length" value="${fn:length(fileName)}"/>
            <c:set var="fileType" value="${fn:substring(fileName, length-3, length)}"/>
                <c:choose>
                <c:when test="${ fileType == 'jpg' || fileType == 'png' || fileType == 'jpeg' }">
                    <td><img src="images/${board.fileName}"></td>
                </c:when>
                <c:otherwise>
                    <td>${board.fileName}</td>
                </c:otherwise>
                </c:choose> --%>
          </c:otherwise>
        </c:choose>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">첨부파일 수정</th>
        <td><input type="file" name="uploadFile" accept="image/*"></td>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">등록일</th>
        <td><fmt:formatDate value="${board.regDate}" type="date"/></td>
      </tr>
      <tr>
        <th bgcolor="#7DA2FF" width="150">조회수</th>
        <td>${board.readCnt}</td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="글 수정" onclick="return boardCheck()"/>
        </td>
      </tr>
    </table>
  </form>
  <hr>
  <a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;
  <a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;
  <a href="getBoardList.do">글 목록</a>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/board.js"></script>
</body>
</html>