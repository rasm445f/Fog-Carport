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

        <table class="content-table">
            <thead>
            <tr>
                <th> Order ID:</th>
                <th> Customer Name:</th>
                <th> Order Price:</th>
                <th> Order Status:</th>
                <th> Carport Length:</th>
                <th> Carport Width:</th>
                <th> Rooftype:</th>
                <th> Toolshed Length:</th>
                <th> Toolshed Width:</th>

            </tr>
            </thead>

                <c:forEach items="${sessionScope.carportDataListAdmin}" var="items">
                    <tr>
                    <td> <c:out value="${items.order_id}"/></td>
                    <td> <c:out value="${items.customerName}"/></td>
                        <td> <c:out value="${items.order_price}"/></td>
                        <c:if test="${items.order_status == 0}">
                            <td> <c:out value="Not autherized"/></td>
                        </c:if>
                        <c:if test="${items.order_status == 1}">
                            <td> <c:out value="Autherized"/></td>
                        </c:if>

                    <td> <c:out value="${items.carportLengthCM}"/></td>
                    <td> <c:out value="${items.carportWidthCM}"/></td>
                    <td> <c:out value="${items.roofName}"/></td>
                    <td> <c:out value="${items.toolshedLengthCM}"/></td>
                    <td> <c:out value="${items.toolshedWidthCM}"/></td>
            </tr>
                </c:forEach>

        </table>

        <form action="carportAdmin" method="post">

            <label for="order_id">Order ID: </label>
            <input type="number" id="order_id" name="order_id"/>
            <br>
            <br>
            <label for="order_price">Order Price: </label>
            <input type="number" id="order_price" name="order_price"/>
            <br>
            <br>
            <label for="order_status">Order Status: </label>
            <input type="number" id="order_status" name="order_status"/>
            <br>
            <br>
            <input type="submit"  value="Update order"/>
        </form>


    </jsp:body>

</t:pagetemplate>