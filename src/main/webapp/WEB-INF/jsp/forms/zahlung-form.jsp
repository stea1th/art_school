<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form id="zahlung-detailsForm">
    <div>
        <input type="hidden" class="form-control" id="id" name="id">
    </div>
    <div>
        <jsp:include page="../i18n/i18n-slider.jsp"/>
    </div>
    <div class="form-group row">
        <label for="name" class="col-4 col-form-label"><spring:message code="forum.title"/><spring:message
                code="app.asteriks"/></label>
        <div class="col-8" id="name-div">
            <input type="text" id="name" name="name" class="form-control" required="required"/>
        </div>
    </div>
    <div class="example">
        <div class="form-group row">
            <label class="col-4 col-form-label"><spring:message code="app.price"/></label>
            <div class="col-8">
                <div class="slider noUi-target noUi-ltr noUi-horizontal" id="slider1">
                </div>
                <div class="slider-div">
                    <span><i class="fas fa-euro-sign"></i> </span>
                    <span class="example-val" id="slider1-span"></span>
                    <input type="hidden" id="preis" name="preis"/>
                </div>
            </div>
            <label class="col-4 col-form-label"><spring:message code="app.duration"/></label>
            <div class="col-8">
                <div class="slider noUi-target noUi-ltr noUi-horizontal" id="slider2">
                </div>
                <div class="slider-div">
                    <span><i class="far fa-clock"></i> </span>
                    <span class="example-val" id="slider2-span"></span>
                    <input type="hidden" id="dauer" name="dauer"/>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group row" id="aktiv-checkbox">
        <label class="col-4"><spring:message code="app.active"/>?</label>
        <div class="col-8">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="aktiv" name="aktiv"
                       checked="checked"
                       value="true" required>
                <label class="custom-control-label" for="aktiv"><spring:message code="app.yes"/></label>
            </div>
        </div>
    </div>
</form>

