<%@ page import="com.seabig.jdbc.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/7
  Time: 12:59
  Des: 使用JSP输出查询到的数据库数据
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<%-- JSP + SERVLET --%>
<%
    List<Student> userList = (List<Student>) request.getAttribute("list_data");
%>

<table cellpadding="0" cellspacing="0" border="1" width="500">
    <tr>
        <td>用户id</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <%
        for (Student anUserList : userList) {
            System.out.println(anUserList.toString());
    %>
    <tr>
        <td><%=anUserList.getId() %>
        </td>
        <td><%=anUserList.getName() %>
        </td>
        <td><%=anUserList.getAge() %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
