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
                <p class="list-title text-uppercase">Translate</p>
                <ul class="list-unstyled">
                    <li><a href="#" class="list-link">Czech</a></li>
                    <li><a href="#" class="list-link current">English</a></li>
                </ul>
            </li>

            <!-- multi-level dropdown menu -->
            <li class="list-item">
                <p class="list-title text-uppercase">Dashboard</p>
                <ul class="list-unstyled">
                    <li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-home"
                                                                                 aria-hidden="true"></i></span>Home</a>
                    </li>
                    <li><a href="#" class="list-link link-arrow link-current"><span class="list-icon"><i
                            class="fa fa-cog" aria-hidden="true"></i></span>Settings</a>
                        <ul class="list-unstyled list-hidden">
                            <li><a href="#" class="list-link">Timezone</a></li>
                            <li><a href="#" class="list-link">Permissions</a></li>
                            <li><a href="#" class="list-link link-arrow link-current">Maintenance</a>
                                <ul class="list-unstyled list-hidden">
                                    <li><a href="#" class="list-link">On</a></li>
                                    <li><a href="#" class="list-link link-current">Off</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <!-- notice info -->
                    <li><a href="#" class="list-link">Notice</a></li>
                </ul>
            </li>

            <!-- multi-level dropdown menu -->
            <li class="list-item">
                <p class="list-title text-uppercase">Coments</p>
                <ul class="list-unstyled">
                    <li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-plus"
                                                                                 aria-hidden="true"></i></span>New</a>
                    </li>
                    <li><a href="#" class="list-link link-arrow"><span class="list-icon"><i class="fa fa-comments-o"
                                                                                            aria-hidden="true"></i></span>Settings
                        comments</a>
                        <ul class="list-unstyled list-hidden">
                            <li><a href="#" class="list-link">Disable</a></li>
                            <li><a href="#" class="list-link">Enable</a></li>
                        </ul>
                    </li>
                </ul>
            </li>

            <!-- simple menu -->
            <li class="list-item">
                <p class="list-title text-uppercase">Blog</p>
                <ul class="list-unstyled">
                    <li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-plus"
                                                                                 aria-hidden="true"></i></span>Add</a>
                    </li>
                    <li><a href="#" class="list-link"><span class="list-icon"><i class="fa fa-table"
                                                                                 aria-hidden="true"></i></span>List</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<!-- website content -->
<%--<div class="content">--%>

<!-- navbar top fixed -->
<nav class="navbar navbar-expand-lg fixed-top navbar-lighten">

    <!-- navbar title -->
    <a class="navbar-brand navbar-link" href="#">Sidebar menu</a>

    <!-- navbar sidebar menu toggle -->
    <span class="navbar-text">
					<a href="#" id="sidebar-toggle" class="navbar-bars">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</a>
				</span>

    <!-- navbar dropdown menu-->
    <div class="collapse navbar-collapse">
        <div class="dropdown dropdown-logged dropdown-logged-lighten">
            <a href="#" data-toggle="dropdown" class="dropdown-logged-toggle dropdown-link">
                <span class="dropdown-user float-left">Accgit</span>
                <img src="img/avatar.png" alt="avatar" class="dropdown-avatar">
            </a>
            <div class="dropdown-menu dropdown-logged-menu dropdown-menu-right border-0 dropdown-menu-lighten">
                <div class="dropdown-menu-arrow"></div>
                <a class="dropdown-item dropdown-logged-item" href="#"><i class="fa fa-user-o"
                                                                          aria-hidden="true"></i>Your
                    profile</a>
                <a class="dropdown-item dropdown-logged-item" href="#"><i class="fa fa-comments-o"
                                                                          aria-hidden="true"></i>Your
                    comments</a>
                <a class="dropdown-item dropdown-logged-item" href="#"><i class="fa fa-key"
                                                                          aria-hidden="true"></i>Change password</a>
                <div class="dropdown-divider border-light"></div>
                <a class="dropdown-item dropdown-logged-item" href="#"><i class="fa fa-sign-out"
                                                                          aria-hidden="true"></i>Logout</a>
            </div>
        </div>
    </div>
</nav>

