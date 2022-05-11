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

            <tr>
                <th> Carport Length:</th>
                <th> Carport Width:</th>
                <th> Rooftype:</th>
                <th> Toolshed Length:</th>
                <th> Toolshed Width:</th>

            </tr>
            <tr>
                <c:forEach items="${sessionScope.carportDataList}" var="items">

                   <td> ${items.carportLengthCM}</td>
                    <td> ${items.carportWidthCM}</td>
                    <td>${items.roofName}</td>
                    <td>${items.toolshedLengthCM}</td>
                    <td>${items.toolshedWidthCM}</td>

                </c:forEach>
            </tr>





        </table>
             <br>
             <input type="submit"  value="See sketch"/>
             <br>
             <br>
             <input type="submit"  value="See bill of materials"/>


    </jsp:body>

</t:pagetemplate>