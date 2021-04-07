<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 22.03.2021
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../static/pagestyle.css">
</head>
<div class="top">
    <a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a>
    <a href="${pageContext.request.contextPath}/controller?command=aboutPage">About</a>
    <a href="${pageContext.request.contextPath}/controller?command=accountData">Account</a>
    <a class="active" href="${pageContext.request.contextPath}/controller?command=mainPage" >Home</a>
</div>
</html>
