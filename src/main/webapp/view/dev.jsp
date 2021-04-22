<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="local.faculty.dev.header"/></title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/dev.png" width="300" height="300" align="left">
<b class="spec-header"><fmt:message key="local.faculty.dev.header"/>
</b>
<p class="spec-description">
    <fmt:message key="local.faculty.dev.description"/>
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>JAVA</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.dev.description.java"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJava" id="btnJava">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportJava" >
                <button class="button">
                    <fmt:message key="local.account.admin.button.dev.java"/></button></button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>C++</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.dev.description.c++"/>
        </p>
    <c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerC" id="btnC">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button></button>
        </form>
    </c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportC">
        <button class="button">
            <fmt:message key="local.account.admin.button.dev.c++"/></button></button></button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>PYTHON</b>
        <p class="spec-description">
            <fmt:message key="local.faculty.dev.description.python"/>
        </p>
        <c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerPython" id="btnPython">
            <button class="button">
                <fmt:message key="local.faculty.registerbutton"/></button></button>
        </form>
        </c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportPython">
                <button class="button">
                    <fmt:message key="local.account.admin.button.dev.python"/></button></button></button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
