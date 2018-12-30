<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/statistik.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<%--<div align="center">--%>
    <%--<input type="button" value="Test" id="test-btn"/>--%>
<%--</div>--%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="calendar-card">
                <div class="card-body">
                    <div align="center">
                        <select id="statistik" name="statistik" class="custom-select" required="required">
                            <option selected>2018</option>
                        </select>
                    </div>
                    <canvas id="myChart"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
