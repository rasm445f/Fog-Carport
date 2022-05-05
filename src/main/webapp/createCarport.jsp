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

        <h3>Quick-build offer - Carport with a flat roof</h3>
        <br>
        <form method="post">
            <label for="carport_width">Choose your preferred width</label>
            <select name="carport_width" id="carport_width">
            </select>
            <br>
            <br>
            <label for="carport_length">Choose your preferred length</label>
            <select name="carport_length" id="carport_length">
            </select>
            <br>
            <br>
            <label for="rooftype">Choose your preferred type of roof</label>
            <select name="rooftype" id="rooftype">
            </select>
            <br>
            <br>
            <label for="toolshed_width">Choose your preferred width of the toolshed</label>
            <select name="toolshed_width" id="toolshed_width">
            </select>
            <br>
            <br>
            <label for="toolshed_length">Choose your preferred length of the toolshed</label>
            <select name="toolshed_length" id="toolshed_length">
            </select>
            <br>
            <br>
            <input type="submit"  value="Send request"/>
        </form>

    </jsp:body>
</t:pagetemplate>