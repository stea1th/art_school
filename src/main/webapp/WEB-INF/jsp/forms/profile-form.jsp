<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page pageEncoding="UTF-8" %>

<form action="#" enctype="multipart/form-data" id="profile-image-form">
    <div class="d-flex flex-row h-100">
        <div class="w-50" >
            <div id="preview" class="form-control image-holder d-flex"
                 style="width:300px;height:300px;text-align: center; padding-left: 70px;">
                <h3 style="display: inline-block;padding: 80px 130px;text-align: center;"><spring:message code="error.nophoto"/></h3>
            </div>
            <br>
            <div class="form-group d-flex w-75">
                <button class="btn btn-outline-success btn-sm flex-fill" type="button"
                        onclick="updateImage()"><i class="fas fa-search"></i>&nbsp;<spring:message code="button.find"/>
                </button>
                <button class="btn btn-outline-warning btn-sm flex-fill" type="button"
                        onclick="clearImageInput()"><i class="fas fa-backspace"></i>&nbsp;<spring:message code="button.clear"/>
                </button>
                <button class="btn btn-outline-danger btn-sm flex-fill" type="button"
                        onclick="removeImage()"><i class="fas fa-trash"></i>&nbsp;<spring:message code="button.delete"/>
                </button>
                <input type="file" name="image" id="image-input" accept="image/*" hidden>
            </div>

        </div>
        <div class="w-50">
            <div class="form-group row">
                <label for="name" class="col-4 col-form-label"><spring:message code="form.name"/><spring:message code="app.asteriks"/></label>
                <div class="col-8">
                    <input type="text" id="name" name="name" class="form-control"
                           required="required" readonly/>
                </div>
            </div>
            <div class="form-group row">
                <label for="adresse" class="col-4 col-form-label"><spring:message code="form.address"/><spring:message code="app.asteriks"/></label>
                <div class="col-8" id="adresse-div">
                    <input type="text" id="adresse" name="adresse" class="form-control"
                           required="required"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-4 col-form-label"><spring:message code="form.email"/><spring:message code="app.asteriks"/></label>
                <div class="col-8" id="email-div">
                    <input type="email" id="email" name="email" class="form-control"
                           required="required"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="new-passwort" class="col-4 col-form-label"><spring:message code="form.password.new"/></label>
                <div class="col-8">
                    <input type="text" id="new-passwort" name="newPasswort" class="form-control"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="repeat-passwort" class="col-4 col-form-label"><spring:message code="form.password.repeat"/></label>
                <div class="col-8" id="repeat">
                    <input type="text" id="repeat-passwort" name="repeatPasswort"
                           class="form-control"/>
                </div>
            </div>
        </div>
        <%--<div class="p-4">--%>
            <%--<div class="form-group row">--%>
                <%--<label for="new-passwort" class="col-4 col-form-label"><spring:message code="form.password.new"/></label>--%>
                <%--<div class="col-8">--%>
                    <%--<input type="text" id="new-passwort" name="newPasswort" class="form-control"/>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group row">--%>
                <%--<label for="repeat-passwort" class="col-4 col-form-label"><spring:message code="form.password.repeat"/></label>--%>
                <%--<div class="col-8" id="repeat">--%>
                    <%--<input type="text" id="repeat-passwort" name="repeatPasswort"--%>
                           <%--class="form-control"/>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</form>
