<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="message" items="${list}">
        <c:set var="message" value="${message}" />
        <c:set var="current" value="${current}" />
        <c:set var="themaId" value="${themaId}" />
        <%@ include file="message-card.jsp"%>
    </c:forEach>
</div>
<hr>
<div>
    <jsp:include page="../fragments/pagination.jsp">
        <jsp:param name="themaId" value="${themaId}"/>
        <jsp:param name="link" value="${link}"/>
        <jsp:param name="hasPrevious" value="${hasPrevious}"/>
        <jsp:param name="hasNext" value="${hasNext}"/>
        <jsp:param name="items" value="${items}"/>
        <jsp:param name="direction" value="${direction}"/>
        <jsp:param name="size" value="${size}"/>
        <jsp:param name="previous" value="${previous}"/>
        <jsp:param name="next" value="${next}"/>
        <jsp:param name="last" value="${last}"/>
    </jsp:include>
</div>