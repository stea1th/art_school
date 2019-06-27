<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">i18n</jsp:attribute>
    <jsp:attribute name="invalidPassword"><spring:message code="${param.page}.invalid.password"/></jsp:attribute>
    <jsp:attribute name="invalidEmail"><spring:message code="${param.page}.invalid.email"/></jsp:attribute>
    <jsp:attribute name="saveProfile"><spring:message code="profile.save.successfull"/></jsp:attribute>
    <jsp:attribute name="noPhoto"><spring:message code="${param.page}.nophoto"/></jsp:attribute>

</jsp:element>