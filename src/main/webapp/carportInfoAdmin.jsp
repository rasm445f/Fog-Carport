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


        <h2>List of orders: </h2> <br>

        <table>

            <tr>
                <th> Order ID:</th>
                <th> Customer Name:</th>
                <th> Carport Length:</th>
                <th> Carport Width:</th>
                <th> Rooftype:</th>
                <th> Toolshed Length:</th>
                <th> Toolshed Width:</th>

            </tr>

                <c:forEach items="${sessionScope.carportDataListAdmin}" var="items">
                    <tr>
                    <td> <c:out value="${items.order_id}"/></td>
                    <td> <c:out value="${items.customerName}"/></td>
                    <td> <c:out value="${items.carportLengthCM}"/></td>
                    <td> <c:out value="${items.carportWidthCM}"/></td>
                    <td> <c:out value="${items.roofName}"/></td>
                    <td> <c:out value="${items.toolshedLengthCM}"/></td>
                    <td> <c:out value="${items.toolshedWidthCM}"/></td>
            </tr>
                </c:forEach>






        </table>


    </jsp:body>

</t:pagetemplate>