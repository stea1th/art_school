<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div style="width:50px;">
    <jsp:element name="select">
        <jsp:attribute name="class">page-size form-control</jsp:attribute>
        <jsp:attribute name="themaId">${param.themaId}</jsp:attribute>
        <jsp:attribute name="link">${param.link}</jsp:attribute>
        <jsp:attribute name="style">width:100%;padding-left:10px;</jsp:attribute>
        <jsp:body>
            <option value=10 ${param.size == 10? 'selected' : ''}>10</option>
            <option value=15 ${param.size == 15? 'selected' : ''}>15</option>
            <option value=25 ${param.size == 25? 'selected' : ''}>25</option>
            <option value=50 ${param.size == 50? 'selected' : ''}>50</option>
        </jsp:body>
    </jsp:element>
</div>
