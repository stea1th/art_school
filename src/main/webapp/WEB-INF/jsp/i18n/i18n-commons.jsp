<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">i18n-commons</jsp:attribute>
    <jsp:attribute name="warningEmptyField"><spring:message code="error.required.field"/></jsp:attribute>
    <jsp:attribute name="invalidPassword"><spring:message code="error.invalid.password"/></jsp:attribute>
    <jsp:attribute name="invalidEmail"><spring:message code="error.invalid.email"/></jsp:attribute>
    <jsp:attribute name="chooseRole"><spring:message code="app.choose.role"/></jsp:attribute>
</jsp:element>
