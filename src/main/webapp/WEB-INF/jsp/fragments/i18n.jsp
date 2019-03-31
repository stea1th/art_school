<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<script type="text/javascript">--%>
    <%--var i18n = [];--%>
    <%--i18n["addTitle"] = '<spring:message code="${param.page}.add"/>';--%>
    <%--i18n["updateTitle"] = '<spring:message code="${param.page}.update"/>';--%>
    <%--<c:forEach var='key' items='<%=new String[]{"common.deleted", "common.saved", "common.enabled", "common.disabled", "common.errorStatus"}%>'>--%>
    <%--i18n['${key}'] = '<spring:message code="${key}"/>';--%>
    <%--</c:forEach>--%>
<%--</script>--%>
<jsp:element name="input">
    <jsp:attribute name="type">hidden</jsp:attribute>
    <jsp:attribute name="id">hidden-param</jsp:attribute>
    <jsp:attribute name="addTitle"><spring:message code="${param.page}.add"/></jsp:attribute>
    <jsp:attribute name="updateTitle"><spring:message code="${param.page}.update"/></jsp:attribute>
</jsp:element>
