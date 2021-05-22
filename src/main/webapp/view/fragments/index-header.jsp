<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 22.03.2021
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <link rel="stylesheet" href="../../static/pagestyle.css">
</head>
<body>
<div class="header">
    <fmt:message key="local.index.universityheader"/>
</div>
</body>
</html>
