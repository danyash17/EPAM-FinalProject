<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 06.04.2021
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html>
<head lang="${sessionScope.lang}">
    <title><fmt:message key="local.navbar.account"/></title>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<c:if test="${role=='ENROLEE'}">
<img src="/images/enrolee.png" width="300" height="300" align="left">
<div class="spec-header"><fmt:message key="local.account.enrolee.header"/>: <i>${name} ${surname}</i></div>
<div class="account-row">
<pre class="account-info-query">
    <b style="color: white"><fmt:message key="local.account.enrolee.info.countryandcity"/>:</b> ${country},${city}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.birthday"/>:</b> ${birthday}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.medal"/>:</b>  <c:if test="${medal==true}">✔</c:if><c:if test="${medal==false}">✘</c:if><br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.choosedspecialization"/>:</b> ${specialization}<c:if test="${specialization_id==null}">Not choosed</c:if><br>
</pre>
    <pre class="account-info-grades">
    <b style="color: white"><fmt:message key="local.account.enrolee.info.firstexam"/>:</b> ${first_exam}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.secondexam"/>:</b> ${second_exam}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.thirdexam"/>:</b> ${third_exam}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.grade"/>:</b> ${grade}<br>
    <b style="color: white"><fmt:message key="local.account.enrolee.info.totalgrade"/>:</b> ${grade+first_exam+second_exam+third_exam}<br>
</pre>
    <div class="rolling-text">
        <span class="textUpper">${successMessage}</span>
        <span class="textDown">${newSpecialization}</span>
    </div>
    </c:if>
    <c:if test="${role=='ADMIN'}">
        <img src="/images/admin.png" width="300" height="300" align="left">
        <div class="spec-header"><fmt:message key="local.account.admin.header"/></div>
        <pre class="account-info-query">
    <fmt:message key="local.account.admin.choose"/>:
    </pre>
        <div class="spec-row">
            <div class="spec-column">
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="devPage">
                    <button class="button"><fmt:message key="local.account.admin.button.dev"/></button>
                </form>
            </div>
            <div class="spec-column">
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="qaPage">
                    <button class="button"><fmt:message key="local.account.admin.button.qa"/></button>
                </form>
            </div>
            <div class="spec-column">
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="smmPage">
                    <button class="button"><fmt:message key="local.account.admin.button.smm"/></button>
                </form>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
