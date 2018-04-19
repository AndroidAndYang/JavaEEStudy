<%@ page import="java.util.UUID" %>
<%@ page import="com.seabig.util.TokenUtil" %><%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/19
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重复提交</title>
</head>
<body>

<%
    // 获取UUID随机数
    String uuid = UUID.randomUUID().toString();
    // 设置随机数为session
    session.setAttribute("TOKEN_IN_SESSION", uuid);
    // 通过TokenUtil重构了
%>

<form action="/repeat/commit" method="post">
    <input hidden name="id" value="<%=TokenUtil.createToken(request)%>">
    <input required name="account" type="number">
    <input value="提交" type="submit">
</form>

</body>
</html>
