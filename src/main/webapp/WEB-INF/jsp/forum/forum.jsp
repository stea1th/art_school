<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
<jsp:include page="../fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <div class="d-flex">
                        <div class="mr-auto p-2">
                            <button type="button" style="float:right" onclick="answerIt(null, true)">Создать тему
                            </button>
                        </div>
                        <div class="ml-auto p-2">
                            <jsp:include page="../fragments/table-size-selector.jsp">
                                <jsp:param name="link" value="${link}"/>
                                <jsp:param name="size" value="${size}"/>
                            </jsp:include>
                        </div>
                    </div>
                    <div id="forum-themes">
                        <h1>
                            <span>Art School Форум</span>
                        </h1>
                        <div class="wrapper">
                            <%@ include file="fragment.jsp" %>
                        </div>
                        <div id="add-message">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
