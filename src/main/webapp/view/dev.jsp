<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dev faculty</title>
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/dev.png" width="300" height="300" align="left">
<b class="spec-header">Development faculty
</b>
<p class="spec-description">
    The Faculty of Development invites you to get useful experience in software development.
    You can get into one of the following specialties: Java, C++ and Python development.
    You can choose a specialty below:
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>JAVA</b>
        <p class="spec-description">
            Universal and Popular
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJava">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>C++</b>
        <p class="spec-description">
            Powerful and Fast
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerC">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>PYTHON</b>
        <p class="spec-description">
            Simple and Popular
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerPython">
            <button class="button">Register</button>
        </form>
    </div>
</div>
</body>
</html>
