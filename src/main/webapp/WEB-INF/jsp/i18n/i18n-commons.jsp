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
    <jsp:attribute name="chooseStudent"><spring:message code="app.choose.student"/></jsp:attribute>
    <jsp:attribute name="choosePayment"><spring:message code="app.choose.payment"/></jsp:attribute>
    <jsp:attribute name="note"><spring:message code="app.note"/></jsp:attribute>
    <jsp:attribute name="createLesson"><spring:message code="app.create.lesson"/></jsp:attribute>
    <jsp:attribute name="editLesson"><spring:message code="app.edit.lesson"/></jsp:attribute>
    <jsp:attribute name="delete"><spring:message code="button.delete"/></jsp:attribute>
    <jsp:attribute name="makeActive"><spring:message code="app.activate"/></jsp:attribute>
    <jsp:attribute name="makeDeactive"><spring:message code="app.deactivate"/></jsp:attribute>

</jsp:element>
