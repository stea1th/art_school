<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body class="body body-lighten">
<script type="text/javascript" src='<c:url value="/resources/js/profile.js"/>' defer></script>
<%--<jsp:include page="fragments/bodyNav.jsp"/>--%>
<br/>
<br/>

<div class="d-flex sidebar-toggle" id="wrapper">
    <jsp:include page="fragments/sidebarNav.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
                <div class="card border-light mb-3" id="table-card3">
                    <div class="card-body">
                        <jsp:include page="../jsp/forms/profile-form.jsp"/>
                        <hr>
                        <div class="form-control">
                            <jsp:include page="../jsp/buttons/save-and-close.jsp">
                                <jsp:param name="notModal" value="true"/>
                                <jsp:param name="saveId" value="saveProfile"/>
                                <jsp:param name="function" value="location.reload()"/>
                            </jsp:include>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../jsp/i18n/i18n-profile.jsp">
    <jsp:param name="page" value="profile"/>
</jsp:include>
</body>
</html>
