<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>


<spring:message code="button.save" var="save"/>
<c:set value="btn btn-primary" var="primaryClass"/>
<button type="button" class="${not empty param.primaryClass? param.primaryClass : primaryClass}" id="${param.saveId}">${not empty param.buttonName? param.buttonName : save}
</button>
<c:choose>
    <c:when test="${empty param.notModal}">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code="button.close"/></button>
    </c:when>
    <c:otherwise>
        <button type="button" class="btn btn-secondary btn-cancel" onclick="${param.function}"><spring:message code="button.cancel"/></button>
    </c:otherwise>
</c:choose>
