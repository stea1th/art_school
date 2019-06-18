<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body class="body body-lighten">
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
<%--<jsp:include page="../fragments/bodyNav.jsp"/>--%>

<br/>
<br/>

<div class="d-flex" id="wrapper">
    <jsp:include page="../fragments/sidebarNav.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 ml-auto mr-auto">
                <%--<br>--%>
                <div class="card border-light mb-3" id="table-card3">
                    <div class="card-body">
                        <div class="row">
                            <h3 style="color: #1474C3;padding-left:20px;padding-bottom:20px; padding-top:20px;">
                                <c:out value="${title}"/>
                                <c:if test="${active == false}">

                                <span style="color:red;">&nbsp;(<spring:message code="forum.closedby"/>&nbsp;<c:out
                                        value="${closedBy}"/>)</span>
                                </c:if>
                            </h3>
                            <c:url var="back" value="/forum">
                                <c:param name="id" value="${themaId}"/>
                                <c:param name="page" value="${themaPage}"/>
                                <c:param name="size" value="${themaSize}"/>
                            </c:url>
                            <span style="padding-left:10px;padding-top:20px;">&nbsp;
                            <a type="button" class="btn btn-primary btn-sm" href="${back}">
                                <span><i class="fas fa-angle-double-left"></i></span>&nbsp;
                                <spring:message code="app.back"/></a>
                        </span>
                        </div>
                        <input type="hidden" class="form-control" id="themaId" name="themaId" value="${themaId}"/>
                        <div class="d-flex align-items-center">
                            <div class="mr-auto p-2 ">
                                <sec:authorize access="not ${isBanned}">
                                    <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                        <button type="button" class="btn btn-warning btn-sm" style="float:right"
                                                onclick="toggleAttach(${themaId})">
                                            <c:if test="${isAttached == true}">
                                                <spring:message code="forum.theme.detach"/>
                                            </c:if>
                                            <c:if test="${isAttached == false}">
                                                <spring:message code="forum.theme.attach"/>
                                            </c:if>
                                        </button>
                                    </sec:authorize>
                                    <c:if test="${active != false}">
                                        <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                            <button type="button" class="btn btn-danger btn-sm" style="float:right"
                                                    onclick="toggleThema(${themaId})">
                                                <spring:message code="forum.theme.close"/>
                                            </button>
                                        </sec:authorize>
                                        <button type="button" class="btn btn-primary btn-sm" style="float:right"
                                                onclick="answerIt(null, true)">
                                            <i class="fas fa-plus"></i>&nbsp;
                                            <spring:message code="forum.theme"/>
                                        </button>
                                        <button type="button" class="btn btn-success btn-sm" style="float:right"
                                                onclick="answerIt()">
                                            <i class="fas fa-plus"></i>&nbsp;
                                            <spring:message code="forum.message"/>
                                        </button>
                                    </c:if>
                                    <c:if test="${active == false}">
                                        <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                            <button type="button" class="btn btn-danger btn-sm" style="float:right"
                                                    onclick="toggleThema(${themaId})">
                                                <spring:message code="forum.theme.open"/>
                                            </button>
                                        </sec:authorize>
                                    </c:if>

                                </sec:authorize>
                            </div>
                            <div class="ml-auto p-2">
                                <jsp:include page="../fragments/table-size-selector.jsp">
                                    <jsp:param name="themaId" value="${themaId}"/>
                                    <jsp:param name="link" value="${link}"/>
                                    <jsp:param name="size" value="${size}"/>
                                </jsp:include>
                            </div>
                        </div>
                        <hr>
                        <div id="nachricht-block">
                            <div class="wrapper">
                                <%@ include file="fragment.jsp" %>
                            </div>
                            <hr>
                            <div id="add-message">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fas fa-angle-double-up fa-2x"></i>
        </button>
    </div>
</div>
<spring:message code="forum.block.user" var="block"/>
<spring:message code="slider.lock" var="buttonBlock"/>
<jsp:include page="../fragments/modal.jsp">
    <jsp:param name="url" value="../forms/block-form.jsp"/>
    <jsp:param name="modalId" value="createBlock"/>
    <jsp:param name="modalTitel" value="${block}"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="saveBlock"/>
    <jsp:param name="buttonName" value="${buttonBlock}"/>
</jsp:include>

</body>
</html>
