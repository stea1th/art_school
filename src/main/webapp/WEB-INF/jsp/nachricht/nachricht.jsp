<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
<jsp:include page="../fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-md-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <h3>
                        <c:out value="${title}"/>
                        <c:if test="${active == false}">
                            <span style="color:red;">&nbsp;(Закрыл <c:out value="${closedBy}"/>)</span>
                        </c:if>
                    </h3>
                    <input type="hidden" class="form-control" id="themaId" name="themaId" value="${themaId}"/>
                    <div class="d-flex">
                        <div class="mr-auto p-2">
                            <c:if test="${active != false}">
                                <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                    <button type="button" style="float:right" onclick="toggleThema(${themaId})">Закрыть
                                        тему
                                    </button>
                                </sec:authorize>
                                <button type="button" style="float:right" onclick="answerIt()">Создать сообщение
                                </button>
                                <button type="button" style="float:right" onclick="answerIt(null, true)">Создать тему
                                </button>
                            </c:if>
                            <c:if test="${active == false}">
                                <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                    <button type="button" style="float:right" onclick="toggleThema(${themaId})">Открыть
                                        тему
                                    </button>
                                </sec:authorize>
                            </c:if>
                        </div>
                        <div class="ml-auto p-2">
                            <jsp:include page="../fragments/table-size-selector.jsp">
                                <jsp:param name="themaId" value="${themaId}"/>
                                <jsp:param name="link" value="${link}"/>
                                <jsp:param name="size" value="${size}"/>
                            </jsp:include>
                        </div>
                    </div>
                    <div class="wrapper">
                        <%@ include file="fragment.jsp" %>
                    </div>
                    <hr>
                    <div id="add-message">
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
