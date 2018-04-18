<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/18
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录过滤操作</title>
</head>
<body>

<form action="/filter/login" method="post">
    帐号<input name="name" onclick="isEmpty()"><br>
    密码<input name="pwd" type="password"><br>
    <BUTTON type="submit ">登录</BUTTON>
</form>

</body>
</html>
