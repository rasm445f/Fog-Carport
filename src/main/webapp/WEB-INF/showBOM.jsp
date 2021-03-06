<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.user != null}">

        <h2>Bill of materials: </h2> <br>

        <table class="content-table">
            <thead>
            <tr>
                <th> Træ og Tagplader:</th>
                <th> Længde:</th>
                <th> Antal:</th>
                <th> Enhed:</th>
                <th> Beskrivelse:</th>

            </tr>
            </thead>

            <c:forEach items="${sessionScope.bomSpecification}" var="items">
                <tr>
                    <td> <c:out value="${items.materialDescription}"/></td>
                    <td> <c:out value="${items.materialLength}"/></td>
                    <td> <c:out value="${items.materialAmount}"/></td>
                    <td> <c:out value="${items.materialUnit}"/></td>
                    <td> <c:out value="${items.materialGuidance}"/></td>

                </tr>
            </c:forEach>

        </table>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>
    </jsp:body>

</t:pagetemplate>