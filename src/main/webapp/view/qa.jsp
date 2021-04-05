<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>QA faculty</title>
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/qa.png" width="300" height="300" align="left">
<b class="spec-header">QA faculty
</b>
<p class="spec-description">
    The QA Faculty invites you to get useful experience in computer testing.
    You can get into one of the following specialties: Allure,Junit and Selenium.
    You can choose a specialty below:
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>ALLURE</b>
        <p class="spec-description">
            Flex framework from Yandex
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAllure">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>JUNIT</b>
        <p class="spec-description">
            Perfect instrument for Java testing
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerJUnit">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>SELENIUM</b>
        <p class="spec-description">
            Effective framework for web testing
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSelenium">
            <button class="button">Register</button>
        </form>
    </div>
</div>
</body>
</html>

