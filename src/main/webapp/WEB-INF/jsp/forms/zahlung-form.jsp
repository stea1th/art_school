<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>

<form id="zahlung-detailsForm">
    <div>
        <input type="hidden" class="form-control" id="id" name="id">
    </div>
    <div><jsp:include page="../i18n/i18n-slider.jsp"/></div>
    <div class="form-group row">
        <label for="name" class="col-4 col-form-label">Название</label>
        <div class="col-8">
            <input type="text" id="name" name="name" class="form-control" required="required"/>
        </div>
    </div>
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
    <div class="form-group row" id="aktiv-checkbox">
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

