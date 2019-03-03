<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="message" items="${list}">
        <jsp:include page="../fragments/message-card.jsp">
            <jsp:param name="id" value="${message.id}"/>
            <jsp:param name="userName" value="${message.name}"/>
            <jsp:param name="userId" value="${message.userId}"/>
            <jsp:param name="datum" value="${message.datum}"/>
            <jsp:param name="nachricht" value="${message.text}"/>
            <jsp:param name="current" value="${current}"/>
            <jsp:param name="themaId" value="${themaId}"/>
            <jsp:param name="updaterInfo" value="${message.updaterInfo}"/>
        </jsp:include>
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
        <jsp:param name="sorting" value="${sorting}"/>
        <jsp:param name="direction" value="${direction}"/>
        <jsp:param name="sizing" value="${sizing}"/>
        <jsp:param name="previous" value="${previous}"/>
        <jsp:param name="next" value="${next}"/>
        <jsp:param name="last" value="${last}"/>
    </jsp:include>
</div>