<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form id="user-detailsForm">
    <div>
        <input type="hidden" class="form-control" id="id" name="id">
    </div>
    <div class="form-group row">
        <label for="name" class="col-4 col-form-label"><spring:message code="form.name"/><spring:message code="app.asteriks"/></label>
        <div class="col-8" id="name-div">
            <input type="text" id="name" name="name" class="form-control" required="required"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="adresse" class="col-4 col-form-label"><spring:message code="form.address"/><spring:message code="app.asteriks"/></label>
        <div class="col-8" id="adresse-div">
            <input type="text" id="adresse" name="adresse" class="form-control" required="required"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="email" class="col-4 col-form-label"><spring:message code="form.email"/><spring:message code="app.asteriks"/></label>
        <div class="col-8" id="email-div">
            <input type="email" id="email" name="email" class="form-control" required="required"/>
        </div>
    </div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="form-group row">
            <label for="passwort" class="col-4 col-form-label"><spring:message code="app.password"/></label>
            <div class="col-8">
                <input type="text" id="passwort" name="adminPasswort" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="roles" class="col-4 col-form-label"><spring:message code="app.role"/></label>
            <div class="col-8">
                <select id="roles" name="roles" class="custom-select chosen-select">
                </select>
            </div>
        </div>
    </sec:authorize>
    <div class="form-group row" id="aktiv-checkbox">
        <label class="col-4 col-form-label"><spring:message code="app.active"/>?</label>
        <div class="col-8">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input form-control col-form-input" id="aktiv" name="aktiv"
                       checked="checked">
                <label class="custom-control-label col-form-label" for="aktiv"><spring:message code="app.yes"/></label>
            </div>
        </div>
    </div>
</form>