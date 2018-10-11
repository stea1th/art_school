<%--
  Created by IntelliJ IDEA.
  User: stea1
  Date: 10.10.2018
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event Calendar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/eventCalendar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/eventCalendar_theme_responsive.css">
</head>
<body>

    <div id="eventCalendar" style="width: 500px;height: 500px; margin: 50px auto;"></div>

    <%--<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.js"></script>--%>
    <script src="http://code.jquery.com/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.eventCalendar.js"></script>
    <script>
        $(function () {

            var data = [
                { "date": "2018-10-12 10:00:20", "title": "Test Last Year", "description": "Lorem Ipsum dolor set"},
                { "date": "2018-10-15 22:00:13", "type": "meeting", "title": "Privet Pukeschka", "description": "Kak dela?", "url": "http://tts.lt/" }
            ];
            $('#eventCalendar').eventCalendar({
                jsonData: data,
                jsonDateFormat: 'human',
                dateFormat: 'dddd D-MM-YYYY',
                locales: {
                    locale: "ru",
                    txt_noEvents: "Нет уроков в этот день",
                    txt_SpecificEvents_prev: "",
                    txt_SpecificEvents_after: ":",
                    txt_next: "следующий",
                    txt_prev: "предыдущий",
                    txt_NextEvents: "Следующий урок:",
                    txt_GoToEventUrl: "Смотреть",
                    moment: {
                        "months" : [ "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" ],
                        "monthsShort" : [ "Янв", "Фев", "Мар", "Апр", "Май", "Июн",
                            "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек" ],
                        "weekdays" : [ 'Понедельник','Вторник','Среда','Четверг',
                            'Пятница','Суббота','Воскресенье' ],
                        "weekdaysShort" : [ 'Вос', 'Пон','Вто','Сре','Чет', 'Пят','Суб' ],
                        "weekdaysMin" : [ "Вс", "Пн","Вт","Ср","Чт","Пт","Сб" ],
                        "longDateFormat" : {
                            "LT" : "H:mm",
                            "LTS" : "LT:ss",
                            "L" : "DD/MM/YYYY",
                            "LL" : " MMMM D[-е] YYYY",
                            "LLL" : "D [de] MMMM [de] YYYY LT",
                            "LLLL" : "dddd, D [de] MMMM [de] YYYY LT"
                        },
                        "week" : {
                            "dow" : 1,
                            "doy" : 4
                        }
                    }
                }
            });
        });
      
    </script>
</body>
</html>
