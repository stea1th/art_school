<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<link rel='stylesheet' href='resources/css/nouislider.css'/>
<script type="text/javascript" src='<c:url value="/resources/js/zahlung.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/slider/nouislider.min.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/slider/range_slider.js"/>' defer></script>

<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-md-10 ml-auto mr-auto">
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

<div class="modal fade" id="createZahlung" tabindex="-1" role="dialog" aria-labelledby="createZahlung"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Добавить способ оплаты</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="zahlung-detailsForm">
                    <div>
                        <input type="hidden" class="form-control" id="id" name="id">
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-4 col-form-label">Название</label>
                        <div class="col-8">
                            <input type="text" id="name" name="name" class="form-control" required="required"/>
                        </div>
                    </div>
                    <%--<div class="form-group row">--%>

                    <div class="example">
                        <div class="form-group row">
                            <label class="col-4 col-form-label">Цена</label>
                            <div class="col-8">
                                <div class="slider noUi-target noUi-ltr noUi-horizontal" id="slider1">
                                </div>
                                <span><i class="fas fa-euro-sign"></i> </span>
                                <span class="example-val" id="slider1-span"></span>
                                <input type="hidden" id="preis" name="preis"/>
                            </div>
                            <label class="col-4 col-form-label">Время</label>
                            <div class="col-8">
                                <div class="slider noUi-target noUi-ltr noUi-horizontal" id="slider2">
                                </div>
                                <span><i class="far fa-clock"></i> </span>
                                <span class="example-val" id="slider2-span"></span>
                                <input type="hidden" id="dauer" name="dauer"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Активный?</label>
                        <div class="col-8">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="aktiv" name="aktiv"
                                       checked="checked"
                                       value="true" required>
                                <label class="custom-control-label" for="aktiv">Да</label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="lockbutton" class="btn btn-outline-info btn-sm">Заблокировать</button>
                <button type="button" class="btn btn-primary" id="saveZahlung">Сохранить</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>
