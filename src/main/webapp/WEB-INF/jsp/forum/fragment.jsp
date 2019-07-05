<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>


<table id="forum" class="display responsive no-wrap" width="100%">
    <thead>
    <tr>
        <th class="w-5 text-center">
            <div id="choose-all-themes" class="choose-wrapper" style="width: 48px;">
                <span style="color: #1474C3 !important;"><i class="far fa-circle"></i></span>
            </div>
        </th>
        <th class="w-40  text-center">${title}</th>
        <th class="w-5  text-center"></th>
        <th class="w-10 text-center">${views}</th>
        <th class="w-10 text-center">${answers}</th>
        <th class="w-30 text-center">${lastanswer}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <c:set value="${item}" var="item"/>
        <c:set value="${previous + 1}" var="pageNumber"/>
        <%@ include file="thema-card.jsp" %>
    </c:forEach>
    </tbody>
</table>
<hr>
<div class="d-flex">
    <div class="ml-auto">
        <%@ include file="../fragments/pagination.jsp" %>
    </div>
</div>
<sec:authorize access="hasRole('ROLE_MODERATOR')" var="moder"/>
<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">check-theme-icon</jsp:attribute>
    <jsp:attribute name="is-admin">${moder}</jsp:attribute>
</jsp:element>
<hr>
