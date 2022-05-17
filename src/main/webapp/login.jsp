<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>



        <form action="login" method="post">
            <div class="input">
            <label for="email">Email: </label>
            <input type="text" id="email" name="email" placeholder="Type your e-mail"/>

            <label for="password">Password: </label>
            <input type="password" id="password" name="password" placeholder="Type your password"/>
            <br>
            <br>

            <input type="submit"  value="Log in"/>
            </div>
        </form>

    </jsp:body>
</t:pagetemplate>