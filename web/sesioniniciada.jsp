<%-- 
    Document   : sesioniniciada
    Created on : 18/05/2021, 03:59:38 PM
    Author     : juanb
--%>

<%@page import="Modelos.Producto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="ModelosDAO.ProductoDAO"%>
<%@page import="Controladores.ControladorServlet" %>
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
        <title>Rinconcito</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo" >El Rinconcito</a>
                </div>
                <div>
                    <a href="Controlador?accion=verCarrito" title="Carrito"><i class="fas fa-shopping-cart">(<label style="color: #41df41">${contador}</label>)</i></a>
                </div>
                <div class="dropdown">                    
                    <form method="post" action="Validar">
                        <button class="danger" type="submit" name="accion" value="Salir">Cerrar Sesion</button>
                    </form>                                        
                </div>
             
            </header>
            <main>
                <div>
                    <ul class="productos">
                        <%= cp.obtenerProductosUsuario()%>
                    </ul>
                </div>
            </main>
            <footer>All Rights Reserved @2021</footer>
        </div>
    </body>
</html>
