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
        <h5>Fill in the form below carefully and click on "Send request".</h5>
        <form method="post">
            <label for="carport_width">Choose your preferred width</label>
            <br>
            <select name="carport_width" id="carport_width">
                <option disabled selected value> Choose width </option>
            </select>
            <br>
            <br>
            <label for="carport_length">Choose your preferred length</label>
            <br>
            <select name="carport_length" id="carport_length">
                <option disabled selected value> Choose length </option>
            </select>
            <br>
            <br>
            <label for="rooftype">Choose your preferred type of roof</label>
            <br>
            <select name="rooftype" id="rooftype">
                <option disabled selected value> Choose roof </option>
            </select>
            <br>
            <br>
            <label for="toolshed_width">Choose your preferred width of the toolshed</label>
            <br>
            <select name="toolshed_width" id="toolshed_width">
                <option> I don't wish a toolshed </option>
            </select>
            <br>
            <br>
            <label for="toolshed_length">Choose your preferred length of the toolshed</label>
            <br>
            <select name="toolshed_length" id="toolshed_length">
                <option> I don't wish a toolshed </option>
            </select>
            <br>
            <br>
            <input type="submit"  value="Send request"/>
        </form>

    </jsp:body>
</t:pagetemplate>