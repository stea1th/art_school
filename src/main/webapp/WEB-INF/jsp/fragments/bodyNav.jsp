<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark justify-content-end">
    <a class="navbar-brand" href="forum">Art School</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars1" aria-controls="navbars1"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbars1">
        <sec:authorize access="isAuthenticated()">
            <ul class="navbar-nav mr-auto flex-row" id="left-side">
                <sec:authorize access="hasRole('ROLE_MODERATOR')">
                    <li class="nav-item active">
                        <a class="nav-link" href="unterricht"><spring:message code="app.lesson"/><span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="kind"><spring:message code="app.users"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="zahlung"><spring:message code="app.payment"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="statistik"><spring:message code="app.statistic"/></a>
                    </li>
                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link" href="forum"><spring:message code="forum.name"/></a>
                </li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="admin"><spring:message code="app.admin"/></a>
                    </li>
                </sec:authorize>
            </ul>
        </sec:authorize>
        <ul class="navbar-nav ml-auto">
            <sec:authorize access="isAnonymous()">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle testIt" href="#" id="dropdown05" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false"><spring:message code="app.lang"/></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('en')">
                            <spring:message code="app.lang.en"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('ru')">
                            <spring:message code="app.lang.ru"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('de')">
                            <spring:message code="app.lang.de"/></div>
                    </div>
                </li>
                <li class="nav-item">
                    <div style="padding-top: 10px;padding-bottom: 10px;">
                        <a class="btn btn-outline-light login-btn" href="#login-modal" data-toggle="modal">
                            <i class="fas fa-user"></i> <spring:message code="app.login"/></a>
                    </div>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle testIt" href="#" id="dropdown04" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false" style="padding-top: 27px;"><spring:message code="app.lang"/></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('en')">
                            <spring:message code="app.lang.en"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('ru')">
                            <spring:message code="app.lang.ru"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('de')">
                            <spring:message code="app.lang.de"/></div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a id="userdetails" href="#" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" class="nav-link dropdown-toggle navbar-icon-link">
                    </a>
                    <div aria-labelledby="userdetails" class="dropdown-menu dropdown-menu-right">
                        <a href="profile" class="dropdown-item">Profile</a>
                        <div class="dropdown-divider my-0"></div>
                        <a href="<c:url value="/perform_logout" />" class="dropdown-item">Logout</a>
                    </div>
                </li>
            </sec:authorize>
        </ul>

    </div>
</nav>