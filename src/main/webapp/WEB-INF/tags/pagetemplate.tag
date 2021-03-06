<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div id="page-container">
<header >
    <a href="${pageContext.request.contextPath}/index.jsp">
    <img class="logo" src="images/fog-logo.png" width="200px;" alt="logo">
    </a>
    <nav >
        <ul class="nav_links">
            <c:if test="${sessionScope.user != null }">
                <li><a href="${pageContext.request.contextPath}/createCarport">Create carport</a></li>
            <li><a href="${pageContext.request.contextPath}/carportCustomer">Your carport</a></li>
            </c:if>
            <c:if test="${sessionScope.user == null }">
            <li><a href="${pageContext.request.contextPath}/createUser">Create account</a></li>
            </c:if>

            <c:if test="${sessionScope.user == null }">
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            </c:if>

            <c:if test="${sessionScope.user.role == 'admin' }">
                <li><a href="${pageContext.request.contextPath}/carportAdmin">Admin</a></li>
            </c:if>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>

            <c:if test="${sessionScope.user != null }">
                <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                <li><a>${sessionScope.user.email}</a></li>
            </c:if>

        </ul>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 675px;">
    <h1><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<footer>
    <p>Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - All prices include VAT</p>

</footer>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</div>
</body>
</html>