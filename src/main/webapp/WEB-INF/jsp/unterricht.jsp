<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/unterricht.js"/>' defer></script>
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
                        <input type="text" readonly="" class="form-control" id="datum" name="datum" hidden>
                    </div>

                    <div class="form-group row">
                        <label for="kind" class="col-4 col-form-label">Ученик</label>
                        <div class="col-8">
                            <select id="kind" name="kind" class="custom-select" required="required">
                                <option value="rabbit">Rabbit</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="zahlung" class="col-4 col-form-label">Оплата</label>
                        <div class="col-8">
                            <select id="zahlung" name="zahlung" class="custom-select" required="required">
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="timepicker" class="col-4 col-form-label">Время</label>
                        <div class="col-8">
                            <input id="timepicker" name="timepicker" required/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Оплатили?</label>
                        <div class="col-8">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="bezahlt" name="bezahlt"
                                       checked="checked"
                                       value="true" required>
                                <label class="custom-control-label" for="bezahlt">Да</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-12">
                        <textarea class="form-control" id="notiz" name="notiz" rows="3"
                                  placeholder="Заметка"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-success" onclick="saveUnterricht()"><i class='fa fa-pencil'></i>Сохранить
                </button>
            </div>
        </div>
    </div>
</div>

<div class="card border-light mb-3" id="calendar-card">
    <div class="card-body">
        <div id='calendar'></div>
    </div>
</div>
</body>
</html>
