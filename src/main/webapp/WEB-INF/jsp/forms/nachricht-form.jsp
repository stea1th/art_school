<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<div>
    <form method="post" id="message-form" action="#">
        <input type="hidden" class="form-control" id="id" name="id" value="${id}"/>
        <div id="thema-title-invisible" class="form-group" style="display: none;">
            <label for="thema-title-text" class="label"><spring:message code="forum.theme.title" /><spring:message code="app.asteriks"/>:</label>
            <input class="thema-title-text form-control" type="text" id="thema-title-text" maxlength="40" required>
        </div>
        <div id="thema-text-invisible" class="form-group">
            <label for="text-message" class="label"><spring:message code="forum.theme.message"/><spring:message code="app.asteriks"/>:</label>
            <c:if test="${parentText != null}">
                   <textarea type="text" class="message-quote" name="message-quote" rows="5" readonly>
                       <c:out value="${parentText}" />
                   </textarea>
            </c:if>
            <div contenteditable="true" class="text-message form-control"
                 id="text-message" aria-required="true">
                <c:if test="${updateText != null}">
                    <c:forEach var="e" items="${updateText}">
                        <div><c:out value="${e}"/></div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <jsp:include page="../buttons/save-and-close.jsp">
            <jsp:param name="notModal" value="true"/>
            <jsp:param name="primaryClass" value="btn btn-success btn-ok"/>
            <jsp:param name="saveId" value="message-submit"/>
            <jsp:param name="function" value="hideMessageArea()"/>
        </jsp:include>
    </form>

</div>