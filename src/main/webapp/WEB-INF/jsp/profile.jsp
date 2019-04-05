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
                    <div class="d-flex justify-content-around">
                        <div class="p-6">
                            <form action="#" enctype="multipart/form-data" id="profile-image-form">
                                <div class="form-control" style="width:300px;height:300px;outline:2px solid #000;text-align: center;">
                                    <h3 style="display: inline-block;padding-top: 130px;">NO PHOTO</h3>
                                </div>
                                <br>
                                <div class="form-group">
                                    <div class="input-group" >
                                        <input type="text" id="text-input" class="form-control" placeholder="Recipient's username" style="padding-top:0;padding-bottom:0;height: 30px;" readonly>
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-success btn-sm" type="button" onclick="addImage()"><i class="fas fa-search"></i></button>
                                            <button class="btn btn-outline-danger btn-sm" type="button" onclick="clearImageInput()"><i class="fas fa-trash"></i></button>
                                        </div>
                                    </div>
                                    <input type="file" name="image" id="image-input" accept="image/*" hidden>
                                </div>
                            </form>
                        </div>
                        <div class="p-6">
                            <h1>HALLO!</h1>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
