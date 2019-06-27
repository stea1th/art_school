<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">i18n-commons</jsp:attribute>
    <jsp:attribute name="warningEmptyField"><spring:message code="error.required.field"/></jsp:attribute>
</jsp:element>
