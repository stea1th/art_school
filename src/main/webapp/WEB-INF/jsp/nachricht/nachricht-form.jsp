<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<div>
    <form method="post" id="message-form" action="#">
        <input type="hidden" class="form-control" id="id" name="id" value="${id}"/>
        <div id="thema-title-invisible" class="form-group" style="display: none;">
            <label for="thema-title-text">Тема сообщения:</label>
            <input class="thema-title-text form-control" type="text" id="thema-title-text" required>
        </div>
        <div class="form-group">
            <label for="text-message">Написать сообщение:</label>
            <c:if test="${parentText != null}">
                   <textarea type="text" class="message-quote" name="message-quote" rows="10" readonly>
                       <c:out value="${parentText}" />
                   </textarea>
            </c:if>
            <div contenteditable="true" class="text-message form-control"
                 id="text-message" aria-required="true">
                <c:if test="${updateText != null}">
                    <c:out value="${updateText}" />
                </c:if>
            </div>

        </div>
        <button type="button" class="btn btn-success btn-ok" id="message-submit">Сохранить</button>
        <button type="button" class="btn btn-secondary" onclick="hideMessageArea()">Отмена</button>
    </form>

</div>