<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FullCalendar</title>
    <link rel="stylesheet" href='webjars/jquery-ui/1.12.1/jquery-ui.css'>
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.css' />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel='stylesheet' href='https://bootswatch.com/4/sketchy/bootstrap.css' />
    <link rel='stylesheet' href='webjars/fullcalendar/3.9.0/fullcalendar.print.css' media="print"/>
    <link rel='stylesheet' href='resources/css/style.css' />
    <script type="text/javascript" src='webjars/jquery/3.3.1/jquery.min.js' ></script>
    <script type="text/javascript" src='webjars/jquery-ui/1.12.1/jquery-ui.min.js'></script>


</head>
<body>


    <div id='calendar'></div>
    <div id="dialog" title="Диалоговое окно">
        <p>This is an animated dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
    </div>



    <script type="text/javascript" src='webjars/moment/2.22.2/min/moment.min.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/fullcalendar.js' ></script>
    <script type="text/javascript" src='webjars/fullcalendar/3.9.0/locale/ru.js' ></script>
    <script type="text/javascript" src='<c:url value="/resources/js/main.js"/>' ></script>

    <script>
        var myEvents = ${json};
    </script>
</body>
</html>
