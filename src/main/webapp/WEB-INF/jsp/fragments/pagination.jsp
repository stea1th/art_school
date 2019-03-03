<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div>
    <ul class="pagination">
        <li class="page-item p-1">
            <div class="page-link" style="cursor: pointer"><c:out value="${param.items}"/></div>
        </li>
        <li class="${param.hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}" >
            <c:url var="linkFirst" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="sort" value="${param.sorting}"/>
                <c:param name="direction" value="${param.direction}"/>
                <c:param name="step" value="true"/>
                <c:param name="size" value="${param.sizing}"/>
            </c:url>
            <a class="page-link"
               href="${linkFirst}">First</a></li>
        <li class="${param.hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkPrevious" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="pageNumber" value="${param.previous}"/>
                <c:param name="sort" value="${param.sorting}"/>
                <c:param name="direction" value="${param.direction}"/>
                <c:param name="step" value="true"/>
                <c:param name="size" value="${param.sizing}"/>
            </c:url>
            <a class="page-link"
               href="${linkPrevious}">Previous</a></li>

        <li class="page-item p-1">
            <div class="page-link">
                <jsp:element name="input">
                    <jsp:attribute name="type">text</jsp:attribute>
                    <jsp:attribute name="class">page-input</jsp:attribute>
                    <jsp:attribute name="style">width: 30px; text-align: center</jsp:attribute>
                    <jsp:attribute name="themaId">${param.themaId}</jsp:attribute>
                    <jsp:attribute name="sort">${param.sorting}</jsp:attribute>
                    <jsp:attribute name="direction">${param.direction}</jsp:attribute>
                    <jsp:attribute name="step">true</jsp:attribute>
                    <jsp:attribute name="size">${param.sizing}</jsp:attribute>
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
                <c:param name="pageNumber" value="${param.next}"/>
                <c:param name="sort" value="${param.sorting}"/>
                <c:param name="direction" value="${param.direction}"/>
                <c:param name="step" value="true"/>
                <c:param name="size" value="${param.sizing}"/>
            </c:url>
            <a class="page-link" href="${linkNext}">Next</a></li>
        <li class="${param.hasNext? 'page-item p-1' : 'page-item p-1 disabled'}">
            <c:url var="linkLast" value="${param.link}">
                <c:param name="id" value="${param.themaId}"/>
                <c:param name="pageNumber" value="${param.last}"/>
                <c:param name="sort" value="${param.sorting}"/>
                <c:param name="direction" value="${param.direction}"/>
                <c:param name="step" value="true"/>
                <c:param name="size" value="${param.sizing}"/>
            </c:url>
            <a class="page-link" href="${linkLast}">Last</a></li>
    </ul>
</div>