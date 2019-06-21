<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body class="body body-lighten">
<script type="text/javascript" src='<c:url value="/resources/js/admin.js"/>' defer></script>
<%--<jsp:include page="fragments/bodyNav.jsp"/>--%>
<%--<jsp:include page="fragments/sidebarNav.jsp"/>--%>

<br/>

<div class="d-flex sidebar-toggle" id="wrapper">
    <jsp:include page="fragments/sidebarNav.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
                <div class="card border-light mb-3" id="table-card3">
                    <div class="card-body">
                        <table id="admins" class="display responsive no-wrap" width="100%">
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
</div>

<jsp:include page="fragments/modal.jsp">
    <jsp:param name="url" value="../forms/user-form.jsp"/>
    <jsp:param name="modalId" value="createOrUpdateUser"/>
    <jsp:param name="buttons" value="../buttons/save-and-close.jsp"/>
    <jsp:param name="saveId" value="saveUser"/>
</jsp:include>
</body>
<jsp:include page="i18n/i18n.jsp">
    <jsp:param name="page" value="user"/>
</jsp:include>
</html>
