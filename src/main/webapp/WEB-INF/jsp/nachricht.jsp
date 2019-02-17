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
                    <div>
                        <c:forEach var="message" items="${list}">
                            <jsp:include page="fragments/messageCard.jsp">
                                <jsp:param name="id" value="${message.id}"/>
                                <jsp:param name="userName" value="${message.name}"/>
                                <jsp:param name="datum" value="${message.datum}"/>
                                <jsp:param name="nachricht" value="${message.text}"/>
                                <jsp:param name="current" value="${current}"/>
                                <jsp:param name="thema_id" value="${thema_id}" />
                            </jsp:include>
                        </c:forEach>
                    </div>
                    <br><hr>
                        <jsp:include page="fragments/nachricht_form.jsp">
                            <jsp:param name="thema_id" value="${thema_id}" />
                        </jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
