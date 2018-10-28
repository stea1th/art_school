
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>

<h1>Kind</h1>
<table id="kids" class="display" style="width:100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Адрес</th>
        <th>Активный</th>
        <th>Регистрация</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Адрес</th>
        <th>Активный</th>
        <th>Регистрация</th>
    </tr>
    </tfoot>
</table>

<script src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="webjars/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
