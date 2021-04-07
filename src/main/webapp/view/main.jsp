<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>EPAM Faculties</title>
 <link rel="stylesheet" href="../../static/pagestyle.css">
</head>
<body class="common-body">
<div class="top">
 <div class="main-hello">Hello,${name}</div>
 <a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a>
 <a href="${pageContext.request.contextPath}/controller?command=aboutPage">About</a>
 <a href="${pageContext.request.contextPath}/controller?command=accountData">Account</a>
 <a class="active" href="${pageContext.request.contextPath}/controller?command=mainPage">Home</a>
</div>
<div class="main-faculties">EPAM Faculties</div>

<div class="main-threefacs">
 <form class="main-dev-form" action="${pageContext.request.contextPath}/controller">
  <input type="hidden" name="command" value="devPage">
  <button class="button">Dev faculty</button>
 </form>
 <form class="main-qa-form" action="${pageContext.request.contextPath}/controller">
  <input type="hidden" name="command" value="qaPage">
  <button class="button">QA faculty</button>
 </form>
 <form class="main-smm-form" action="${pageContext.request.contextPath}/controller" >
  <input type="hidden" name="command" value="smmPage">
  <button class="button">SMM faculty</button>
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
