<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>


<spring:message code="button.save" var="save"/>
<button type="button" class="btn btn-primary" id="${param.saveId}">${param.buttonName != null? param.buttonName : save}
</button>

<button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code="button.close"/></button>