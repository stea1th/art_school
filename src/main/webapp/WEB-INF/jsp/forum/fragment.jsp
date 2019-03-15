<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>


<table id="forum" class="display responsive no-wrap" width="100%">
    <thead>
    <tr>
        <th class="w-50  text-center">Заголовок</th>
        <th class="w-10 text-center">Просмотров</th>
        <th class="w-10 text-center">Ответов</th>
        <th class="w-30 text-center">Последнее</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <c:set value="${item}" var="item"/>
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
<hr>
