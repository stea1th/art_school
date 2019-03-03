<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div>
    <jsp:element name="select">
        <jsp:attribute name="id">page-size</jsp:attribute>
        <jsp:attribute name="themaId">${param.themaId}</jsp:attribute>
        <jsp:attribute name="sorting">${param.sorting}</jsp:attribute>
        <jsp:attribute name="direction">${param.direction}</jsp:attribute>
        <jsp:attribute name="link">${param.link}</jsp:attribute>
        <jsp:body>
            <option value=10 ${param.sizing == 2? 'selected' : ''}>10</option>
            <option value=25 ${param.sizing == 4? 'selected' : ''}>25</option>
            <option value=50 ${param.sizing == 50? 'selected' : ''}>50</option>
            <option value=100 ${param.sizing == 100? 'selected' : ''}>100</option>
        </jsp:body>
    </jsp:element>
</div>
