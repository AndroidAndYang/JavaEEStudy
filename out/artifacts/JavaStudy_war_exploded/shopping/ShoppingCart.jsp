<%@ page import="com.seabig.shopping.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="com.seabig.shopping.ShoppingCartHelper" %><%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/12
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<head>
    <title>购物车</title>
</head>
<body>

<a href="/shopping/ProductList.jsp">继续购物</a>

<table cellpadding="5" cellspacing="0" width="500" border="1">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>操作</th>
    </tr>

    <%-- 判断是否有session数据 -》 没有--%>
    <c:if test="${empty sessionScope.SESSION_SHOPPING_CART.items}">
        <tr>
            <td colspan="4" align="center">购物车为空，去购物把。</td>
        </tr>
    </c:if>

    <%-- 有session数据 --%>
    <c:if test="${!empty sessionScope.SESSION_SHOPPING_CART.items}">
        <%-- 从session作用域中取出数据 --%>
        <c:forEach items="${sessionScope.SESSION_SHOPPING_CART.items}" var="item">
            <tr>
                <td align="center">${item.name}</td>
                <td align="center">${item.price}</td>
                <td align="center">${item.number}</td>
                <td align="center">
                    <a href="/shopping?cmd=delete&id=${item.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right">商品总价：${sessionScope.SESSION_SHOPPING_CART.totalPrice}</td>
        </tr>
    </c:if>
</table>
</body>
</html>
