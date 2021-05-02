<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 02.05.2021
  Time: 12:19
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
</head>
<body>
<section class="pagination">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="loadFaculty">
        <input type="hidden" name="page" value="${param.page-1}">
        <input type="hidden" name="currentFaculty" value="${param.currentFaculty}">
        <input type="hidden" name="specializationsPerPage" value="${param.specializationsPerPage}">
        <c:if test="${param.page>1}"><button class="button-round"><</button></c:if>
    </form>
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="loadFaculty">
        <input type="hidden" name="page" value="${param.page+1}">
        <input type="hidden" name="currentFaculty" value="${param.currentFaculty}">
        <input type="hidden" name="specializationsPerPage" value="${param.specializationsPerPage}">
        <c:if test="${hasNext}"><button class="button-round">></button></c:if>
    </form>
</section>
</body>
</html>
