<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel='stylesheet' href='resources/css/login.css' />
    <script src="../../resources/js/polygonizr/polygonizr.min.js"></script>
</head>
<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<div id="polygonizr"></div>



<!-- Modal HTML -->
<spring:message code="app.login" var="login"/>
<jsp:include page="fragments/modal.jsp">
    <jsp:param name="url" value="../forms/login-form.jsp"/>
    <jsp:param name="modalId" value="login-modal"/>
    <jsp:param name="modalTitel" value="${login}" />
</jsp:include>

</body>
</html>