<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">i18n-slider</jsp:attribute>
    <jsp:attribute name="lock"><spring:message code="slider.lock"/></jsp:attribute>
    <jsp:attribute name="unlock"><spring:message code="slider.unlock"/></jsp:attribute>
    <jsp:attribute name="hour"><spring:message code="slider.hour"/></jsp:attribute>
    <jsp:attribute name="hours"><spring:message code="slider.hours"/></jsp:attribute>
    <jsp:attribute name="minutes"><spring:message code="slider.minutes"/></jsp:attribute>
</jsp:element>
