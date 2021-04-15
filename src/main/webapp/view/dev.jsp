<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dev faculty</title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
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
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJava" id="btnJava">
            <button class="button">Register</button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportJava" >
                <button class="button">Get Java Report</button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>C++</b>
        <p class="spec-description">
            Powerful and Fast
        </p>
    <c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerC" id="btnC">
            <button class="button">Register</button>
        </form>
    </c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportC">
        <button class="button">Get C++ Report</button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>PYTHON</b>
        <p class="spec-description">
            Simple and Popular
        </p>
        <c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerPython" id="btnPython">
            <button class="button">Register</button>
        </form>
        </c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportPython">
                <button class="button">Get Python Report</button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
