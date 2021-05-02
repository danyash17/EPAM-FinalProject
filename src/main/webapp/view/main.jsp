<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${sessionScope.lang}">
<head>
    <title>EPAM Faculties</title>
    <link rel="stylesheet" href="../../static/pagestyle.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<body class="common-body">
<jsp:include page="fragments/top-nav.jsp"/>
<div class="main-faculties"><fmt:message key="local.main.faculties"/></div>
<div class="main-table">
    <c:set var="count" value="1" scope="page"/>
    <c:forEach var="faculty" items="${facultyMap}">
        <table class="pagination-table">
            <tr>
                <th colspan="3">
                    <form action="${pageContext.request.contextPath}/controller">
                        <input type="hidden" name="command" value="loadFaculty">
                        <input type="hidden" name="currentFaculty" value="${faculty.key.facultyId}">
                        <input type="hidden" name="page" value="1">
                        <input type="hidden" name="specializationsPerPage" value="3">
                        <button class="button">${faculty.key.faculty}</button>
                    </form>
                </th>
            </tr>
            <tr align="center">
                <td>${faculty.key.firstExam}</td>
                <td>${faculty.key.secondExam}</td>
                <td>${faculty.key.thirdExam}</td>
            </tr>
            <tr>
                <th colspan="3">
                    <img src="${faculty.value.path}" width="150" height="150">
                </th>
            </tr>
        </table>
    </c:forEach>
</div>
<jsp:include page="fragments/faculty-pagination.jsp"/>
</body>
</html>
