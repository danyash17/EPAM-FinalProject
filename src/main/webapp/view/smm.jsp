<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="local.faculty.smm.header"/></title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/smm.png" width="300" height="300" align="left">
<b class="spec-header"><fmt:message key="local.faculty.smm.header"/>
</b>
<p class="spec-description">
    <fmt:message key="local.faculty.smm.description"/>
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>SEO</b>
        <p class="spec-description"><fmt:message key="local.faculty.smm.description.seo"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSEO">
            <button class="button"><fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportSEO">
            <button class="button"><fmt:message key="local.account.admin.button.smm.seo"/></button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>Adversiting</b>
        <p class="spec-description"><fmt:message key="local.faculty.smm.description.adv"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAdv">
                <button class="button"><fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportAdv">
                <button class="button"><fmt:message key="local.account.admin.button.smm.adv"/></button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>Soft Skills</b>
        <p class="spec-description"><fmt:message key="local.faculty.smm.description.ss"/>
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSoft">
                <button class="button"><fmt:message key="local.faculty.registerbutton"/></button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportSoft">
                <button class="button"><fmt:message key="local.account.admin.button.smm.ss"/></button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
