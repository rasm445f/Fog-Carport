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

        <h3>Quick-build offer - Carport with a flat roof</h3>

        <form method="post">
            <label for="carport_width">Choose your preferred width</label>
            <select name="carport_width" id="carport_width">

            </select>
            <label for="carport_length">Choose your preferred length</label>
            <select name="carport_length" id="carport_length">
            </select>
            <label for="rooftype">Choose your preferred type of roof</label>
            <select name="rooftype" id="rooftype">
            </select>
            <label for="toolshed_width">Choose your preferred width of the toolshed</label>
            <select name="toolshed_width" id="toolshed_width">

            </select>
            <label for="toolshed_length">Choose your preferred length of the toolshed</label>
            <select name="toolshed_length" id="toolshed_length">
            </select>
        </form>

    </jsp:body>
</t:pagetemplate>