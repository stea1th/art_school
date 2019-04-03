<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<link rel='stylesheet' href='resources/css/nouislider.css'/>

<script type="text/javascript" src='<c:url value="/resources/js/slider/nouislider.min.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/slider/range_slider.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/zahlung.js"/>' defer></script>

<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card2">
                <div class="card-body">
                    <table id="zahlungen" class="display responsive no-wrap" width="100%">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th data-priority="1">Название</th>
                            <th>Цена</th>
                            <th>Продолжительность</th>
                            <th data-priority="1">Активный</th>
                            <th data-priority="2"></th>
                            <th data-priority="2"></th>
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
        </div>
    </div>
</div>
<spring:message code="slider.lock" var="lock"/>
<jsp:include page="fragments/modal.jsp">
    <jsp:param name="url" value="../forms/zahlung-form.jsp"/>
    <jsp:param name="modalId" value="createZahlung"/>
    <jsp:param name="buttons" value="../buttons/three-buttons.jsp"/>
    <jsp:param name="saveId" value="saveZahlung" />
    <jsp:param name="thirdButtonId" value="lockbutton" />
    <jsp:param name="thirdButtonName" value="${lock}" />
</jsp:include>
</body>
<jsp:include page="i18n/i18n.jsp">
    <jsp:param name="page" value="zahlung"/>
</jsp:include>
</html>
