<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Cart
    </jsp:attribute>

    <jsp:attribute name="footer">
            Cart
    </jsp:attribute>

    <jsp:body>

        <h3>You can view the status of your order here:</h3>

        <body>

        <table>
            <tr>
                <th>userID</th>
                <th>orderDate</th>
                <th>orderPrice</th>
                <th>bomID</th>
            </tr>


            <c:forEach items="${sessionScope.ordreList}" var="ordrelinjeValues">
                <tr>
                    <td><c:out value="${ordrelinjeValues.userID}" /></td>
                    <td><c:out value="${ordrelinjeValues.orderDate}" /></td>
                    <td><c:out value="${ordrelinjeValues.orderPrice}" /></td>
                    <td><c:out value="${ordrelinjeValues.bomID}" /></td>
                </tr>
            </c:forEach>

        </table>

        </body>




    </jsp:body>
</t:pagetemplate>