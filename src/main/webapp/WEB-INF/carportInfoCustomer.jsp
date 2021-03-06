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
        <c:if test="${sessionScope.user != null}">

        <h2 class="h2">Overview of your carport: </h2> <br>

        <table class="content-table">
            <thead>
            <tr>
                <th> Order ID:</th>
                <th> Order Price:</th>
                <th> Order Status:</th>
                <th> Carport Length:</th>
                <th> Carport Width:</th>
                <th> Rooftype:</th>
                <th> Toolshed Length:</th>
                <th> Toolshed Width:</th>
                <th> Delete order:</th>
                <th> See Sketch:</th>
                <th> See BOM list:</th>

            </tr>
            </thead>

            <c:forEach items="${sessionScope.carportDataList}" var="items">
                <tr>
                    <td> <c:out value="${items.order_id}"/></td>

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


                    <form action="deleteOrder" method="post">
                    <td><button type="submit" formaction="deleteOrder" name="delete" value="${items.order_id}">Delete order</button></td>
                    </form>

                    <form action="SVGServlet" method="post">
                        <td>
                        <button type="submit" formaction="SVGServlet" name="svg" value="${items.carportLengthCM}#${items.carportWidthCM}"  > See Sketch</button>

                        </td>
                    </form>

                    <form action="ShowBom" method="post">
                        <td>
                            <c:if test="${items.order_status == 1}">
                            <button type="submit" formaction="ShowBom" name="bom" value="${items.order_id}">Show BOM</button>
                            </c:if>
                            <c:if test="${items.order_status == 0}">
                                <c:out value="Pending"/>
                            </c:if>

                        </td>
                    </form>
                </tr>

            </c:forEach>






        </table>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Abandon ship. We have no idea how you ended up here!</p>
        </c:if>



    </jsp:body>

</t:pagetemplate>