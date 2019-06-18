<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body class="body body-lighten">
<script type="text/javascript" src='<c:url value="/resources/js/unterricht.js"/>' defer></script>
<%--<jsp:include page="fragments/bodyNav.jsp"/>--%>
<br/>
<br/>

<div class="d-flex sidebar-toggle" id="wrapper">
    <jsp:include page="fragments/sidebarNav.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
                <div class="card border-light mb-3" id="calendar-card">
                    <div class="card-body">
                        <div id='calendar'></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/modal.jsp">
    <jsp:param name="url" value="../forms/unterricht-form.jsp"/>
    <jsp:param name="modalId" value="createUnterricht"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="saveUnterricht"/>
    <jsp:param name="onclick" value="saveUnterricht()"/>

</jsp:include>
</body>
</html>
