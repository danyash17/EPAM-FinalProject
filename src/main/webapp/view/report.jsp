<%@ page import="com.epam.web.entity.Query" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 16.04.2021
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="../../static/pagestyle.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<jsp:include page="fragments/top-nav.jsp"/>
<body class="common-body">
<c:if test="${reportIsFormed}">
    <% Map<Query, Boolean> map = (Map<Query, Boolean>) request.getSession().getAttribute("appliedEnroleesMap");%>
    <div align="center">
        <table class="report-table" border="1" cellpadding="5">
            <caption><h2>${specializationName} specialization list:</h2></caption>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Country,City</th>
                <th>Birthday</th>
                <th>School</th>
                <th>Medal</th>
                <th>Grade</th>
            </tr>
            <% for (Query i : map.keySet()) {%>
            <%String type = "report-denied";%>
            <c:if test="<%=map.get(i)%>"><%type = "report-applied";%></c:if>
            <tr class="<%=type%>">
                <td>
                    <%=i.getEnroleeName()%>(<%=i.getSexEnum()%>)
                </td>
                <td>
                    <%=i.getEntoleeSurname()%>
                </td>
                <td>
                    <%=i.getCountry()%>,<%=i.getCity()%>
                </td>
                <td>
                    <%=i.getBirthday()%>
                </td>
                <td>
                    <%=i.getSchool()%>
                </td>
                <td>
                    <c:if test="<%=i.hasMedal()%>">✔</c:if>
                    <c:if test="<%=!i.hasMedal()%>">✘</c:if>
                </td>
                <td>
                    <%=i.getTotalGrade()%>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
</c:if>
<c:if test="${!reportIsFormed}">
    <div class="report-message">${reportMessage}</div>
</c:if>
</body>
</html>
