<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/common.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/zahlung.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="card border-light mb-3" id="table-card2">
    <div class="card-body">
        <table id="zahlungen" class="display compact">
            <thead>
            <tr>
                <th>Id</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Продолжительность</th>
                <th>Активный</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th>Id</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Продолжительность</th>
                <th>Активный</th>
                <th></th>
                <th></th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

</body>
</html>
