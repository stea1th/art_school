<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<tr>
    <td>
        <div class="thema-title">
            <c:url value="/nachricht" var="themaUrl">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <a href="${themaUrl}"><c:out value="${item.titel}"/></a>
            <span>&nbsp;<c:out value="${item.creator}"/></span>
        </div>
    </td>
    <td class="text-center">
        <strong><c:out value="${item.views}"/></strong>
    </td>
    <td class="text-center">
        <strong><c:out value="${item.replies}"/></strong>
    </td>
    <td class="text-center">
        <strong><c:out value="${item.last}"/></strong>
    </td>
</tr>