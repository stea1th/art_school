<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form action="login" method="post">
    <div class="form-group row">
        <spring:message code="app.email" var="userName"/>
        <label for="username" class="col-2 col-form-label"><i class="fas fa-user fa-3x" content=""></i></label>
        <div class="col-10" style="padding-top:10px;">
            <input type="text" id="username" class="form-control" name="username" placeholder="${userName}"
                   required="required">
        </div>
    </div>

    <div class="form-group row">
        <spring:message code="app.password" var="password"/>
        <label for="password" class="col-2 col-form-label"><i class="fas fa-lock fa-3x"></i></label>
        <div class="col-10" style="padding-top:10px;">
            <input type="text" id="password" class="form-control" name="password" placeholder="${password}"
                   required="required">
        </div>
    </div>
    <div class="form-group" style="padding-left:90px;">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="chkbx1" name="remember-me"
                   value="true" required>
            <label class="custom-control-label" for="chkbx1">&nbsp;<spring:message code="app.remember"/></label>
        </div>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block btn-lg"><spring:message code="app.signin"/></button>
    </div>
    <p class="hint-text"><a href="#"><spring:message code="app.forgot"/></a></p>
</form>