<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to Fog
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome
    </jsp:attribute>

    <jsp:body>



        <c:if test="${sessionScope.user != null}">
            <p>Hello ${sessionScope.user.name}! <br> Head to the navigationbar to create a carport or view your carport.</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. <br><br>

                <a href="login.jsp">Login</a> <br> <br>
                <a href="createUser">Create user</a>

            </p>
        </c:if>

    </jsp:body>

</t:pagetemplate>