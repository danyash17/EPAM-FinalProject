<%@ page import="com.epam.web.beans.Query" %>
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
                    <th><fmt:message key="local.report.name"/></th>
                    <th><fmt:message key="local.report.surname"/></th>
                    <th><fmt:message key="local.report.countrycity"/></th>
                    <th><fmt:message key="local.report.birthday"/></th>
                    <th><fmt:message key="local.report.school"/></th>
                    <th><fmt:message key="local.report.medal"/></th>
                    <th><fmt:message key="local.report.grade"/></th>
                </tr>
                <c:forEach var="query" items="${appliedEnroleesMap}">
                    <c:if test="${query.value}"><c:set var="rowstyle" value="report-applied"/></c:if>
                    <c:if test="${!query.value}"><c:set var="rowstyle" value="report-denied"/></c:if>
                    <tr class="${rowstyle}">
                        <td>${query.key.enroleeName}(${query.key.sexEnum})</td>
                        <td>${query.key.enroleeSurname}</td>
                        <td>${query.key.country},${query.key.city}</td>
                        <td>${query.key.birthday}</td>
                        <td>${query.key.school}</td>
                        <td><c:if test="${query.key.medal}">✔</c:if>
                            <c:if test="${!query.key.medal}">✘</c:if></td>
                        <td>${query.key.firstExam+query.key.secondExam+query.key.thirdExam+query.key.grade}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
    <c:if test="${!reportIsFormed}">
        <div class="report-message">${reportMessage}</div>
    </c:if>
    </body>
    </html>
