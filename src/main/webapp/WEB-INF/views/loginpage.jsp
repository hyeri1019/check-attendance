<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<form action="<c:url value="/loginpage/login"/>" method="post" onsubmit="return formCheck(this);">
  <div id="message">
    <c:if test="${not empty param.message}">
      <i class="fa fa-exclamation-circle">${param.message}</i>
    </c:if>
  </div>
  <input type="text" name="id" placeholder="id">
  <input type="password" name="pwd" placeholder="password">
  <input type="hidden" name="reg_date" value="${param.reg_date}">

  <button>로그인</button>
  <a href="<c:url value='/register'/>">회원가입</a>

  <script>
    function  formCheck(frm) {
      let message = '';
      if(frm.id.value.length==0) {
        setMsg('id를 입력해주세요.',frm.id);
        return false;
      }
      if(frm.pwd.value.length==0) {
        setMsg('비밀번호를 입력해주세요.', frm.pwd);
        return false;
      }
      return true;
    }

    function setMsg(message, element) {
      document.getElementById("message").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${message}'}</i>`;
      if(element) {
        element.select();
      }
    }

  </script>
</body>
</html>
