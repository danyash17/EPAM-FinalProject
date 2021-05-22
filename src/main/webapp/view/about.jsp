<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="local.navbar.about"/></title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<div style="margin: 100px">
    <div class="spec-header" align="center">
        <fmt:message key="local.about.head"/>
    </div>
    <div class="spec-column">
        <fmt:message key="local.about.credentials"/>
        <br>
        <fmt:message key="local.about.signature"/>
    </div>
</div>
</body>
</html>
