<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/statistik.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<br/>
<h1 align="center">Statistik</h1>
<div align="center">
    <input type="button" value="Test" id="test-btn"/>
</div>

</body>
</html>
