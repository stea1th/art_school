<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src='<c:url value="/resources/js/profile.js"/>' defer></script>
<jsp:include page="fragments/bodyNav.jsp"/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ml-auto mr-auto">
            <div class="card border-light mb-3" id="table-card3">
                <div class="card-body">
                    <h1>PROFILE</h1>
                    <form action="#" enctype="multipart/form-data" id="profile-image-form">
                        <div class="d-flex justify-content-around">
                            <div class="p-4">
                                <div id="preview" class="form-control"
                                     style="width:300px;height:300px;outline:2px solid #000;text-align: center;">
                                    <h3 style="display: inline-block;padding-top: 130px;">NO PHOTO</h3>
                                </div>
                                <br>
                                <div class="form-group">
                                    <div class="input-group">
                                        <input type="text" id="text-input" class="form-control"
                                               placeholder="image name"
                                               style="padding-top:0;padding-bottom:0;height: 30px;" readonly>
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-success btn-sm" type="button"
                                                    onclick="updateImage()"><i class="fas fa-search"></i></button>
                                            <button class="btn btn-outline-danger btn-sm" type="button"
                                                    onclick="clearImageInput()"><i class="fas fa-trash"></i></button>
                                        </div>
                                    </div>
                                    <input type="file" name="image" id="image-input" accept="image/*" hidden>
                                </div>

                            </div>
                            <div class="p-4">
                                <div class="form-group row">
                                    <label for="name" class="col-4 col-form-label">Имя</label>
                                    <div class="col-8">
                                        <input type="text" id="name" name="name" class="form-control" required="required" readonly/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="adresse" class="col-4 col-form-label">Адрес</label>
                                    <div class="col-8">
                                        <input type="text" id="adresse" name="adresse" class="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="email" class="col-4 col-form-label">E-Mail</label>
                                    <div class="col-8">
                                        <input type="email" id="email" name="email" class="form-control" required="required"/>
                                    </div>
                                </div>
                            </div>
                            <div class="p-4">
                                <div class="form-group row">
                                    <label for="new-passwort" class="col-4 col-form-label">Новый пароль</label>
                                    <div class="col-8">
                                        <input type="text" id="new-passwort" name="newPasswort" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="repeat-passwort" class="col-4 col-form-label">Повторить пароль</label>
                                    <div class="col-8">
                                        <input type="text" id="repeat-passwort" name="repeatPasswort" class="form-control"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="form-control">
                        <jsp:include page="../jsp/buttons/save-and-close.jsp">
                            <jsp:param name="notModal" value="true"/>
                            <jsp:param name="saveId" value="saveProfile"/>
                        </jsp:include>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
