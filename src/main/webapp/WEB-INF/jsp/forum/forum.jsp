<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body class="body body-lighten">
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
<%--<jsp:include page="../fragments/bodyNav.jsp"/>--%>

<br/>
<br/>

<div class="d-flex sidebar-toggle" id="wrapper">
    <jsp:include page="../fragments/sidebarNav.jsp"/>
    <%--<div class="container">--%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
                <%--<br>--%>
                <div class="card border-light mb-3" id="table-card3">
                    <div class="card-body">
                        <div class="d-flex">
                            <div class="mr-auto p-2">
                                <sec:authorize access="not ${isBanned}">
                                    <button type="button" class="btn btn-primary" style="float:left"
                                            onclick="answerIt(null, true)"><span><i class="fas fa-plus"></i></span>
                                        <spring:message code="forum.theme.new"/>
                                    </button>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <button type="button" id="delete-themes-btn" class="btn btn-danger" style="float:left"
                                            onclick="deleteThemes()"><span><i class="fas fa-trash"></i></span>
                                        <spring:message code="button.delete"/>
                                    </button>
                                </sec:authorize>
                            </div>
                            <div class="ml-auto p-2">
                                <jsp:include page="../fragments/table-size-selector.jsp">
                                    <jsp:param name="link" value="${link}"/>
                                    <jsp:param name="size" value="${size}"/>
                                </jsp:include>
                            </div>
                        </div>
                        <div id="forum-themes">
                            <h1>
                                <span>Art School <spring:message code="forum.name"/></span>
                            </h1>
                            <div class="wrapper">
                                <%@ include file="fragment.jsp" %>
                            </div>
                            <div id="add-message">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--</div>--%>
</div>
<spring:message code="forum.attention" var="attention"/>
<spring:message code="button.itsclear" var="buttonAccepted"/>
<jsp:include page="../fragments/modal.jsp">
    <jsp:param name="modalId" value="isBlocked"/>
    <jsp:param name="modalTitel" value="${attention}"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="accepted"/>
    <jsp:param name="buttonName" value="${buttonAccepted}"/>
</jsp:include>

<spring:message code="app.edit.theme.title" var="editTitle"/>
<spring:message code="forum.edit" var="buttonAccepted"/>
<jsp:include page="../fragments/modal.jsp">
    <jsp:param name="modalId" value="edit-title"/>
    <jsp:param name="modalTitel" value="${editTitle}"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="edited"/>
    <jsp:param name="buttonName" value="${buttonAccepted}"/>
</jsp:include>

</body>

<jsp:include page="../i18n/i18n-forum.jsp">
    <jsp:param name="forum" value="forum"/>
</jsp:include>
</html>
