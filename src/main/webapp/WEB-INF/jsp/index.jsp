<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FullCalendar</title>
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.css' />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel='stylesheet' href='https://bootswatch.com/4/sketchy/bootstrap.css' />
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.print.css' media="print"/>

</head>
<body>

    <div id='calendar'></div>


    <script type="text/javascript" src='webjars/jquery/3.3.1/jquery.min.js' ></script>
    <script type="text/javascript" src='webjars/moment/2.22.2/min/moment.min.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/fullcalendar.js' ></script>
    <%--<script type="text/javascript" src='<c:url value="/resources/js/main.js"/>' ></script>--%>

    <script>
        $('#calendar').fullCalendar({
            header: { center: 'month,agendaWeek,list' }, // buttons for switching between views
            views: {
                month: {
                    titleFormat: 'YYYY MMMM '
                }
            },
            dayClick: function (date, jsEvent, view) {
                $(this).css('background-color', 'lightblue');
            },
            themeSystem: 'bootstrap4',
            height:650,
            bootstrapFontAwesome: {
                prev: 'fas fa-angle-left',
                next: 'fas fa-angle-right'
            }
        });
    </script>
</body>
</html>
