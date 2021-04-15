<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>QA faculty</title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/qa.png" width="300" height="300" align="left">
<b class="spec-header">QA faculty
</b>
<p class="spec-description">
    The QA Faculty invites you to get useful experience in computer testing.
    You can get into one of the following specialties: Allure,Junit and Selenium.
    You can choose a specialty below:
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>ALLURE</b>
        <p class="spec-description">
            Flex framework from Yandex
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAllure">
            <button class="button">Register</button>
        </form>
</c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportAllure">
        <button class="button">Get Allure Report</button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>JUNIT</b>
        <p class="spec-description">
            Perfect instrument for Java testing
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJUnit">
            <button class="button">Register</button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportJUnit">
                <button class="button">Get JUnit Report</button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>SELENIUM</b>
        <p class="spec-description">
            Effective framework for web testing
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSelenium">
            <button class="button">Register</button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportSelenium">
                <button class="button">Get Selenium Report</button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>

