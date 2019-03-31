<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">i18n</jsp:attribute>
    <jsp:attribute name="attentionBlock"><spring:message code="${param.forum}.attention.block"/></jsp:attribute>
    <jsp:attribute name="reason"><spring:message code="${param.forum}.reason"/></jsp:attribute>
    <jsp:attribute name="blockedBy"><spring:message code="${param.forum}.blockedby"/></jsp:attribute>
    <jsp:attribute name="blockedTill"><spring:message code="${param.forum}.blockedtill"/></jsp:attribute>
</jsp:element>

