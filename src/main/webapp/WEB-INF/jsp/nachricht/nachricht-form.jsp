<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<div>
    <form method="post" id="message-form" action="#">
        <input type="hidden" class="form-control" id="id" name="id" value="${id}"/>
        <input type="hidden" class="form-control" id="themaId" name="themaId" value="${themaId}"/>

        <div class="form-group">
            <label for="text-message">Написать сообщение:</label>
            <div contenteditable="true" class="text-message" style="min-height:150px; width:100%; border:inset; outline: none;"
                 id="text-message">
               <%--<c:if test="${parentText != null}">--%>
                   <input type="text" class="message-quote" name="message-quote" value="Я сошла с ума!!!!!" style="border:none; outline: none;" readonly/>
               <%--</c:if>--%>
            </div>

        </div>
        <button type="button" class="btn btn-success btn-ok" id="message-submit">Сохранить</button>
        <button type="button" class="btn btn-secondary" onclick="hideMessageArea()">Отмена</button>
    </form>

</div>