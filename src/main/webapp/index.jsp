<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<div class="main">
<form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="login">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="submit">
    </form>
</div>
</html>