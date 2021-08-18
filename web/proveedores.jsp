<%-- 
    Document   : proveedores
    Created on : 14/07/2021, 11:26:51 PM
    Author     : juanb
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelos.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="ModelosDAO.ProveedorDAO"%>
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
                    <a class="logo" href="sesioniniciadaadministrador.jsp">El Rinconcito</a>
                </div>            
            </header>            
            <main>
                <a href="sesioniniciadaadministrador.jsp"><i class="fas fa-arrow-left icono-regresar" title="Regresar"></i></a>
                <div class="form-container">                    
                    <div class="tabla-producto">
                        <input id="termino" type="text" onkeyup="buscar()" placeholder="Buscar..." />  
                        <a href="Administrador?accion=agregarProveedor"><i class="far fa-plus-square" title="Nuevo..."></i></a>                                                
                        <table id="datos" border="1">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Telefono</th>
                                    <th>Correo</th>
                                    <th>Direccion</th>
                                    <th>Accion</th>                        
                                </tr>
                            </thead>
                            <%
                                ProveedorDAO dao = new ProveedorDAO();
                                List<Proveedor> list = dao.listarProovedores();
                                Iterator<Proveedor> iter = list.iterator();
                                Proveedor prov = null;
                                while (iter.hasNext()) {
                                    prov = iter.next();

                            %>
                            <tbody>
                                <tr>
                                    <td class="id-producto"><%= prov.getIdProveedor()%></td>
                                    <td><%= prov.getNombreProveedor()%></td>
                                    <td><%= prov.getTelefonoProveedor()%></td>                        
                                    <td><%= prov.getCorreoProveedor()%></td>
                                    <td><%= prov.getDireccionProveedor()%></td>                        
                                    <td>
                                        <a href="Administrador?accion=editarProveedor&idProveedor=<%= prov.getIdProveedor()%>"><i class="far fa-edit" title="Editar"></i></a>
                                        <a href="Administrador?accion=eliminarProveedor&idProveedor=<%= prov.getIdProveedor()%>"><i class="far fa-trash-alt" title="Eliminar"></i></a>
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

