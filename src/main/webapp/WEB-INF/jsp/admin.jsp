<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<%--<script type="text/javascript" src='<c:url value="/resources/js/kind.js"/>' defer></script>--%>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-md-10 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <table id="admin" class="display responsive no-wrap" width="100%">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Имя</th>
                            <th>E-Mail</th>
                            <th>Пароль</th>
                            <th>Роль</th>
                            <th>Активный</th>
                            <th>Регистрация</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Имя</th>
                            <th>E-Mail</th>
                            <th>Пароль</th>
                            <th>Роль</th>
                            <th>Активный</th>
                            <th>Регистрация</th>
                            <th></th>
                            <th></th>
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
