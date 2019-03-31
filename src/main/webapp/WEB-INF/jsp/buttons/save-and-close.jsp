<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<c:choose>
    <c:when test="${param.buttonName != null}">
        <button type="button" class="btn btn-primary" id="${param.saveId}">${param.buttonName}</button>
    </c:when>
    <c:otherwise>
        <button type="button" class="btn btn-primary" id="${param.saveId}"><spring:message code="button.save"/></button>
    </c:otherwise>
</c:choose>

<button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code="button.close"/></button>