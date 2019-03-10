<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div>
    <jsp:element name="select">
        <jsp:attribute name="class">page-size</jsp:attribute>
        <jsp:attribute name="themaId">${param.themaId}</jsp:attribute>
        <jsp:attribute name="sort">${param.sort}</jsp:attribute>
        <jsp:attribute name="link">${param.link}</jsp:attribute>
        <jsp:body>
            <option value=2 ${param.size == 2? 'selected' : ''}>2</option>
            <option value=4 ${param.size == 4? 'selected' : ''}>4</option>
            <option value=50 ${param.size == 50? 'selected' : ''}>50</option>
            <option value=100 ${param.size == 100? 'selected' : ''}>100</option>
        </jsp:body>
    </jsp:element>
</div>
