<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<form id="block-detailsForm">
    <div class="form-group row">
        <label for="name" class="col-4 col-form-label"><spring:message code="app.users"/></label>
        <div class="col-8">
            <input type="text" id="name" name="name" class="form-control" required="required" readonly/>
        </div>
    </div>
    <div class="form-group row">
        <label for="interval" class="col-4 col-form-label"><spring:message code="forum.block"/></label>
        <spring:message code="forum.interval" var="interval"/>
        <div class="col-4">
            <input placeholder="${interval}" title="${interval}" min="0" max="100" type="number" id="interval" name="interval" class="form-control" required="required" />
        </div>
        <div class="col-4">
            <spring:message code="forum.timeunits" var="units"/>
            <select id="unit-time" name="unit-time" title="${units}" class="custom-select" required="required">
                <option value="minutes" selected><spring:message code="forum.block.minutes"/> </option>
                <option value="hours"><spring:message code="forum.block.hours"/></option>
                <option value="days"><spring:message code="forum.block.days"/></option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <spring:message code="forum.reason" var="reason"/>
        <div class="col-12">
                        <textarea class="form-control" id="reason" name="reason" rows="3"
                                  placeholder="${reason}"></textarea>
        </div>
    </div>
</form>

