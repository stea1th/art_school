<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/nachricht.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div align="center">
    <h1>FORUM</h1>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <h3>
                        <c:out value="${title}"/>
                    </h3>
                    <div>
                        <c:forEach var="message" items="${list}">
                            <jsp:include page="fragments/messageCard.jsp">
                                <jsp:param name="id" value="${message.id}"/>
                                <jsp:param name="userName" value="${message.name}"/>
                                <jsp:param name="datum" value="${message.datum}"/>
                                <jsp:param name="nachricht" value="${message.text}"/>
                            </jsp:include>
                        </c:forEach>
                    </div>
                    <br><hr>
                    <div id="add-message" style="display: none;">
                        <form id="message-form">
                            <div class="form-group">
                                <label for="text-message">Написать сообщение:</label>
                                <div>
                                    <textarea class="form-control" id="text-message" name="text" rows="3"
                                  placeholder="Заметка"></textarea>
                                </div>
                            </div>
                        </form>
                        <button type="button" class="btn btn-success" onclick="saveMessage()">Сохранить</button>
                        <button type="button" class="btn btn-secondary" onclick="hideMessageArea()">Отмена</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
