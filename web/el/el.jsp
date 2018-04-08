<%--
  Created by IntelliJ IDEA.
  User: AirBike-Work2
  Date: 2018/4/8
  Time: 21:16
  Des: EL和JSTL的使用
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引用JSTL库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%-- 获取request请求中的参数 --%>
${msg}

<%-- if表达式,不支持else. --%>
<c:if test="${msg  == null}">
    数据为空
</c:if>

<c:if test="${msg  != null}">
    数据不为空
</c:if>

<%
    request.setAttribute("num", 2);
%>

<%-- when表达式,相当于switch --%>
<c:choose>
    <c:when test="${num == 1}">数据为1<br></c:when>
    <c:when test="${num == 2}">数据为2<br></c:when>
    <c:when test="${num == 3}">数据为3<br></c:when>
</c:choose>

<c:forEach begin="1" end="10" step="1" var="nums" varStatus="status">
    <%-- 获取索引 --%>
    status = ${status.count}
    nums = ${nums}<br>
</c:forEach>

</body>
</html>
