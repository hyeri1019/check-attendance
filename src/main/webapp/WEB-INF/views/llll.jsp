<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="getList" method="post">
  <table border="1" style="width:700;"></table>
  <tr>
    <td aligh="right">
      <select name="searchCondition">
        <option value="TITLE"> 제목
        <option value="CONTENT">내용
      </select>
    </td>
  </tr>
</form>

</body>
</html>
