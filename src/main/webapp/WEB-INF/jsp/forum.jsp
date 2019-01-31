<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/forum.js"/>' defer></script>
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
                    <table id="forum" class="display responsive no-wrap" width="100%">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th class="w-50">Заголовок</th>
                            <th class="w-15">Отправитель</th>
                            <th class="w-10">Просмотров</th>
                            <th class="w-10">Ответов</th>
                            <th class="w-15">Последнее</th>
                            <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                                <%--<th></th>--%>
                                <%--<th></th>--%>
                            <%--</sec:authorize>--%>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Id</th>
                            <th class="w-50">Заголовок</th>
                            <th class="w-15">Отправитель</th>
                            <th class="w-10">Просмотров</th>
                            <th class="w-10">Ответов</th>
                            <th class="w-15">Последнее</th>
                            <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                                <%--<th></th>--%>
                                <%--<th></th>--%>
                            <%--</sec:authorize>--%>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
