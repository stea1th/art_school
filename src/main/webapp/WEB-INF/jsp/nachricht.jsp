<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/nachricht.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div align="center">
    <h1>FORUM</h1>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <h3>
                        <c:out value="${title}"/>
                    </h3>
                    <div class="d-flex">
                        <div class="ml-auto p-2">
                            <jsp:include page="fragments/table-size-selector.jsp">
                                <jsp:param name="themaId" value="${themaId}"/>
                                <jsp:param name="sorting" value="${sorting}"/>
                                <jsp:param name="direction" value="${direction}"/>
                                <jsp:param name="link" value="${link}"/>
                            </jsp:include>
                        </div>
                    </div>
                    <div>
                        <c:forEach var="message" items="${list}">
                            <jsp:include page="fragments/message-card.jsp">
                                <jsp:param name="id" value="${message.id}"/>
                                <jsp:param name="userName" value="${message.name}"/>
                                <jsp:param name="userId" value="${message.userId}"/>
                                <jsp:param name="datum" value="${message.datum}"/>
                                <jsp:param name="nachricht" value="${message.text}"/>
                                <jsp:param name="current" value="${current}"/>
                                <jsp:param name="themaId" value="${themaId}" />
                                <jsp:param name="updaterInfo" value="${message.updaterInfo}" />
                            </jsp:include>
                        </c:forEach>
                    </div>
                    <hr>
                    <div>
                        <jsp:include page="fragments/pagination.jsp">
                            <jsp:param name="themaId" value="${themaId}"/>
                            <jsp:param name="link" value="${link}"/>
                            <jsp:param name="hasPrevious" value="${hasPrevious}"/>
                            <jsp:param name="hasNext" value="${hasNext}"/>
                            <jsp:param name="items" value="${items}"/>
                            <jsp:param name="sorting" value="${sorting}"/>
                            <jsp:param name="direction" value="${direction}"/>
                            <jsp:param name="sizing" value="${sizing}"/>
                            <jsp:param name="previous" value="${previous}"/>
                            <jsp:param name="next" value="${next}"/>
                            <jsp:param name="last" value="${last}"/>
                        </jsp:include>
                    </div>
                    <hr>
                        <jsp:include page="fragments/nachricht-form.jsp">
                            <jsp:param name="themaId" value="${themaId}" />
                        </jsp:include>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
