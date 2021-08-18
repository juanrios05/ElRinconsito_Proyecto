<%-- 
    Document   : productos
    Created on : 9/06/2021, 04:48:17 PM
    Author     : juanb
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModelosDAO.ProductoDAO"%>
<%@page import="Modelos.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="css/style2.css">
        <script src="js/buscarregistro.js" type="text/javascript"></script>
        <title>Productos</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo" href="sesioniniciadaadministrador.jsp">El Rinconcito</a>                    
                </div>                  
            </header>            
            <main>                
                <a href="sesioniniciadaadministrador.jsp"><i class="fas fa-arrow-left icono-regresar" title="Regresar"></i></a>                
                <div class="form-container">                         
                    <div class="tabla-producto">
                        <% // Cuadro de busqueda  %>
                        <input id="termino" type="text" onkeyup="buscar()" placeholder="Buscar..." />                            
                        <a href="Administrador?accion=agregarProducto"><i class="far fa-plus-square" title="Nuevo Producto..."></i></a>                       
                        <table id="datos" border="1">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Presentacion</th>
                                    <th>Marca</th>
                                    <th>Fecha Vencimiento</th>
                                    <th>Precio Compra</th>
                                    <th>Precio Venta</th>
                                    <th>Stock</th>
                                    <th>Subcategoria</th>
                                    <th>Proveedor</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <%
                                ProductoDAO dao = new ProductoDAO();
                                List<Producto> list = dao.listarProductos();
                                Iterator<Producto> iter = list.iterator();
                                Producto prod = null;
                                while (iter.hasNext()) {
                                    prod = iter.next();

                            %>
                            <tbody>
                                <tr>
                                    <td class="id-producto"><%= prod.getIdProducto()%></td>
                                    <td><%= prod.getNombre()%></td>
                                    <td><%= prod.getDescripcion()%></td>
                                    <td><img src="img/<%= prod.getPresentacion()%>" width="75px" ></td>
                                    <td><%= prod.getNombreMarca()%></td>
                                    <td><%= prod.getFechaVencimiento()%></td>
                                    <td><%= prod.getPrecioCompra()%></td>
                                    <td><%= prod.getPrecioVenta()%></td>
                                    <td><%= prod.getCantidad()%></td>
                                    <td><%= prod.getNombreSubcategoria()%></td>
                                    <td><%= prod.getNombreProveedorProducto()%></td>
                                    <td>
                                        <a href="Administrador?accion=editarProducto&idProducto=<%= prod.getIdProducto()%>"><i class="far fa-edit" title="Editar"></i></a>
                                        <a href="Administrador?accion=eliminarProducto&idProducto=<%= prod.getIdProducto()%>"><i class="far fa-trash-alt" title="Eliminar"></i></a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </div>    
    </body>
</html>
