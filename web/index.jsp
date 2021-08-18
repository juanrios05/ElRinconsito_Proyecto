<%-- 
    Document   : index
    Created on : 18/05/2021, 01:11:35 PM
    Author     : juanb
--%>

<%@page import="Controladores.ControladorServlet"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorServlet cp = new ControladorServlet();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style2.css">
        <title>Rinconcito</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo">El Rinconcito</a>
                </div>
                <div>
                    <a href="iniciosesion.jsp" title="Inicar Sesión"><i class="icono-index fa fa-sign-in"></i></a>
                    <a href="registro.jsp" title="Registrarse"><i class="icono-index fa fa-user-plus"></i></a>
                </div>
            </header>
            <main>
                <div>
                    <ul class="productos">
                        <%= cp.obtenerProductos() %>
                    </ul>
                </div>
            </main>
            <footer>All Rights Reserved @2021</footer>
        </div>
    </body>
</html>
