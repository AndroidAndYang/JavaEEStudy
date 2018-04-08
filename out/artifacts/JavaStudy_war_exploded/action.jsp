<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/7
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP常用动作元素</title>
</head>
<body>
<%-- 静态包含 --%>
<%@include file="WEB-INF/views/views.jsp" %>

<%-- 动态包含：使用JSP的include指定需要引用的jsp文件 --%>
<jsp:include page="WEB-INF/views/views.jsp"/> 引用views.jsp
<br>0.

<%-- jsp:forward  请求转发 --%>
<%-- jsp:param 请求时携带的参数 --%>
<%-- 21-22行内不能写注释 --%>
<jsp:forward page="/WEB-INF/views/index.jsp">
    <jsp:param value="YJZ" name="name"/>
</jsp:forward>

<%-- URL重定向 --%>
<%
    response.sendRedirect("Login.html");
%>

</body>
</html>
