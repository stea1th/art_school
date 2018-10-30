<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="card border-light mb-3" id="table-card">
    <div class="card-body">
        <table id="kids" class="display compact">
            <thead>
            <tr>
                <th>Id</th>
                <th>Имя</th>
                <th>Адрес</th>
                <th>Активный</th>
                <th>Регистрация</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th>Id</th>
                <th>Имя</th>
                <th>Адрес</th>
                <th>Активный</th>
                <th>Регистрация</th>
                <th></th>
                <th></th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>


<script src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="webjars/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src='<c:url value="/resources/js/kind.js"/>'></script>
</body>
</html>
