<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<ul class="pagination">
    <li class="page-item p-1 disabled">
        <div class="page-link" ><c:out value="${param.items}"/></div>
    </li>
    <li class="${param.hasPrevious? 'page-item p-1' : 'page-item p-1 disabled'}">
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

    <%--<li class="page-item p-1">--%>
        <%--<div class="page-link">--%>
            <%--<input class="page-input" th:value="${__this__ + 1}"--%>
                   <%--style="width: 30px; text-align: center"--%>
                   <%--th:attr="sort=${sorting}, direction=${direction}, step=true, size=${sizing}, last=${last}, link=${link}, this=${__this__ + 1}">--%>
            <%--<span>/</span> <span th:text="${__last__ +1}"></span>--%>
        <%--</div>--%>
    <%--</li>--%>

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