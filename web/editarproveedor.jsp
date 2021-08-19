<%-- 
    Document   : editarproveedor
    Created on : 14/07/2021, 11:48:46 PM
    Author     : juanb
--%>

<%@page import="Modelos.Proveedor"%>
<%@page import="ModelosDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="css/style2.css">
        <title>Editar Proveedor</title>
    </head>
    <body>
        <%
            ProveedorDAO provDAO = new ProveedorDAO();
            String idProveedor = (String) request.getAttribute("idprov");
            Proveedor pv = (Proveedor) provDAO.listarProveedor(idProveedor);
        %>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo">El Rinconsito</a>
                </div>            
            </header>            
            <main>
                <div class="form-container">
                    <div class="fomulario-producto">
                        <form action="Administrador" class="form-producto">
                            <ul class="form-items-producto">
                                <li>
                                    <h2>Editar Proveedor</h2>
                                </li>
                                <li>
                                    <input type="text" placeholder="Id Producto..." name="idproveedor" value="<%= pv.getIdProveedor()%>" id="idproveedor" readonly required />
                                </li>                                
                                <li>
                                    <input type="text" placeholder="Nombre..." name="nombreproveedor" value="<%= pv.getNombreProveedor()%>" id="nombreproveedor" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Teléfono..." name="telefonoproveedor" value="<%= pv.getTelefonoProveedor()%>" id="telefonoproveedor" required />
                                </li>                               
                                <li>
                                    <input type="email" placeholder="Correo..." name="correoproveedor" value="<%= pv.getCorreoProveedor()%>" id="correoproveedor" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Dirección..." name="direccionproveedor" value="<%= pv.getDireccionProveedor()%>" id="direccionproveedor" required />
                                </li>                              
                                <li>
                                    <input class="btn-agregarproducto" type="submit" value="Actualizar Proveedor" name="accion">                                    
                                </li>
                                <li>
                                    <a class="btn-cancelar" href="Administrador?accion=listarProveedor">Cancelar</a>
                                </li>
                            </ul>
                        </form>                        
                    </div>                    
                </div>
            </main>
        </div>
    </body>
</html>
