
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<br/>
<div class="modal fade" id="createUnterricht" tabindex="-1" role="dialog" aria-labelledby="createUnterricht" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="create">Создать урок</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                <%--<form>--%>
                    <div>
                        <input type="hidden" class="form-control" id="id" name="id">
                    </div>
                    <div class="form-group" >
                        <input type="text" readonly="" class="form-control" id="datum" hidden>
                    </div>
                    <div class="form-group">
                        <%--<label for="kind" class="col-form-label" >Ребёнок</label>--%>
                        <input type="text" class="form-control" id="kind" placeholder="Ребёнок" required>
                    </div>
                    <div class="form-group">
                        <%--<label for="kind" class="col-form-label" >Ребёнок</label>--%>
                        <input type="text" class="form-control" id="zahlung" placeholder="Оплата" required>
                    </div>

                    <div class="form-group" id="div1">
                        <%--<label for="timepicker" class="col-sm-2 col-form-label">Время</label>--%>
                        <input type="text" class="form-control"  id="timepicker" placeholder="Время" style="width: 50%" required>
                    </div>
                    <div class="form-group" id="div1">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="bezahlt" checked="checked" value="true" required>
                            <label class="custom-control-label" for="bezahlt">Заплатил</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <%--<label for="exampleTextarea">Example textarea</label>--%>
                        <textarea class="form-control" id="notiz" rows="3" placeholder="Заметка"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-success" onclick="save()">Сохранить</button>
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
</body>
</html>
