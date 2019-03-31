<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form action="login" method="post">
    <div class="form-group">
        <spring:message code="app.username" var="userName" />
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-user fa-2x" content=""></i>&nbsp;</span>
            <input type="text" class="form-control" name="username" placeholder="${userName}" required="required">
        </div>
    </div>
    <div class="form-group">
        <spring:message code="app.password" var="password" />
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-lock fa-2x"></i>&nbsp;</span>
            <input type="text" class="form-control" name="password" placeholder="${password}" required="required">
        </div>
    </div>
    <br/>
    <div class="form-group">

        <div class="input-group">
            <input type="checkbox" id="chkbx1" name="remember-me"/>
            <label for="chkbx1">&nbsp;<spring:message code="app.remember" /></label>
        </div>

    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block btn-lg"><spring:message code="app.signin"/></button>
    </div>
    <p class="hint-text"><a href="#"><spring:message code="app.forgot"/></a></p>
</form>