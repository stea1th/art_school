<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
<jsp:include page="../fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <div class="d-flex">
                        <div class="mr-auto p-2">
                            <button type="button" class="btn btn-primary" style="float:right" onclick="answerIt(null, true)"><spring:message
                                    code="forum.theme"/>
                            </button>
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
<spring:message code="forum.attention" var="attention"/>
<spring:message code="button.itsclear" var="buttonAccepted"/>
<jsp:include page="../fragments/modal.jsp">
    <jsp:param name="modalId" value="isBlocked"/>
    <jsp:param name="modalTitel" value="${attention}"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="accepted" />
    <jsp:param name="buttonName" value="${buttonAccepted}"/>
</jsp:include>

</body>

<jsp:include page="../forum/i18n-forum.jsp">
    <jsp:param name="forum" value="forum"/>
</jsp:include>
</html>
