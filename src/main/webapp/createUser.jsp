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

        <h3>You can log in here</h3>

        <form action="createUser" method="post">

            <label for="email">E-mail: </label>
            <input type="text" id="email" name="email"/>
            <br>
            <br>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <br>
            <br>
            <label for="name">Name: </label>
            <input type="name" id="name" name="name"/>
            <br>
            <br>
            <label for="address">Address: </label>
            <input type="address" id="address" name="address"/>
            <br>
            <br>
            <label for="city">City: </label>
            <input type="city" id="city" name="city"/>
            <br>
            <br>
            <label for="zipcode">Zipcode: </label>
            <input type="zipcode" id="zipcode" name="zipcode"/>
            <br>
            <br>
            <label for="phone_number">Phone number: </label>
            <input type="phone_number" id="phone_number" name="phone_number"/>
            <br>
            <br>
            <input type="submit"  value="Create user"/>
        </form>

    </jsp:body>
</t:pagetemplate>