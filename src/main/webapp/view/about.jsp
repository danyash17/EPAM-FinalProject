<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="local"/>
<html>
<head>
    <title>QA faculty</title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<div style="margin: 100px">
<div class="spec-header" align="center">
    Final EPAM project<br> for Java Web Training
</div>
<div class="spec-column">
    Made by Daniil Shkabara
    <br>
    Minsk,2021
</div>
</div>
</body>
</html>
