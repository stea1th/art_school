<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel='stylesheet' href='resources/css/login.css' />
    <script src="../../resources/js/polygonizr/polygonizr.min.js"></script>
</head>
<body>
<jsp:include page="fragments/bodyNav.jsp"/>
<div id="polygonizr"></div>



<!-- Modal HTML -->
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-login">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Sign In</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form action="login" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fas fa-user" content=""></i></span>
                            <input type="text" class="form-control" name="username" placeholder="Username" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fas fa-lock"></i></span>
                            <input type="text" class="form-control" name="password" placeholder="Password" required="required">
                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="checkbox" id="chkbx1" name="remember-me"/>
                            <label for="chkbx1">&nbsp;Remember me</label>
                            <%--<div class="contact100-form-checkbox m-l-4">--%>
                                <%--<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">--%>
                                <%--<label class="label-checkbox100" for="ckb1">--%>
                                    <%--Remember me--%>
                                <%--</label>--%>
                            <%--</div>--%>
                        </div>

                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">Sign In</button>
                    </div>
                    <p class="hint-text"><a href="#">Forgot Password?</a></p>
                </form>
            </div>
            <div class="modal-footer">Don't have an account? <a href="#">Create one</a></div>
        </div>
    </div>
</div>
</body>
</html>