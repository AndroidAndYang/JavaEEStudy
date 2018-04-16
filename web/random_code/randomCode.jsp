<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/16
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码登录</title>
</head>
<body>
<%
    request.getSession().getAttribute("RANDOM_CODE_IN_SESSION");
%>
<h3 style="color: red">${errMsg}</h3>
<form action="/randomLogin" method="post">
    用户名：<input name="name" value="${name}" required><br>
    密码：<input name="pwd" type="password" value="${pwd}" required><br>
    验证码：<input name="code" size="5">
    <img id="img" src="/randomCode" onclick="getRandomCode()" style="cursor: pointer"
         title="看不清换一张"><br>
    <input type="submit" value="登录">
</form>
<script>
    function getRandomCode() {
        var img = document.getElementById("img");
        // 需要加上一个随机数,因为浏览器会检测你请求的是同一个地址没有做更改没有效果
        img.src = "/randomCode?" + new Date().getTime();
    }

</script>
</body>
</html>
