<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Art School</title>

    <%--Favicon--%>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/css/pics/style1b_pic1_m.png" />

    <%--Animatejs--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">

    <%--jQuery--%>
    <script type="text/javascript" src='webjars/jquery/3.3.1/jquery.min.js' ></script>
    <script type="text/javascript" src='webjars/jquery-ui/1.12.1/jquery-ui.min.js'></script>

    <%--Popperjs--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <%--Bootstrap4--%>
    <%--<link rel='stylesheet' href='https://bootswatch.com/4/sketchy/bootstrap.css' />--%>
    <%--<link rel='stylesheet' href='https://bootswatch.com/4/materia/bootstrap.css' />--%>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
    <link rel='stylesheet' href='https://bootswatch.com/4/materia/bootstrap.css' />
    <script src="webjars/bootstrap/4.1.3/js/bootstrap.js"></script>


    <%--Vue for Develop--%>
    <%--<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>--%>

    <%--Vue for Production--%>
    <%--<script src="https://cdn.jsdelivr.net/npm/vue"></script>--%>

    <%--FontAwesome--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.css" />

    <%--Gijgo--%>
    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>


    <%--Datatables--%>
    <link rel='stylesheet' href='webjars/datatables/1.10.19/css/jquery.dataTables.min.css' />
    <link rel='stylesheet' href='https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css' />
    <link rel='stylesheet' href='webjars/datatables-buttons/1.5.2/css/buttons.bootstrap4.min.css' />
    <link rel='stylesheet' href='https://cdn.datatables.net/colreorder/1.5.0/css/colReorder.bootstrap4.min.css' />
    <script src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="webjars/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    <script src="webjars/datatables-buttons/1.5.2/js/dataTables.buttons.min.js"></script>
    <script src="webjars/datatables-buttons/1.5.2/js/buttons.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/colreorder/1.5.0/js/dataTables.colReorder.min.js"></script>

    <%--Chartjs--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>

    <%--Noty--%>
    <link rel='stylesheet' href='webjars/noty/3.1.4/lib/noty.css' />
    <script src="webjars/noty/3.1.4/lib/noty.min.js"></script>

    <%--Momentjs--%>
    <script type="text/javascript" src='webjars/moment/2.22.2/min/moment.min.js' ></script>

    <%--Fullcalendar--%>
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.css' />
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.print.css' media="print"/>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/fullcalendar.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/locale-all.js' ></script>

    <%--Chosen Select--%>
    <link rel='stylesheet' href='resources/css/chosen.css' />
    <script type="text/javascript" src='<c:url value="/resources/js/chosen/chosen.jquery.js"/>' defer></script>

    <%--SideBar--%>
    <link rel='stylesheet' href='resources/css/sidebar.css' />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.perfect-scrollbar/1.4.0/css/perfect-scrollbar.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.perfect-scrollbar/1.4.0/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src='<c:url value="/resources/js/sidebar/nanobar.min.js"/>' defer></script>
    <script type="text/javascript" src='<c:url value="/resources/js/sidebar/sidebar.menu.js"/>' defer></script>

    <%--Transition--%>
    <script type="text/javascript" src='<c:url value="/resources/js/transition/transition.min.js"/>' defer></script>

    <%--My Resources--%>
    <link rel='stylesheet' href='resources/css/style.css' />
    <script type="text/javascript" src='<c:url value="/resources/js/common.js"/>' defer></script>
    <script type="text/javascript" src='<c:url value="/resources/js/sidebar.js"/>' defer></script>

</head>

