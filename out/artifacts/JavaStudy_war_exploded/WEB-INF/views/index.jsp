<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/3
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>

<%--
jsp编译后的文件存在于：
    C:\Users\AirBike-Work2\.IntelliJIdea2017.1\system\tomcat\Unnamed_JavaStudy_4\work\Catalina\localhost\ROOT\org\apache
文件夹下。
 --%>

<%-- 解决中文编码问题 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%!
    private int num = 0;
    private String str = "Hello World";
%>

<%!
    private String getString(String str) {
        // 如果在page指令中没有指定errorPage,则会去web.xml中去寻找<error-page>标签.如果都没有则显示默认错误页面
        // int i = 1 / 0;
        // System.out.print(str);
        return str;
    }
%>

<%-- 获取请求参数 --%>
<%
    String name = request.getParameter("name");
    System.out.println(name);
%>

今天的日期是<%=new Date().toLocaleString()%>

<h1><%= str %>
</h1>
<input type="text" value="<%= getString(str) %>">

</body>
</html>
