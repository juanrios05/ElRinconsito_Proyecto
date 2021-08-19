<%-- 
    Document   : ventas
    Created on : 9/06/2021, 04:48:36 PM
    Author     : juanb
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.DetalleVenta"%>
<%@page import="ModelosDAO.DetalleVentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>        
        <script src="js/buscarregistro.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/style2.css">
        <title>Proveedores</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo" href="sesioniniciadaadministrador.jsp">El Rinconsito</a>
                </div>            
            </header>            
            <main>
                <a href="sesioniniciadaadministrador.jsp"><i class="fas fa-arrow-left icono-regresar" title="Regresar"></i></a>
                <div class="form-container">                    
                    <div class="tabla-producto">  
                        <input id="termino" type="text" onkeyup="buscar()" placeholder="Buscar..." />                            
                        <table id="datos" border="1">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Id Producto</th>
                                    <th>Nombre Producto</th>
                                    <th>Precio Venta</th>
                                    <th>Id Factura Venta</th>
                                    <th>Fecha Factura</th>
                                    <th>Cedula</th>
                                    <th>Nombre Usuario</th>
                                    <th>Apellido Usuario</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>                                                
                                </tr>
                            </thead>
                            <%
                                DetalleVentaDAO dao = new DetalleVentaDAO();
                                List<DetalleVenta> list = dao.listarVentas();
                                Iterator<DetalleVenta> iter = list.iterator();
                                DetalleVenta venta = null;
                                while (iter.hasNext()) {
                                    venta = iter.next();

                            %>
                            <tbody>
                                <tr>
                                    <td class="id-producto"><%= venta.getIdDetalleVenta()%></td>
                                    <td><%= venta.getIdProductoVenta()%></td>
                                    <td><%= venta.getNombreProductoVenta()%></td>                        
                                    <td><%= venta.getPrecioProductoVenta()%></td>
                                    <td><%= venta.getIdVenta()%></td>
                                    <td><%= venta.getFechaFacturaVenta()%></td>
                                    <td><%= venta.getCedulaVenta()%></td>
                                    <td><%= venta.getNombresUsuarioVenta()%></td>   
                                    <td><%= venta.getApellidosUsuarioVenta()%></td>   
                                    <td><%= venta.getCantidadProducto()%></td>   
                                    <td><%= venta.getPrecioTotalVenta()%></td>                           
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