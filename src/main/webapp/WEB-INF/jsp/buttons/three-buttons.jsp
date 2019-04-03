<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<c:set var="thirdButtonClass" value="btn btn-outline-info"/>
<button id="${param.thirdButtonId}" class="${not empty param.thirdButtonClass? param.thirdButtonClass : thirdButtonClass}">${param.thirdButtonName}</button>
<jsp:include page="save-and-close.jsp">
    <jsp:param name="saveId" value="${param.saveId}"/>
    <jsp:param name="primaryClass" value="${param.primaryClass}"/>
    <jsp:param name="buttonName" value="${param.buttonName}"/>

</jsp:include>
