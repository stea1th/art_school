<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/admin.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="container">
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

<div class="modal fade" id="createOrUpdateUser" tabindex="-1" role="dialog" aria-labelledby="createOrUpdateUser"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Добавить пользователя</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="user-detailsForm">
                    <div>
                        <input type="hidden" class="form-control" id="id" name="id">
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-4 col-form-label">Имя</label>
                        <div class="col-8">
                            <input type="text" id="name" name="name" class="form-control" required="required"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="email" class="col-4 col-form-label">E-Mail</label>
                        <div class="col-8">
                            <input type="email" id="email" name="adresse" class="form-control" required="required"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="passwort" class="col-4 col-form-label">Пароль</label>
                        <div class="col-8">
                            <input type="email" id="passwort" name="adresse" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="roles" class="col-4 col-form-label">Роли</label>
                        <div class="col-8">
                            <select id="roles" name="roles" class="custom-select" required="required">
                            </select>
                        </div>
                    </div>
                    <div class="form-group row" id="aktiv-checkbox">
                        <label class="col-4">Активный?</label>
                        <div class="col-8">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="aktiv" name="aktiv"
                                       checked="checked" required>
                                <label class="custom-control-label" for="aktiv">Да</label>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveUser">Сохранить</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
