<%@ page import="com.epam.web.entity.Application" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 16.04.2021
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<head>
    <title><fmt:message key="local.account.admin.report"/></title>
    <link rel="stylesheet" href="../../static/pagestyle.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<html lang="${sessionScope.lang}">
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<c:if test="${reportIsFormed}">
    <div align="center">
        <table class="report-table" border="1" cellpadding="5">
            <caption><h2>${specializationName}</h2></caption>
            <tr>
                <th><fmt:message key="local.report.name"/>,<fmt:message key="local.report.surname"/></th>
                <th><fmt:message key="local.report.countrycity"/></th>
                <th><fmt:message key="local.report.medal"/></th>
                <th><fmt:message key="local.report.grade"/></th>
            </tr>
            <c:forEach var="application" items="${appliedEnroleesMap}">
                <c:if test="${application.value}"><c:set var="rowstyle" value="report-applied"/></c:if>
                <c:if test="${!application.value}"><c:set var="rowstyle" value="report-denied"/></c:if>
                <tr class="${rowstyle}">
                    <td>${application.key.name} ${application.key.surname}(${application.key.sex})</td>
                    <td>${application.key.country},${application.key.city}</td>
                    <td><c:if test="${application.key.medal}">✔</c:if>
                        <c:if test="${!application.key.medal}">✘</c:if></td>
                    <td>${application.key.firstExam+application.key.secondExam+application.key.thirdExam+application.key.grade}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<c:if test="${!reportIsFormed}">
    <div class="report-message">${reportMessage}</div>
</c:if>
<jsp:include page="fragments/report-pagination.jsp"/>
</body>
</html>
