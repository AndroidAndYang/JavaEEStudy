<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/12
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<h2>商品列表</h2>
<form action="/shopping?cmd=save" method="post">
    商品名称：
    <select name="name">
        <option>手机</option>
        <option>电脑</option>
        <option>平板</option>
    </select><br>
    购买数量：<input name="num" min="1"><br>
    <input type="submit" value="添加至购物车">
</form>
</body>
</html>
