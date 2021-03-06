<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog" aria-labelledby="${param.modalId}"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modal-titel">${param.modalTitel}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="${param.url}" />
            </div>
            <div class="modal-footer">
                <jsp:include page="${param.buttons}"/>
            </div>
        </div>
    </div>
</div>