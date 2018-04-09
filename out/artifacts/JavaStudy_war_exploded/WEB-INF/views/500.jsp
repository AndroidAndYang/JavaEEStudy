<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/7
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("error message" + exception.getMessage());
%>
500錯誤頁面
<%-- 只有在page指令中声明了isErrorPage才可以使用exception对象 --%>
</body>
</html>
