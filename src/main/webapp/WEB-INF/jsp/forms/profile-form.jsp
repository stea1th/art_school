<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page pageEncoding="UTF-8" %>

<form action="#" enctype="multipart/form-data" id="profile-image-form">
    <div class="d-flex justify-content-around">
        <div class="p-4">
            <div id="preview" class="form-control image-holder"
                 style="width:300px;height:300px;text-align: center;">
                <h3 style="display: inline-block;padding-top: 130px;"><spring:message code="profile.nophoto"/></h3>
            </div>
            <br>
            <div class="form-group d-flex">
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
        <div class="p-4">
            <div class="form-group row">
                <label for="name" class="col-4 col-form-label"><spring:message code="form.name"/></label>
                <div class="col-8">
                    <input type="text" id="name" name="name" class="form-control"
                           required="required" readonly/>
                </div>
            </div>
            <div class="form-group row">
                <label for="adresse" class="col-4 col-form-label"><spring:message code="form.address"/></label>
                <div class="col-8">
                    <input type="text" id="adresse" name="adresse" class="form-control"
                           required="required"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-4 col-form-label"><spring:message code="form.email"/></label>
                <div class="col-8" id="email-div">
                    <input type="email" id="email" name="email" class="form-control"
                           required="required"/>
                </div>
            </div>
        </div>
        <div class="p-4">
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
    </div>
</form>
