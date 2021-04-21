<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="local"/>
<html lang="${lang}">
<head>
 <title>EPAM Faculties</title>
 <link rel="stylesheet" href="../../static/pagestyle.css">
 <link rel="shortcut icon" type="image/png" href="images/favicon.png">
</head>
<body class="common-body">
<jsp:include page="fragments/top-nav.jsp"/>
<div class="main-faculties"><fmt:message key="local.main.faculties"/></div>

<div class="main-threefacs">
 <form class="main-dev-form" action="${pageContext.request.contextPath}/controller">
  <input type="hidden" name="command" value="devPage">
  <button class="button"><fmt:message key="local.main.devfaculty"/></button>
 </form>
 <form class="main-qa-form" action="${pageContext.request.contextPath}/controller">
  <input type="hidden" name="command" value="qaPage">
  <button class="button"><fmt:message key="local.main.qafaculty"/></button>
 </form>
 <form class="main-smm-form" action="${pageContext.request.contextPath}/controller" >
  <input type="hidden" name="command" value="smmPage">
  <button class="button"><fmt:message key="local.main.smmfaculty"/></button>
 </form>
 </div>

<div class="row">
 <a class="col-3" href="${pageContext.request.contextPath}/controller?command=devPage">
  <div class="dev-image"><img src="../images/dev.png" height="325"
                            alt="dev"></div>
 </a>

 <a class="col-3" href="${pageContext.request.contextPath}/controller?command=qaPage">
  <div class="qa-image"><img src="../images/qa.png" height="300"
                             alt="qa"></div>
 </a>

 <a class="col-3" href="${pageContext.request.contextPath}/controller?command=smmPage">
  <div class="smm-image"><img src="../images/smm.png" height="300"
                             alt="smm"></div>
 </a>
</div>
</body>
</html>
