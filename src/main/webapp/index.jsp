<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="static/style.css">
</head>
<jsp:include page="view/fragments/index-header.jsp"/>
<div class="main">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="login">
        <input type="text" name="username">
            <br>
        <input type="password" name="password">
            <br>
        <input type="submit" value="submit">
    </form>
</div>
</html>