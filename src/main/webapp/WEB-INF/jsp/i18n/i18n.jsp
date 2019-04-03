<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">hidden-param</jsp:attribute>
    <jsp:attribute name="addTitle"><spring:message code="${param.page}.add"/></jsp:attribute>
    <jsp:attribute name="updateTitle"><spring:message code="${param.page}.update"/></jsp:attribute>
</jsp:element>
