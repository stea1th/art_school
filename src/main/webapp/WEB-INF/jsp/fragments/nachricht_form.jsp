<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<c:if test="${param.id != param.thema_id}">
    <div id="add-message_${param.id}" style="display: none;">
</c:if>
<c:if test="${param.id == param.thema_id}">
    <div id="add-message" style="display: none;">
</c:if>
    <form method="post" class="message-form">
        <input type="hidden" id="id" name="id"/>
        <input type="hidden" id="thema_id" name="thema_id" value="${param.thema_id}"/>
        <div class="form-group">
            <label for="text-message">Написать сообщение:</label>
            <div>
            <textarea class="form-control" id="text-message" name="text" rows="3"
                      placeholder="Заметка"></textarea>
            </div>
        </div>
    </form>
    <button type="button" class="btn btn-success" id="message-submit" onclick="saveMessage()">Сохранить</button>
    <button type="button" class="btn btn-secondary" onclick="hideMessageArea()">Отмена</button>
</div>