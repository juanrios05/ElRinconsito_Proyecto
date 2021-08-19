<%-- 
    Document   : sesioniniciadaadministrador
    Created on : 25/05/2021, 06:44:04 PM
    Author     : juanb
--%>

<%@page import="Controladores.ControladorServlet"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorServlet cp = new Controladores.ControladorServlet();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style2.css">
        <script src="js/menudesplegable.js" type="text/javascript"></script>
        <title>Administrador</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo">El Rinconsito</a>
                </div>       
                <strong>|</strong>
                <div>
                    <a href="Administrador?accion=listarProducto">Productos</a>
                </div>
                <strong>|</strong>
                <div>
                    <a href="Administrador?accion=listarProveedor">Proveedores</a>
                </div>
                <strong>|</strong>
                <div>
                    <a href="Administrador?accion=listarVentas">Ventas</a>
                </div>
                <strong>|</strong>
                <div>
                    <a href="informes.jsp">Informes</a>
                </div>
                <strong>|</strong>
                <div>
                    <a href="Administrador?accion=copiaSeguridadBaseDatos">Base de Datos</a>
                </div>
                <strong>|</strong>
                <div class="dropdown">                    
                    <form method="post" action="Validar">
                        <button class="danger" type="submit" name="accion" value="Salir">Cerrar Sesion</button>
                    </form>                                        
                </div>
            </header>
            <main>
                <div>
                    <ul class="productos">
                        <%= cp.obtenerProductos()%>
                    </ul>
                </div>
            </main>
            <footer>All Rights Reserved @2021</footer>
        </div>
    </body>
</html>
