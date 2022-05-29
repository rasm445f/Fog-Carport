<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Thank you for the request!
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.user != null}">
       <h2> Our employees will start working on your sketch and bill of materials! </h2>
        <h2>Don't hesitate to contact us if you have any questions about your carport!</h2>
        <br> <br>
        <h2>Click here to view the status of your carport, when the sketch and bill of materials are made, you can also pay here to gain access to them <br> <a
                href="carportCustomer">Your carport</a></h2>


        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>
    </jsp:body>

</t:pagetemplate>