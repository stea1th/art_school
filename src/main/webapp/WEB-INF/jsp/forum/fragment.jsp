<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>


<table id="forum" class="display responsive no-wrap" width="100%">
    <thead>
    <tr>
        <th class="w-50  text-center">Заголовок</th>
        <%--<th class="w-15 text-center">Отправитель</th>--%>
        <th class="w-10 text-center">Просмотров</th>
        <th class="w-10 text-center">Ответов</th>
        <th class="w-30 text-center">Последнее</th>
        <%--<th>Pinned</th>--%>
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
<div>
    <jsp:include page="../fragments/pagination.jsp">
        <jsp:param name="link" value="${link}"/>
        <jsp:param name="hasPrevious" value="${hasPrevious}"/>
        <jsp:param name="hasNext" value="${hasNext}"/>
        <jsp:param name="items" value="${items}"/>
        <jsp:param name="sorting" value="${sorting}"/>
        <jsp:param name="direction" value="${direction}"/>
        <jsp:param name="sizing" value="${sizing}"/>
        <jsp:param name="previous" value="${previous}"/>
        <jsp:param name="next" value="${next}"/>
        <jsp:param name="last" value="${last}"/>
    </jsp:include>
</div>
