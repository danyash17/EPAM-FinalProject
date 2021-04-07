<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 06.04.2021
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account</title>
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<img src="/images/enrolee.png" width="300" height="300" align="left">
<div class="spec-header">Current user: <i>${name} ${surname}</i></div>
<div class="account-row">
<pre class="account-info-query">
    <b style="color: white">City:</b>   ${city}<br>
    <b style="color: white">Birthday:</b>   ${birthday}<br>
    <b style="color: white">Medal:</b>  <c:if test="${medal==true}">✔</c:if><c:if test="${medal==false}">✘</c:if><br>
    <b style="color: white">Specialization:</b> <c:if test="${specializationId==null}">Not choosed</c:if><br>
</pre>
<pre class="account-info-grades">
    <b style="color: white">First Exam:</b>   ${first_exam}<br>
    <b style="color: white">Second Exam:</b>   ${second_exam}<br>
    <b style="color: white">Third Exam:</b>   ${third_exam}<br>
    <b style="color: white">Grade:</b>   ${grade}<br>
    <b style="color: white">TOTAL GRADE:</b>   ${grade+(first_exam+second_exam+third_exam)*10}<br>
</pre>
</div>
<form action="${pageContext.request.contextPath}/controller" >
    <input type="hidden" name="command" value="changeAccountData">
    <button class="button">Change data</button>
</form>
</body>
</html>
