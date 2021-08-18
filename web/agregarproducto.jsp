<%-- 
    Document   : agregarproducto
    Created on : 14/07/2021, 04:37:20 PM
    Author     : juanb
--%>

<%@page import="java.util.List"%>
<%@page import="Modelos.Producto"%>
<%@page import="ModelosDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>
        <script src="js/imagenproducto.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/style2.css">
        <title>Agregar Producto</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo">El Rinconcito</a>
                </div>            
            </header>            
            <main>
                <div class="form-container">
                    <div class="fomulario-producto">
                        <form action="Administrador" class="form-producto" id="ingresoproducto">
                            <ul class="form-items-producto">
                                <li>
                                    <h2>Agregar Producto</h2>
                                </li>
                                <li>
                                    <input type="text" placeholder="Id Producto..." name="idproducto" id="idproducto" required />
                                </li>                                
                                <li>
                                    <input type="text" placeholder="Nombre..." name="nombreproducto" id="nombreproducto" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Descripcion..." name="descripcionproducto" id="descripcionproducto" required />
                                </li>
                                <li>
                                    <input type="file" accept="image/*" onchange="ingresarImagen(this.files[0].name)" placeholder="Presentacion..." name="presentacionproducto" id="presentacionproductoId" required />
                                    <input type="hidden" placeholder="Presentacion..." name="nombreimagenproducto" id="nombreimagenId" required />
                                </li>
                                <li>
                                    <%
                                        ProductoDAO daoMarca = new ProductoDAO();
                                        List<Producto> marcas = daoMarca.listarMarcas();
                                    %> 
                                    <select name="marcaproducto" onfocus='this.size = 4;' onblur='this.size = 1;' onchange='this.size = 1; this.blur();'>
                                        <%
                                            for (Producto marca : marcas) {
                                        %>
                                        <option value="<%= marca.getIdMarca()%>"><%= marca.getNombreMarca()%></option>                                                                                                                                   
                                        <%}%>
                                    </select>
                                </li>
                                <li>
                                    <label>Fecha de Vencimiento</label>
                                    <input type="date" placeholder="Fecha Vencimineto..." name="vencimientoproducto" id="vencimientoproducto" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Precio Compra..." name="preciocompraproducto" id="preciocompraproducto" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Precio Venta..." name="precioventaproducto" id="precioventaproducto" required />
                                </li>
                                <li>
                                    <input type="text" placeholder="Cantidad en Stock..." name="cantidadproducto" id="cantidadproducto" required />
                                </li>
                                <li>  
                                    <%
                                        ProductoDAO dao = new ProductoDAO();
                                        List<Producto> subcategorias = dao.listarSubcategorias();
                                    %>
                                    <select name="subcategoriaproducto" onfocus='this.size = 4;' onblur='this.size = 1;' onchange='this.size = 1; this.blur();' >
                                        <%
                                            for (Producto subcategoria : subcategorias) {
                                        %>
                                        <option value="<%= subcategoria.getIdSubcategoria()%>"><%= subcategoria.getNombreSubcategoria()%></option>
                                        <%}%>
                                    </select>
                                </li>
                                <li>
                                    <input class="btn-agregarproducto" type="submit" value="Agregar" name="accion">                                    
                                </li>
                                <li>
                                    <a class="btn-cancelar" href="Administrador?accion=listarProducto">Cancelar</a>
                                </li>
                            </ul>
                        </form>
                        <a class="btn-nuevaopcion" href="Administrador?accion=nuevamarca">Nueva Marca</a>
                        <a class="btn-nuevaopcion" href="Administrador?accion=nuevasubcategoria">Nueva Sucategoría</a>
                    </div>                    
                </div>
            </main>
        </div>    
    </body>
</html>
