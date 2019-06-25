<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>

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
        <label for="adresse" class="col-4 col-form-label">Адрес</label>
        <div class="col-8">
            <input type="text" id="adresse" name="adresse" class="form-control" required="required"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="email" class="col-4 col-form-label">E-Mail</label>
        <div class="col-8">
            <input type="email" id="email" name="email" class="form-control" required="required"/>
        </div>
    </div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="form-group row">
            <label for="passwort" class="col-4 col-form-label">Пароль</label>
            <div class="col-8">
                <input type="text" id="passwort" name="adminPasswort" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="roles" class="col-4 col-form-label">Роли</label>
            <div class="col-8">
                <select id="roles" name="roles" class="custom-select chosen-select" required="required">
                </select>
            </div>
        </div>
    </sec:authorize>
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