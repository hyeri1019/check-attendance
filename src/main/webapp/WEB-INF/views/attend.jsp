<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<html>
<head>
    <title>출석</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/script.js"></script>
 <div class="top">
            <div class="topLink1">
                <a href="<c:url value="/logout"/>" class="topLink2">로그아웃</a>
                <a href="<c:url value="/getBoardList"/>" class="topLink2">강의자료</a>
                <a href="<c:url value="/update"/>" class="topLink2">정보수정</a>
            </div>
        </div>

        <div class="topMsg1">오늘 더 성장할 나를 위한</div><br><div class="topMsg2">직업훈련 지식포털 HRD-Net</div>

        <h3 class="welcome">이름 : ${ userInfo.name }, 아이디 : ${ userInfo.id }님, 환영합니다!</h3>


            <form id="form" class="frm" action="" method="post">
                <input type="hidden" name="id" value="${pageContext.request.session.getAttribute('id')}">
                <button type="button" class="entranceButton" id="attendBtn">입실</button>
                <button type="button" class="outingButton" id="outBtn">퇴실</button>
            </form>

        <table class="midList">
            <tr>
                <td>출석</td>
                <td>지각</td>
                <td>조퇴</td>
                <td>결석</td>
            </tr>
            <tr>
                <td>${ userInfo.attendance }</td>
                <td>${ userInfo.late }</td>
                <td>${ userInfo.earlyLeave }</td>
                <td>${ userInfo.absence }</td>
            </tr>
        </table>
        <table class="timeView">
            <tr>
                <td>입실시간</td>
                <td>퇴실시간</td>
            </tr>
            <tr>
                <td>${ inTime }</td>
                <td>${ outTime }</td>
            </tr>
        </table>
        <table class="courseView">
            <tr class="courseView1">
                <td>참여과정</td>
                <td>훈련기관</td>
                <td>기관정보</td>
                <td>훈련기간</td>
                <td>훈련유형</td>
            </tr>
            <tr class="courseView2">
                <td>(디지털컨버젼스) 자바(JAVA)기반<br>스프링프레임워크 응용SW개발자 양성과정 D</td>
                <td>이젠컴퓨터아카데미</td>
                <td>서울 관악구<br>02-2088-5878</td>
                <td>2022.09.15 - 2023.03.02</td>
                <td>통합심사과정휸련</td>
            </tr>
        </table>
<jsp:include page="/module/footer.jsp" flush="false"></jsp:include>

<script>
    $("#attendBtn").on("click", function(){
        if(!confirm("입실")) return;
        let form = $("#form");
        form.attr("action", "<c:url value='/attend/save'/>");
        form.attr("method", "post");
        form.submit();
    });


    $("#outBtn").on("click", function(){
        if(!confirm("퇴실")) return;
        let form = $("#form");
        form.attr("action", "<c:url value='/attend/out'/>");
        form.attr("method", "post");
        form.submit();
    });
</script>

</body>
</html>
