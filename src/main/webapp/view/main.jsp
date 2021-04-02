<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>EPAM Faculties</title>
 <link rel="stylesheet" href="../../static/pagestyle.css">
</head>
<%--<jsp:include page="fragments/top-nav.jsp"/>--%>
<body class="main-body">
<div class="top">
 <div class="main-hello">Hello,${name}</div>
 <a href="#contact">Contact</a>
 <a href="#about">About</a>
 <a class="active" href="#home">Home</a>
</div>
<div class="main-faculties">EPAM Faculties</div>
<div class="main-threefacs">
 <a class="dev-ref" href="#development">Development faculty</a>
 <a class="qa-ref" href="#qa">QA faculty</a>
 <a class="smm-ref" href="#smm">SMM faculty</a>
</div>
<div class="row">
 <div class="col-3">
  <div class="dev-image"><img src="../images/dev.png" height="325"
                            alt="dev"></div>
 </div>
 <div class="col-3">
  <div class="qa-image"><img src="../images/testing.png" height="300"
                              alt="dev"></div>
 </div>
 <div class="col-3">
  <div class="smm-image"><img src="../images/smm.png" height="300"
                             alt="dev"></div>
 </div>
</div>
</body>
</html>
