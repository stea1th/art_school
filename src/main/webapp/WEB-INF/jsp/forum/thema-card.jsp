<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<tr>
    <td>
        <div class="thema-icon" data-themaid="${item.id}" data-item-active="${item.aktiv}">
            <c:if test="${item.aktiv}">
                        <span style="color: green !important;">
                            <i class="far fa-thumbs-up"></i>
                        </span>
            </c:if>
            <c:if test="${!item.aktiv}">
                        <span style="color: red !important;">
                            <i class="fas fa-lock"></i>
                        </span>
            </c:if>
        </div>
    </td>
    <td>
        <div class="thema-title">
            <c:url value="/nachricht" var="themaUrl">
                <c:param name="id" value="${item.id}"/>
                <c:param name="themaPage" value="${pageNumber}"/>
                <c:param name="themaSize" value="${size}"/>
            </c:url>
            <a href="${themaUrl}" onclick="countClicks(${item.id})"><c:out value="${item.titel}"/></a>
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

        <div>
            <a href='<c:url value="/nachricht?id=${item.id}&themaPage=${pageNumber}&themaSize=${size}&page=${item.page}#${item.anker}"/>'
               onclick="countClicks(${item.id})"><c:out
                    value="${item.last}"/>
                <span><i class="fas fa-angle-double-right"></i></span>
            </a></div>
    </td>
</tr>