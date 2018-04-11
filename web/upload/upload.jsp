<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/11
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%-- 显示错误信息 --%>
<h2>${errMsg}</h2>
<form action="/upload" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="name" required><br>
    年龄：<input type="number" name="age" required><br>
    头像：<input type="file" name="headImg" value="选择文件"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
