<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 20.03.2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="local.error.errormessage"/></title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<body>
<div style="color:#FF0000;">
    <h1>
        ${errorMessage}
    </h1>
</div>
</body>
</html>
