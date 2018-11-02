
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%--<nav class="navbar navbar-dark bg-dark">--%>
    <%--<a class="navbar-brand" href="unterricht">Art School</a>--%>
    <%--<button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbars1" aria-controls="navbars1" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>
    <%--<div class="navbar-collapse collapse" id="navbars1" style="">--%>
        <%--<ul class="navbar-nav mr-auto">--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="unterricht">Уроки<span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="kind">Дети</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link " href="zahlung">Оплата</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="dropdown01">--%>
                    <%--<a class="dropdown-item" href="#">Action</a>--%>
                    <%--<a class="dropdown-item" href="#">Another action</a>--%>
                    <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                <%--</div>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <%--<form class="form-inline my-2 my-md-0">--%>
            <%--<input class="form-control" type="text" placeholder="Искать" aria-label="Искать">--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</nav>--%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="unterricht">Art School</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars1" aria-controls="navbars1" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbars1">
        <ul class="navbar-nav mr-auto">
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
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown04">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-md-0">
            <input class="form-control" type="text" placeholder="Search">
        </form>
    </div>
</nav>