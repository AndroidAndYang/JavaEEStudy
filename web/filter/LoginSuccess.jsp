<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/18
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>

<%
    // 判读是否登录过,没有登录则跳转到登录界面中
    if (session.getAttribute("USER_IN_SESSION") == null) {
        response.sendRedirect("/filter/LoginFilter.jsp");
    }
%>

<body>

个人中心

</body>
</html>
