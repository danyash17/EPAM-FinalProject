<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="local"/>
<html>
<head>
    <title>QA faculty</title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/qa.png" width="300" height="300" align="left">
<b class="spec-header"><fmt:message key="local.faculty.qa.header"/>
</b>
<p class="spec-description"><fmt:message key="local.faculty.qa.description"/>
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>ALLURE</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.qa.description.allure"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAllure">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportAllure">
        <button class="button">
            <fmt:message key="local.account.admin.button.qa.allure"/></button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>JUNIT</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.qa.description.junit"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJUnit">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportJUnit">
                <button class="button">
                    <fmt:message key="local.account.admin.button.qa.junit"/></button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>SELENIUM</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.qa.description.selenium"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSelenium">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportSelenium">
                <button class="button">
                    <fmt:message key="local.account.admin.button.qa.selenium"/></button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>

