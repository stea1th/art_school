<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="message" items="${list}">
        <c:set var="message" value="${message}"/>
        <c:set var="themaId" value="${themaId}"/>
        <%@ include file="message-card.jsp" %>
    </c:forEach>
</div>
<hr>
<div class="d-flex">
    <div class="ml-auto">
        <%@ include file="../fragments/pagination.jsp" %>
    </div>
</div>