<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/3
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
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
    public String getString(String str) {
      return str;
    }
  %>


  <h1><%= str %>
  </h1>

  <input type="text" value="<%=getString(str) %>">

  </body>
</html>
