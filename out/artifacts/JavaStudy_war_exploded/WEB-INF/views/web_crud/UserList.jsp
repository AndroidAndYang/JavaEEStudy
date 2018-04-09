<%@ page import="java.util.List" %>
<%@ page import="com.seabig.jdbc.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/8
  Time: 21:55
  Des:  使用 JSTL 输出数据库数据
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>

<a href="/user/edit">增加用户</a>
<table cellspacing="0" cellpadding="0" border="1" width="500">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>

    <%-- 获取Servlet中查询数据库中存在请求的共享数据 --%>
    <c:forEach items="${user_data}" var="item">
        <tr>
            <td align="center">${item.id}</td>
            <td align="center">${item.name}</td>
            <td align="center">${item.age}</td>
            <td align="center">
                <a href="/user/delete?id=${item.id}">删除</a>
                <a href="/user/edit?id=${item.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
