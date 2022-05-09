<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Carport:
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <br>
        <h3>Quick-build offer - Carport with a flat roof</h3>
        <br>
        <h5>With a specially developed computer program, we can quickly calculate the price and print a sketch on a carport within our standard program, which is adapted to your specific wishes.</h5>
        <h5>A proposition and sketch of the carport will be sent as fast as possible.</h5>
        <h5>When ordering, standard construction instructions are included.</h5>
        <h5>Fill in the form below carefully and click on "Send request".</h5> <br>
        <form method="post">
            <label for="carport_width"><h5>Carport width</h5></label>
            <br>
            <select name="carport_width" id="carport_width">
                <option disabled selected value> Choose width</option>
                <c:forEach items="${sessionScope.carportWidthList}" var="items">
                    <option value="${items.carportWidthCM}"> ${items.carportWidthCM} cm </option>
                </c:forEach>
            </select><br><br>


            <label for="carport_length"><h5>Carport length</h5></label><br>

            <select name="carport_length" id="carport_length">
                <option disabled selected value> Choose length</option>
                <c:forEach items="${sessionScope.carportLengthList}" var="items">
                    <option value="${items.carportLengthCM}"> ${items.carportLengthCM} cm </option>
                </c:forEach>
            </select> <br><br>

            <label for="rooftype"><h5>Roof</h5></label>
            <br>
            <select name="rooftype" id="rooftype">
                <option disabled selected value> Choose roof</option>
                <c:forEach items="${sessionScope.rooftypeList}" var="items">
                    <option value="${items.roofName}"> ${items.roofName} </option>
                </c:forEach>
            </select>
            <br>
            <br>
            <h5>Toolshed:</h5>
            <h6>NB! A 15 cm roof overhang must be calculated on each side of the tool room </h6><br>
            <label for="toolshed_width"><h5>Toolshed width</h5></label>
            <br>
            <select name="toolshed_width" id="toolshed_width">
                <option>I don't want a toolshed</option>
                <c:forEach items="${sessionScope.toolshedWidthList}" var="items">
                <option value="${items.toolshedWidth}"> ${items.toolshedWidth} cm </option>
                </c:forEach>
            </select><br><br>

            <label for="toolshed_length"><h5>Toolshed length</h5></label>
            <br>
            <select name="toolshed_length" id="toolshed_length">
                <option>I don't want a toolshed</option>
                <c:forEach items="${sessionScope.toolshedLengthList}" var="items">
                    <option value="${items.toolshedLength}"> ${items.toolshedLength} cm </option>
                </c:forEach>
            </select><br><br>

            <input type="submit"  value="Send request"/> <br> <br>
            <h6>Important info: if you have chosen a carport with the dimensions 240x360 cm, the toolshed can measure a maximum of 210x330 cm.</h6>
        </form>

        <h4>${sessionScope.error}</h4>
    </jsp:body>
</t:pagetemplate>