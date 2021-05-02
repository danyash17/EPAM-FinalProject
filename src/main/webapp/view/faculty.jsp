<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 01.05.2021
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <title>Faculty</title>
    <link rel="stylesheet" href="../../static/pagestyle.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<body class="common-body">
<jsp:include page="fragments/top-nav.jsp"/>
<div class="spec-header"><b>${selectedFaculty.faculty}</b>
    <img src="${selectedFacultyImage.path}" width="70,49" height="70,49">
</div>
<p class="spec-description">${selectedFaculty.description}
</p>
<div class="main-table">

    <c:forEach var="specialization" items="${specializationMap}">
        <table class="pagination-table">
            <tr>
                <th colspan="3">
                    <b class="spec-column">${specialization.key.specialization}</b>
                    <br/>
                    <q>${specialization.key.description}</q>
                    <c:if test="${role=='ENROLEE'}">
                        <form action="${pageContext.request.contextPath}/controller" >
                            <input type="hidden" name="command" value="register">
                            <input type="hidden" name="registrationId" value="${specialization.key.id}" >
                            <button class="button">Register</button>
                        </form>
                    </c:if>
                    <c:if test="${role=='ADMIN'}">
                        <form action="${pageContext.request.contextPath}/controller" >
                            <input type="hidden" name="command" value="report">
                            <input type="hidden" name="page" value="1">
                            <input type="hidden" name="applicantsPerPage" value="5">
                            <input type="hidden" name="reportingSpecializationId" value="${specialization.key.id}">
                            <button class="button">Get ${specialization.key.specialization} report</button>
                        </form>
                    </c:if>
                </th>
            </tr>
            <tr>
                <th colspan="3">
                    <img src="${specialization.value.path}" width="150" height="150">
                </th>
            </tr>
        </table>
    </c:forEach>
</div>
<jsp:include page="fragments/specialization-pagination.jsp"/>
</body>
</html>
