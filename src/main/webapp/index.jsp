<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="x-UTF-16LE-BOM"/>
    <title><fmt:message key="local.index.authorize"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/pagestyle.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<body class="index-body">
<jsp:include page="view/fragments/index-header.jsp"/>
<div class="index-main">
    <div style="color:#FF0000;" class="index-error">
        <h1>
            ${errorMessage}
        </h1>
    </div>
    <div class="index-login-form">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="login">
        <label>
            <fmt:message key="local.index.login" var="login"/>
            <input type="text" name="login" placeholder="${login}">
        </label>
        <br>
        <label>
            <fmt:message key="local.index.password" var="pass"/>
            <input type="password" name="password" placeholder="${pass}">
        </label>
        <br>
        <fmt:message key="local.index.authorize" var="auth"/>
        <input class="button" type="submit" value="${auth}">
    </form>
    </div>
</div>
</body>
</html>