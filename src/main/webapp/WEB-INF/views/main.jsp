<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>

<c:set var="loginOutLink" value="${loginId=='' ? '/loginpage' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'login' : 'logout'}"/>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>냥냥.com</title>
  <meta name="description" content="고양이가 좋아서 만든 사이트">
<%--  <link rel="icon" type="image/png" href="images/favicon.png">--%>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- CSS -->
  <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
  <link href="https://fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/0f2c8c1913.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="home" class="big-bg">
  <header class="page-header wrapper">
    <h1><a href="<c:url value='/'/>"><img class="logo" src="images/logo.png" alt="냥냥닷컴 홈"></a></h1>
    <nav>
      <ul class="main-nav">
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/'/>">Shop</a></li>
        <li><a href="<c:url value='/board'/>">Post</a></li>
      </ul>
    </nav>
  </header>

  <div class="home-content wrapper">
    <h2 class="page-title"></h2>
    <p></p>
    <a class="button" href="<c:url value='/'/>">visit</a>
  </div><!-- /.home-content -->
</div><!-- /#home -->
</body>
</html>