<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<div>
    <ul class="pagination">
        <li class="page-item p-1 disabled">
            <div class="page-link" style="cursor: pointer"><c:out value="${items}"/></div>
        </li>
        <li class="${hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}" >
            <c:url var="linkFirst" value="${link}">
                <c:param name="id" value="${themaId}"/>
                <c:param name="size" value="${size}"/>
            </c:url>
            <a class="page-link"
               href="${linkFirst}"><i class="fas fa-angle-double-left fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>
        <li class="${hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkPrevious" value="${link}">
                <c:param name="id" value="${themaId}"/>
                <c:param name="page" value="${previous}"/>
                <c:param name="size" value="${size}"/>
            </c:url>
            <a class="page-link"
               href="${linkPrevious}"><i class="fas fa-angle-left fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>

        <li class="page-item p-1 disabled page-input-div">
            <div class="page-link">
                <jsp:element name="input">
                    <jsp:attribute name="type">text</jsp:attribute>
                    <jsp:attribute name="class">page-input</jsp:attribute>
                    <jsp:attribute name="style">width: 30px; text-align: center</jsp:attribute>
                    <jsp:attribute name="themaId">${themaId}</jsp:attribute>
                    <jsp:attribute name="size">${size}</jsp:attribute>
                    <jsp:attribute name="last">${last}</jsp:attribute>
                    <jsp:attribute name="link">${link}</jsp:attribute>
                    <jsp:attribute name="this">${next}</jsp:attribute>
                    <jsp:attribute name="value"><c:out value="${next}"/></jsp:attribute>
                </jsp:element>
                <c:set var="lastPage" value="${last  + 1}"/>
                <span>/<c:out value="${lastPage}"/></span>
            </div>
        </li>

        <li class="${hasNext? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkNext" value="${link}">
                <c:param name="id" value="${themaId}"/>
                <c:param name="page" value="${next}"/>
                <c:param name="size" value="${size}"/>
            </c:url>
            <a class="page-link" href="${linkNext}"><i class="fas fa-angle-right fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i></a></li>
        <li class="${hasNext? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkLast" value="${link}">
                <c:param name="id" value="${themaId}"/>
                <c:param name="page" value="${last}"/>
                <c:param name="size" value="${size}"/>
            </c:url>
            <a class="page-link" href="${linkLast}" >
                <i class="fas fa-angle-double-right fa-2x" style="vertical-align:middle;padding-bottom: 4px;"></i>
            </a></li>
    </ul>
</div>