
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FullCalendar</title>
    <%--<link rel="stylesheet" href='webjars/jquery-ui/1.12.1/jquery-ui.css'>--%>
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.css' />
    <link rel='stylesheet' href='https://bootswatch.com/4/sketchy/bootstrap.css' />
    <%--<link rel='stylesheet' href='resources/css/jquery-ui.theme.css'/>--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.print.css' media="print"/>
    <link rel='stylesheet' href='resources/css/style.css' />
    <link rel='stylesheet' href='webjars/jquery.ui.timepicker/0.3.3/jquery.ui.timepicker.css' />
    <script type="text/javascript" src='webjars/jquery/3.3.1/jquery.min.js' ></script>
    <script type="text/javascript" src='webjars/jquery-ui/1.12.1/jquery-ui.min.js'></script>


</head>
<body>
<h1>Hi ALL!!!</h1>
<div id="events"></div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                <%--<form>--%>
                    <%--<input type="hidden" id="id" name="id">--%>
                    <div class="form-group" >
                        <input type="text" readonly="" class="form-control" id="datum">
                    </div>
                    <div class="form-group">
                        <%--<label for="kind" class="col-form-label" >Ребёнок</label>--%>
                        <input type="text" class="form-control" id="kind" placeholder="Ребёнок">
                    </div>
                    <div class="form-group">
                        <%--<label for="kind" class="col-form-label" >Ребёнок</label>--%>
                        <input type="text" class="form-control" id="zahlung" placeholder="Оплата">
                    </div>
                    <div class="form-group">
                        <%--<label for="timepicker" class="col-sm-2 col-form-label">Время</label>--%>
                        <input type="text" class="form-control"  id="timepicker" placeholder="Время">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="save()">Save changes</button>
                <%--<button type="submit" class="btn btn-primary" id="submit">Save changes</button>--%>
            </div>
        </div>
    </div>
</div>

    <div id='calendar'></div>

    <%--<div id="dialog" title="Создать урок">--%>
        <%--<form id="detailsForm">--%>
            <%--<input type="hidden" id="id" name="id">--%>
            <%--<div class="form-group" id="test"></div>--%>
            <%--<div class="form-group">--%>
                <%--&lt;%&ndash;<label for="kind" class="col-form-label" >Ребёнок</label>&ndash;%&gt;--%>
                <%--<input type="text" class="form-control" id="kind" placeholder="Ребёнок">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--&lt;%&ndash;<label for="kind" class="col-form-label" >Ребёнок</label>&ndash;%&gt;--%>
                <%--<input type="text" class="form-control" id="zahlung" placeholder="Оплата">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--&lt;%&ndash;<label for="timepicker" class="col-sm-2 col-form-label">Время</label>&ndash;%&gt;--%>
                <%--<input type="text" class="form-control"  id="timepicker" placeholder="Время">--%>
            <%--</div>--%>
        <%--</form>--%>
    <%--</div>--%>





    <script src="webjars/bootstrap/4.1.3/js/bootstrap.js"></script>
    <script type="text/javascript" src='webjars/moment/2.22.2/min/moment.min.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/fullcalendar.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/locale/ru.js' ></script>
    <script src="webjars/jquery.ui.timepicker/0.3.3/jquery.ui.timepicker.js"></script>
    <script type="text/javascript" src='<c:url value="/resources/js/main.js"/>' ></script>
    <script type="text/javascript" src='<c:url value="/resources/js/common.js"/>' ></script>

    <%--<script>--%>
        <%--var myEvents = ${json};--%>
    <%--</script>--%>
</body>
</html>
