<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>

<div>
    <form method="post" id="message-form" action="#">
        <input type="hidden" class="form-control" id="id" name="id" value="${id}"/>
        <input type="hidden" class="form-control" id="themaId" name="themaId" value="${themaId}"/>

        <div class="form-group">
            <label for="text-message">Написать сообщение:</label>
            <div>
            <textarea class="form-control text-message" id="text-message" name="text" rows="3"
                      placeholder="Заметка"></textarea>
            </div>
        </div>
    </form>
    <button type="button" class="btn btn-success btn-ok" id="message-submit">Сохранить</button>
    <button type="button" class="btn btn-secondary" onclick="hideMessageArea()">Отмена</button>
</div>