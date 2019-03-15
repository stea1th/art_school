<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<tr>
    <td>
        <div class="thema-title">
            <span style="color: green !important;">
                <i class="far fa-check-square"></i>
                &nbsp;
            </span>
            <c:url value="/nachricht" var="themaUrl">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <a href="${themaUrl}" onclick="countClicks(${item.id})" ><c:out value="${item.titel}"/></a>
            <span>&nbsp;<c:out value="${item.creator}"/></span>
            <c:if test="${item.pinned}">
                <span style="color: red !important;">
                    &nbsp;
                    <i class="fas fa-thumbtack"></i>
                </span>
            </c:if>
        </div>
    </td>
    <td class="text-center">
        <strong><c:out value="${item.views}"/></strong>
    </td>
    <td class="text-center">
        <strong><c:out value="${item.replies}"/></strong>
    </td>
    <td class="text-center">

        <div><a href='<c:url value="/nachricht?id=${item.id}&page=${item.page}#${item.anker}"/>'><c:out
                value="${item.last}"/>
            <span><i class="fas fa-angle-double-right"></i></span>
        </a></div>
    </td>
</tr>