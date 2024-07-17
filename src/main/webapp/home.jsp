<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <%@ include file="assets/components/meta.jsp"%>
    <title>Dashboard</title>
</head>
<body>
<%@ include file="assets/components/nav.jsp"%>
<main class="container">
    <h1>Bienvenido, ${user.nick}</h1>
    <p>Nombre:  ${user.name}</p>
    <p>Ha ingresado correctamente con el correo ${user.email}</p>
</main>
</body>
</html>
