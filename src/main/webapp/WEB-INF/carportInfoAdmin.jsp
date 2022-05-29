<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user.role == 'admin'}">

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
                <th> Update status:</th>
                <th> Update Price:</th>
                <th> Delete Order:</th>

            </tr>
            </thead>

                <c:forEach items="${sessionScope.carportDataListAdmin}" var="items">
                    <tr>
                    <td> <c:out value="${items.order_id}"/></td>
                    <td> <c:out value="${items.customerName}"/></td>
                        <td> <c:out value="${items.order_price}"/></td>
                        <c:if test="${items.order_status == 0}">
                            <td> <c:out value="Not authorized"/></td>
                        </c:if>
                        <c:if test="${items.order_status == 1}">
                            <td> <c:out value="Authorized"/></td>
                        </c:if>

                    <td> <c:out value="${items.carportLengthCM}"/></td>
                    <td> <c:out value="${items.carportWidthCM}"/></td>
                    <td> <c:out value="${items.roofName}"/></td>
                        <c:if test="${items.toolshedLengthCM != 0}">
                            <td> <c:out value="${items.toolshedLengthCM}"/></td>
                        </c:if>
                        <c:if test="${items.toolshedLengthCM == 0}">
                            <td>No toolshed</td>
                        </c:if>

                        <c:if test="${items.toolshedWidthCM != 0}">
                            <td> <c:out value="${items.toolshedWidthCM}"/></td>
                        </c:if>
                        <c:if test="${items.toolshedWidthCM == 0}">
                            <td>No toolshed</td>
                        </c:if>
                        <form action="updateStatus" method="post">
                        <td>
                            <button type="submit" formaction="updateStatus" name="update_status" value="${items.order_id}">Update Status</button>
                            <select name="order_status" id="status">
                                <option value="0">Not Authorized</option>
                                <option value="1">Authorized</option>

                            </select>
                        </form>

                        <form action="updatePrice" method="post">
                            <td>
                                <button type="submit" formaction="updatePrice" name="order_id" value="${items.order_id}">Update price</button>
                                <input class="updatePriceInput" type="number" id="orderPrice" name="order_price"/>
                        </form>

                        <form action="" method="post">
                            <td><button type="submit" formaction="deleteOrderAdmin" name="delete" value="${items.order_id}">Delete order</button></td>
                        </form>


                        </td>
            </tr>
                </c:forEach>

        </table>
        </c:if>
        <c:if test="${sessionScope.user.role == 'customer'}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>



    </jsp:body>

</t:pagetemplate>