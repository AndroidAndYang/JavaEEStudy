<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/9
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑用户信息</title>
</head>
<body>

<h2>编辑用户信息</h2>
<form action="/user/save" method="post">
    <%-- 添加一个隐藏的ID，用于更新用户信息 --%>
    <input name="id" value="${user.id}" hidden>
    姓名：<input name="name" value="${user.name}" required/><br>
    年龄：<input name="age" value="${user.age}" required/><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
