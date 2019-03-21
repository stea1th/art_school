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
            <ul class="navbar-nav mr-auto" id="left-side">
                <sec:authorize access="hasRole('ROLE_MODERATOR')">
                <li class="nav-item active">
                    <a class="nav-link" href="unterricht">Уроки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="kind">Ученики</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="zahlung">Оплата</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="statistik">Статистика</a>
                </li>
                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link" href="forum">Форум</a>
                </li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="admin">Админ</a>
                    </li>
                </sec:authorize>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false"><spring:message code="app.lang"/></a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('en')"><spring:message code="app.lang.en"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('ru')"><spring:message code="app.lang.ru"/></div>
                        <div class="dropdown-item" style="cursor: pointer" onclick="changeLanguage('de')"><spring:message code="app.lang.de"/></div>
                    </div>
                </li>
            </ul>
        </sec:authorize>
        <ul class="navbar-nav ml-auto">
            <sec:authorize access="isAnonymous()">
                <li>
                    <div class="navbar-header">
                        <a class="btn btn-outline-light login-btn" href="#myModal" data-toggle="modal">
                            <i class="fas fa-user"></i> Login</a>
                    </div>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <div class="nav-item dropdown">
                        <a id="userdetails" href="https://example.com" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false" class="dropdown-toggle navbar-icon-link">
                            <i class="fas fa-user-circle fa-2x"></i></a>
                        <div aria-labelledby="userdetails" class="dropdown-menu dropdown-menu-right">
                            <a href="#" class="dropdown-item">Profile</a>
                            <div class="dropdown-divider my-0"></div>
                            <a href="<c:url value="/perform_logout" />" class="dropdown-item">Logout</a>
                        </div>
                    </div>
                </li>
            </sec:authorize>
        </ul>

    </div>
</nav>