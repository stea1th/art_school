<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!-- sidebar -->
<div class="sidebar sidebar-lighten">

    <!-- sidebar menu -->
    <div class="sidebar-menu">

        <!-- menu -->
        <ul class="list list-unstyled list-scrollbar">

            <!-- simple menu -->
            <li class="list-item">
                <p class="list-title text-uppercase">Profile</p>
                <ul class="list-unstyled">
                    <li><a href="#" class="list-link link-arrow"><span class="list-icon"><i class="fas fa-user"></i></span>Info</a>
                        <ul class="list-unstyled list-hidden">
                            <li>
                                <div>Name: Igor</div>
                                <div>Status: Moderator</div>
                                <div>Registered: 12.12.2017</div>
                            </li>
                        </ul>
                    </li>

                    <li><a href="profile" class="list-link"><span class="list-icon"><i
                            class="fas fa-user-edit"></i></span>Edit</a></li>
                    <li><a href="<c:url value="/perform_logout" />" class="list-link"><span class="list-icon"><i
                            class="fas fa-sign-out-alt"></i></span>Logout</a></li>
                </ul>
            </li>

            <!-- multi-level dropdown menu -->
            <li class="list-item">
                <p class="list-title text-uppercase">Navigation</p>
                <ul class="list-unstyled">
                    <sec:authorize access="hasRole('ROLE_MODERATOR')">
                        <li>
                            <a class="list-link" href="unterricht"><span class="list-icon"><i
                                    class="fas fa-graduation-cap" aria-hidden="true"></i></span><spring:message
                                    code="app.lesson"/><span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li><a href="#" class="list-link link-arrow"><span class="list-icon"><i
                                class="fas fa-list-ul"></i></span>Tables</a>
                            <ul class="list-unstyled list-hidden">
                                <li>
                                    <a class="list-link" href="kind"><span class="list-icon"><i
                                            class="fas fa-users"></i></span><spring:message code="app.users"/></a>
                                </li>
                                <li>
                                    <a class="list-link" href="zahlung"><span class="list-icon"><i
                                            class="fas fa-money-bill-alt"></i></span><spring:message
                                            code="app.payment"/></a>
                                </li>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li>
                                        <a class="list-link" href="admin"><span class="list-icon"><i
                                                class="fas fa-user-secret"></i></span><spring:message code="app.admin"/></a>
                                    </li>
                                </sec:authorize>
                            </ul>
                        </li>
                        <li>
                            <a class="list-link" href="statistik"><span class="list-icon"><i
                                    class="fas fa-chart-pie"></i></span><spring:message code="app.statistic"/></a>
                        </li>
                    </sec:authorize>
                    <li>
                        <a class="list-link" href="forum"><span class="list-icon"><i
                                class="fab fa-facebook-f"></i></span><spring:message code="forum.name"/></a>
                    </li>

                    <%--<li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-home"--%>
                    <%--aria-hidden="true"></i></span>Home</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="#" class="list-link link-arrow link-current"><span class="list-icon"><i--%>
                    <%--class="fa fa-cog" aria-hidden="true"></i></span>Settings</a>--%>
                    <%--<ul class="list-unstyled list-hidden">--%>
                    <%--<li><a href="#" class="list-link">Timezone</a></li>--%>
                    <%--<li><a href="#" class="list-link">Permissions</a></li>--%>
                    <%--<li><a href="#" class="list-link link-arrow link-current">Maintenance</a>--%>
                    <%--<ul class="list-unstyled list-hidden">--%>
                    <%--<li><a href="#" class="list-link">On</a></li>--%>
                    <%--<li><a href="#" class="list-link link-current">Off</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>

                    <!-- notice info -->
                </ul>
            </li>

            <%--<!-- multi-level dropdown menu -->--%>
            <%--<li class="list-item">--%>
            <%--<p class="list-title text-uppercase">Coments</p>--%>
            <%--<ul class="list-unstyled">--%>
            <%--<li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-plus"--%>
            <%--aria-hidden="true"></i></span>New</a>--%>
            <%--</li>--%>
            <%--<li><a href="#" class="list-link link-arrow"><span class="list-icon"><i class="fa fa-comments-o"--%>
            <%--aria-hidden="true"></i></span>Settings--%>
            <%--comments</a>--%>
            <%--<ul class="list-unstyled list-hidden">--%>
            <%--<li><a href="#" class="list-link link-current">Disable</a></li>--%>
            <%--<li><a href="#" class="list-link">Enable</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</li>--%>

            <%--<!-- simple menu -->--%>
            <%--<li class="list-item">--%>
            <%--<p class="list-title text-uppercase">Blog</p>--%>
            <%--<ul class="list-unstyled">--%>
            <%--<li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-plus"--%>
            <%--aria-hidden="true"></i></span>Add</a>--%>
            <%--</li>--%>
            <%--<li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-table"></i></span>List</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</li>--%>
        </ul>
    </div>
</div>

<!-- website content -->
<%--<div class="content">--%>

<!-- navbar top fixed -->
<nav class="navbar navbar-expand-lg fixed-top navbar-lighten">

    <!-- navbar title -->
    <a class="navbar-brand navbar-link" href="forum">Art School</a>

    <!-- navbar sidebar menu toggle -->
    <span class="navbar-text">
					<a href="#" id="sidebar-toggle" class="navbar-bars">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</a>
				</span>

    <!-- navbar dropdown menu-->
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
                   aria-haspopup="true" aria-expanded="false" style="padding-top: 27px;"><spring:message
                        code="app.lang"/></a>
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

</nav>
<jsp:include page="../i18n/i18n-commons.jsp">
    <jsp:param name="page" value="zahlung"/>
</jsp:include>

