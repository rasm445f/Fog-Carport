<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate>

    <jsp:attribute name="header">
         SVG - Sketch of carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.user != null}">
        <div class="svg_img">

                ${requestScope.svgdrawing}

        </div>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>
    </jsp:body>
</t:pagetemplate>