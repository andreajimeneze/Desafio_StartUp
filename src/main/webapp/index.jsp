<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
    <head>

        <title>Bienvenida</title>
        <%@ include file="assets/components/meta.jsp"%>
    </head>
    <body>
    <%@ include file="assets/components/nav.jsp"%>

        <main class="container">
            <h1>Usuarios</h1>
            <br/>
            <h4>Bienvenid@s a la página de registro y login de usuarios</h4>

            <div class="container-fluid">
                <button class="btn outline secondary"><a href="user?action=register">Registrarse</a></button>
                <button class="btn outline"><a href="user?action=login">Ingresar</a></button>
            </div>
        </main>
    </body>
</html>