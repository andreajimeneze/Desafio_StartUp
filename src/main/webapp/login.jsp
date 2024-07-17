<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
    <head>
        <%@ include file="assets/components/meta.jsp"%>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Login</title>
    </head>
    <body>
    <%@ include file="assets/components/nav.jsp"%>

    <main class="container">
      <article >
            <h1>Login</h1>
            <form class="container-fluid w-50" action="user?action=compare" method="post">
                <fieldset>
                    <label> Correo electrónico
                        <input type="email" name="email" placeholder="Correo electrónico" autocomplete="given-name" required/>
                    </label>
                    <label> Contraseña
                        <input type="password" name="password" placeholder="Contraseña" autocomplete="password" required/>
                    </label>
                </fieldset>

                <input type="submit" value="Ingresar"/>
            </form>
      </article>
    </main>
    </body>
</html>
