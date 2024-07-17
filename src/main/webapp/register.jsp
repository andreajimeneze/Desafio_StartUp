<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
    <head>
        <%@ include file="assets/components/meta.jsp"%>
        <title>Registro Usuario</title>
    </head>
    <body>
    <%@ include file="assets/components/nav.jsp"%>
    <main class="container">
        <article >
            <h1>Registro de Usuario</h1>

            <form class="container-fluid" method="post" action="user?action=insert">
                <label for="name">Nombre</label>
                <input type="text" id="name" name="name" required>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
                <div class="grid">
                    <div class="col-8">
                        <label for="address">Dirección</label>
                        <input type="text" id="address" name="addressName">
                    </div>
                    <div class="col-4">
                        <label for="number">Número</label>
                        <input type="number" id="number" name="number">
                    </div>
                </div>
                <label for="nick">Nickname</label>
                <input type="text" id="nick" name="nick" required>
                <label for="password">Password</label>
                <input type="text" id="password" name="password" required>
                <label for="weight">Peso</label>
                <input type="number" id="weight" name="weight">
                <button type="submit">Registrar</button>
            </form>
        </article>
    </main>
    </body>
</html>
