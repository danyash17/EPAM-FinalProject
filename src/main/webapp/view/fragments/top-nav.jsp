<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 22.03.2021
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<body>
<head>
    <meta http-equiv="Content-Type" content="text/htmL; charset=UTF-8">
    <link rel="stylesheet" href="../../static/pagestyle.css">
</head>
<div class="top">
    <div class="main-hello"><fmt:message key="local.main.greeting"/>,${name}</div>
    <a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="local.navbar.logout"/></a>
    <div class="dropdown">
        <button class="dropbtn"><fmt:message key="local.navbar.lang"/> ▼
            <i class="fa fa-caret-down" aria-hidden="true"></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/controller?command=localization&sessionLocale=en"><fmt:message
                    key="local.navbar.lang.en"/></a>
            <a href="${pageContext.request.contextPath}/controller?command=localization&sessionLocale=ru"><fmt:message
                    key="local.navbar.lang.ru"/></a>
            <a href="${pageContext.request.contextPath}/controller?command=localization&sessionLocale=de"><fmt:message
                    key="local.navbar.lang.de"/></a>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/controller?command=aboutPage"><fmt:message
            key="local.navbar.about"/></a>
    <c:if test="${role=='ADMIN'}">
        <c:set var="facPaginate" value="&page=1&facultiesPerPage=3"/>
    </c:if>
    <c:if test="${role=='ENROLEE'}">
        <c:set var="facPaginate" value=""/>
    </c:if>
    <a href="${pageContext.request.contextPath}/controller?command=accountData${facPaginate}"><fmt:message
            key="local.navbar.account"/></a>
    <a class="active"
       href="${pageContext.request.contextPath}/controller?command=loadMain&page=1&facultiesPerPage=3"><fmt:message
            key="local.navbar.home"/></a>
</div>
</body>
</html>
