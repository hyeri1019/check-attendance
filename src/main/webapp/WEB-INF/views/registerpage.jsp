<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="<c:url value="/register/save"/>" method="POST" onsubmit="return formCheck(this);">
    <div class="title">Register</div>
    <div id="msg" class="msg"><form:errors path="id"/></div>
    <label for="">아이디</label>
    <input class="input-field" type="text" name="id" placeholder="8~12자리의 영대소문자와 숫자 조합">
    <label for="">비밀번호</label>
    <input class="input-field" type="text" name="pwd" placeholder="8~12자리의 영대소문자와 숫자 조합">
    <label for="">이름</label>
    <input class="input-field" type="text" name="name" placeholder="홍길동">
    <label for="">이메일</label>
    <input class="input-field" type="text" name="email" placeholder="이메일">

    <button>회원가입</button>

    <script>
        function formCheck(frm) {
            var message ='';
            if(frm.id.value.length<6) {
                setMessage('id의 길이는 6자 이상이어야 합니다.', frm.id);
                return false;
            }
            return true;
        }
        function setMessage(message, element){
            document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;
            if(element) {
                element.select();
            }
        }
    </script>
</form>
</body>
</html>
