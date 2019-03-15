<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div>
    <ul class="pagination">
        <li class="page-item p-1 disabled">
            <div class="page-link" style="cursor: pointer"><c:out value="${param.items}"/></div>
        </li>
        <li class="${param.hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}" >
            <c:url var="linkFirst" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="size" value="${param.size}"/>
            </c:url>
            <a class="page-link"
               href="${linkFirst}"><i class="fas fa-angle-double-left fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>
        <li class="${param.hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkPrevious" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="page" value="${param.previous}"/>
                <c:param name="size" value="${param.size}"/>
            </c:url>
            <a class="page-link"
               href="${linkPrevious}"><i class="fas fa-angle-left fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>

        <li class="page-item p-1 disabled">
            <div class="page-link">
                <jsp:element name="input">
                    <jsp:attribute name="type">text</jsp:attribute>
                    <jsp:attribute name="class">page-input</jsp:attribute>
                    <jsp:attribute name="style">width: 30px; text-align: center</jsp:attribute>
                    <jsp:attribute name="themaId">${param.themaId}</jsp:attribute>
                    <jsp:attribute name="size">${param.size}</jsp:attribute>
                    <jsp:attribute name="last">${param.last}</jsp:attribute>
                    <jsp:attribute name="link">${param.link}</jsp:attribute>
                    <jsp:attribute name="this">${param.next}</jsp:attribute>
                    <jsp:attribute name="value"><c:out value="${param.next}"/></jsp:attribute>
                </jsp:element>
                <c:set var="lastPage" value="${param.last  + 1}"/>
                <span>/<c:out value="${lastPage}"/></span>
            </div>
        </li>

        <li class="${param.hasNext? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkNext" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="page" value="${param.next}"/>
                <c:param name="size" value="${param.size}"/>
            </c:url>
            <a class="page-link" href="${linkNext}"><i class="fas fa-angle-right fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>
        <li class="${param.hasNext? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkLast" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="page" value="${param.last}"/>
                <c:param name="size" value="${param.size}"/>
            </c:url>
            <a class="page-link" href="${linkLast}" >
                <i class="fas fa-angle-double-right fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i>
            </a></li>
    </ul>
</div>