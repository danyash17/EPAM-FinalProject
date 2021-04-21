<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
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
            <input type="text" name="login" placeholder="Login">
        </label>
        <br>
        <label>
            <input type="password" name="password" placeholder="Password">
        </label>
        <br>
        <input class="button" type="submit" value="Log in">
    </form>
    </div>
</div>
</body>
</html>