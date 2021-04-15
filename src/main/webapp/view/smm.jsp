<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SMM faculty</title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="images/smm.png" width="300" height="300" align="left">
<b class="spec-header">SMM faculty
</b>
<p class="spec-description">
    The SMM Faculty invites you to get useful experience in social media marketing.
    You can get into one of the following specialties: SEO,Adversiting and Soft Skills.
    You can choose a specialty below:
</p>
<div class="spec-row">
    <div class="spec-column">
        <b>SEO</b>
        <p class="spec-description">
            Become a specialist in Search Engine Optimization
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSEO">
            <button class="button">Register</button>
        </form>
</c:if>
<c:if test="${role=='ADMIN'}">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="reportSEO">
        <button class="button">Get SEO report</button>
    </form>
</c:if>
    </div>
    <div class="spec-column">
        <b>Adversiting</b>
        <p class="spec-description">
            Learn the rules of modern adversiting
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAdv">
            <button class="button">Register</button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportAdv">
                <button class="button">Get Adversiting report</button>
            </form>
        </c:if>
    </div>
    <div class="spec-column">
        <b>Soft Skills</b>
        <p class="spec-description">
            Being a good programmist is not only about coding
        </p>
<c:if test="${role=='ENROLEE'}">
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSoft">
            <button class="button">Register</button>
        </form>
</c:if>
        <c:if test="${role=='ADMIN'}">
            <form action="${pageContext.request.contextPath}/controller" >
                <input type="hidden" name="command" value="reportSEO">
                <button class="button">Get SS report</button>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
