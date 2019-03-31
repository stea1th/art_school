<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sex" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>

<div class="card-group messages">
    <div class="card col-md-3" id="left-card_${message.id}">
        <div class="card-header">
            <c:out value="${message.name}"/>
            <input type="hidden" id="message-id" value="${message.id}"/>
        </div>
        <div class="card-body" style="display: flex; align-items: center;">
            <ul>
                <li>
                    <c:choose>
                        <c:when test="${message.roleSize == 3}">
                            <strong style="color:red;"><c:out value="Администратор"/></strong>
                        </c:when>
                        <c:when test="${message.roleSize == 2}">
                            <strong style="color:green;"><c:out value="Модератор"/></strong>
                        </c:when>
                        <c:otherwise>
                            <strong style="color:black;"><c:out value="Пользователь"/></strong>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li>
                    <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user-astronaut" role="img"
                         xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"
                         class="svg-inline--fa fa-user-astronaut fa-w-14 fa-8x" style="margin: 0 auto;">
                        <defs class="">
                            <clipPath id="clip-GKyi2S8Ru5X4" class="">
                                <path fill="currentColor"
                                      d="M400 32H48C21.5 32 0 53.5 0 80v352c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48V80c0-26.5-21.5-48-48-48z"
                                      class=""></path>
                            </clipPath>
                            <mask x="0" y="0" width="100%" height="100%" id="mask-pRKbGXp3ynw3"
                                  maskUnits="userSpaceOnUse"
                                  maskContentUnits="userSpaceOnUse" class="">
                                <rect x="0" y="0" width="100%" height="100%" fill="white" class=""></rect>
                                <g transform="translate(224 256)" class="">
                                    <g transform="translate(0, 0)  scale(0.5625, 0.5625)  rotate(0 0 0)" class="">
                                        <path fill="black"
                                              d="M64 224h13.5c24.7 56.5 80.9 96 146.5 96s121.8-39.5 146.5-96H384c8.8 0 16-7.2 16-16v-96c0-8.8-7.2-16-16-16h-13.5C345.8 39.5 289.6 0 224 0S102.2 39.5 77.5 96H64c-8.8 0-16 7.2-16 16v96c0 8.8 7.2 16 16 16zm40-88c0-22.1 21.5-40 48-40h144c26.5 0 48 17.9 48 40v24c0 53-43 96-96 96h-48c-53 0-96-43-96-96v-24zm72 72l12-36 36-12-36-12-12-36-12 36-36 12 36 12 12 36zm151.6 113.4C297.7 340.7 262.2 352 224 352s-73.7-11.3-103.6-30.6C52.9 328.5 0 385 0 454.4v9.6c0 26.5 21.5 48 48 48h80v-64c0-17.7 14.3-32 32-32h128c17.7 0 32 14.3 32 32v64h80c26.5 0 48-21.5 48-48v-9.6c0-69.4-52.9-125.9-120.4-133zM272 448c-8.8 0-16 7.2-16 16s7.2 16 16 16 16-7.2 16-16-7.2-16-16-16zm-96 0c-8.8 0-16 7.2-16 16v48h32v-48c0-8.8-7.2-16-16-16z"
                                              transform="translate(-224 -256)" class=""></path>
                                    </g>
                                </g>
                            </mask>
                        </defs>
                        <rect fill="currentColor" clip-path="url(#clip-GKyi2S8Ru5X4)" mask="url(#mask-pRKbGXp3ynw3)"
                              x="0"
                              y="0"
                              width="100%" height="100%" class=""></rect>
                    </svg>
                </li>
                <li>
                    <div>
                        Регистрация:&nbsp;<c:out value="${message.registriert}"/>
                    </div>
                </li>
                <li>
                    <div>
                        Сообщений:&nbsp;<c:out value="${message.messages}"/>
                    </div>
                </li>
                <li>
                    <div>
                        Статус:&nbsp;
                        <c:if test="${message.banned == null}">
                            <span>Полный</span>
                        </c:if>
                        <c:if test="${message.banned != null}">
                            <span style="color:red;">
                                Только чтение
                            </span>
                        </c:if>
                    </div>
                </li>
                <li>
                    <c:if test="${message.banned != null}">
                        <div style="color:red;">
                            <c:out value="${message.banned}"/>
                        </div>
                    </c:if>
                </li>

            </ul>
        </div>
    </div>

    <div class="card col-md-9" id="right-card_${message.id}">
        <div class="card-header">
            <div class="row">
                <div class="col">
                    <c:out value="${message.datum}"/>
                </div>
                <div>
                    <c:if test="${message.updaterInfo != null}">
                        <c:out value="${message.updaterInfo}"/>
                    </c:if>
                </div>
                <div class="col">

                </div>
            </div>
        </div>
        <div class="card-body">
            <div id="user-message_${message.id}">
                <c:if test="${message.parentMessages != null}">
                    <blockquote>
                        <c:forEach var="para" items="${message.parentMessages}">
                            <c:out value="${para}" escapeXml="false"/><br/>
                        </c:forEach>
                    </blockquote>
                </c:if>
                <c:forEach var="paragraph" items="${message.lines}">
                    <c:out value="${paragraph}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
            <div id="add-message_${message.id}">
            </div>
        </div>
        <div class="card-footer">
            <div class="row">
                <sec:authentication property="principal.authorities" var="authorities"/>
                <sec:authentication property="principal.id" var="id"/>
                <c:set value="${fn:length(authorities)>= message.roleSize}" var="enoughRights"/>
                <c:set var="isOwner" value="${id == message.userId}"/>
                <c:if test="${active != false}">
                    <c:if test="${!message.text.equals('<-- Deleted -->')}">
                        <sec:authorize access="not ${isBanned}">
                            <div>
                                <button type="button" class="answer-btn" value="${message.id}" style="float:right"
                                        onclick="answerIt(${message.id})">Ответить
                                </button>
                            </div>
                        </sec:authorize>
                        <sec:authorize
                                access="(hasRole('ROLE_MODERATOR') and ${enoughRights}) or (${isOwner} and not ${isBanned})">
                            <div>
                                <button type="button" style="float:right" onclick="updateMessage(${message.id})">
                                    Изменить
                                </button>
                            </div>
                            <div>
                                <button type="button" style="float:right" onclick="deleteMessage(${message.id})">
                                    Удалить
                                </button>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="(hasRole('ROLE_MODERATOR') and ${enoughRights})">
                            <c:choose>
                                <c:when test="${message.banned == null}">
                                    <div>
                                        <button type="button" style="float:right" onclick="changeToBlocked(${message.userId})">
                                            Заблокировать
                                        </button>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div>
                                        <button type="button" style="float:right" onclick="changeToUnblocked(${message.userId})">
                                            Разблокировать
                                        </button>
                                    </div>
                                </c:otherwise>

                            </c:choose>

                        </sec:authorize>
                    </c:if>

                </c:if>
                <div style="position:absolute; right: 15px;">
                    <a id="${message.id}">#<c:out value="${message.id}"/></a>
                </div>
            </div>
        </div>
    </div>
</div>
<br>


