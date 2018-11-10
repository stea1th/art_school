<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/zahlung.js"/>' defer></script>
<script type="text/javascript" src='<c:url value="/resources/js/common.js"/>' defer></script>

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

<div class="modal fade" id="createZahlung" tabindex="-1" role="dialog" aria-labelledby="createUnterricht"
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
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>
