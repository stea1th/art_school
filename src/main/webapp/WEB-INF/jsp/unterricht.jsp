<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<br/>
<div class="modal fade" id="createUnterricht" tabindex="-1" role="dialog" aria-labelledby="createUnterricht"
     aria-hidden="true">
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
                    <div>
                        <input type="hidden" class="form-control" id="id" name="id">
                    </div>
                    <div class="form-group">
                        <input type="text" readonly="" class="form-control" id="datum" hidden>
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="kind">Ребёнок</label>
                            <input type="text" class="form-control mx-sm-3" id="kind" placeholder="Ребёнок"
                                   aria-describedby="kindInlineHelp" required>
                            <small id="kindInlineHelp" class="text-muted">
                                Выберите ученика
                            </small>
                            <div class="invalid-feedback">
                                Пожалуйста выберите ученика
                            </div>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="zahlung">Оплата</label>
                            <input type="text" class="form-control mx-sm-3" id="zahlung" placeholder="Оплата"
                                   aria-describedby="zahlungInlineHelp" required>
                            <small id="zahlungInlineHelp" class="text-muted">
                                Выберите способ оплаты
                            </small>
                            <div class="invalid-feedback">
                                Пожалуйста выберите способ оплаты
                            </div>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="timepicker">Время</label>
                            <input type="text" class="form-control mx-sm-3" id="timepicker" placeholder="Время"
                                   aria-describedby="timeInlineHelp" required>
                            <small id="timeInlineHelp" class="text-muted">
                                Выберите начало урока
                            </small>
                            <div class="invalid-feedback">
                                Пожалуйста выберите начало урока
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="bezahlt" checked="checked"
                                   value="true" required>
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
                <button type="button" class="btn btn-success" onclick="save()"><i class='fa fa-pencil'></i>Сохранить</button>
            </div>
        </div>
    </div>
</div>

<div class="card border-light mb-3" id="calendar-card">
    <div class="card-body">
        <div id='calendar'></div>
    </div>
</div>
<script type="text/javascript" src='<c:url value="/resources/js/unterricht.js"/>'></script>

</body>
</html>
