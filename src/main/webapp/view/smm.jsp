<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 05.04.2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>SMM faculty</title>
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
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSEO">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>Adversiting</b>
        <p class="spec-description">
            Learn the rules of modern adversiting
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerAdv">
            <button class="button">Register</button>
        </form>
    </div>
    <div class="spec-column">
        <b>Soft Skills</b>
        <p class="spec-description">
            Being a good programmist is not only about coding
        </p>
        <form action="${pageContext.request.contextPath}/controller" >
            <input type="hidden" name="command" value="registerSoft">
            <button class="button">Register</button>
        </form>
    </div>
</div>
</body>
</html>
