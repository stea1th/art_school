<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form id="detailsForm">
    <div>
        <input type="hidden" class="form-control" id="id" name="id">
    </div>
    <div class="form-group">
        <input type="text" readonly="" class="form-control" id="datum" name="datum" hidden>
    </div>

    <div class="form-group row">
        <label for="kind" class="col-4 col-form-label">Ученик</label>
        <div class="col-8" id="kind-div">
            <select id="kind" name="kind" class="custom-select" required="required">
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label for="zahlung" class="col-4 col-form-label">Оплата</label>
        <div class="col-8" id="zahlung-div">
            <select id="zahlung" name="zahlung" class="custom-select" required="required">
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label for="zeit" class="col-4 col-form-label">Время</label>
        <div class="col-8">
            <input id="zeit" name="zeit" required/>
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
