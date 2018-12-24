<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark justify-content-end">
    <a class="navbar-brand" href="login">Art School</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars1" aria-controls="navbars1"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbars1">
        <sec:authorize access="isAuthenticated()">
            <ul class="navbar-nav mr-auto" id="left-side">
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
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Dropdown</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
            </ul>
        </sec:authorize>
        <ul class="navbar-nav ml-auto">
            <li>
                <div class="navbar-header">
                    <a class="navbar-brand" href="#myModal" data-toggle="modal"><i class="fas fa-user"></i> Login</a>
                </div>
            </li>
        </ul>

    </div>
</nav>