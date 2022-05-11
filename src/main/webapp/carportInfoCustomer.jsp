<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <h2>Overview of your carport: </h2> <br>

        <table>
            <tbody>

            <tr>
            <th> Carport Length:</th>
            <td> test</td>
            </tr>

            <tr>
                <th> Carport Width:</th>
                <td> test</td>
            </tr>

            <tr>
                <th> Rooftype:</th>
                <td> test</td>
            </tr>

            <tr>
                <th> Toolshed Length:</th>
                <td> test</td>
            </tr>

            <tr>
                <th> Toolshed Width:</th>
                <td> test</td>
            </tr>

            </tbody>
        </table>
             <br>
             <input type="submit"  value="See sketch"/>
             <br>
             <br>
             <input type="submit"  value="See bill of materials"/>


    </jsp:body>

</t:pagetemplate>