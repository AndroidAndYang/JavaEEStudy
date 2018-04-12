<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/12
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示图片</title>
</head>
<body>

<%
    String realpath = "/upload/c94020d6-6f6f-48c2-8495-4bdda97e22c4.png";
    System.out.println(realpath);
%>

<img src=<%= realpath%>>
</body>
</html>
