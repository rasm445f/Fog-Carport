<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="header">
             Create user
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <h4>Please fill out the information below.</h4>

        <form action="createUser" method="post" class="form">

            <label for="email">E-mail: </label>
            <input type="text" id="email" name="email" placeholder="Type your e-mail"/>
            <br>
            <br>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"placeholder="Type your password"/>
            <br>
            <br>
            <label for="name">Name: </label>
            <input type="text" id="name" name="name"placeholder="Type your name"/>
            <br>
            <br>
            <label for="address">Address: </label>
            <input type="text" id="address" name="address"placeholder="Type your address"/>
            <br>
            <br>
            <label for="city">City: </label>
            <input type="text" id="city" name="city"placeholder="Type which city you live in"/>
            <br>
            <br>
            <label for="zipcode">Zipcode: </label>
            <input type="number" id="zipcode" name="zipcode"placeholder="Type the zipcode of the city"/>
            <br>
            <br>
            <label for="phone_number">Phone number: </label>
            <input type="number" id="phone_number" name="phone_number"placeholder="Type your phone number"/>
            <br>
            <br>
            <input type="submit"  value="Create user"/>

        </form>

    </jsp:body>
</t:pagetemplate>