<%-- 
    Document   : editarproducto
    Created on : 14/07/2021, 06:48:04 PM
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
        <title>Editar Producto</title>
        <script>
            function mensaje() {
                alert("Por favor vuelva a seleccionar la marca y la subcategoría.");
            }
            mensaje();
        </script>
    </head>
    <body>
        <%
            ProductoDAO prodDAO = new ProductoDAO();
            String idProducto = (String) request.getAttribute("idprod");
            Producto p = (Producto) prodDAO.listarProducto(idProducto);
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
                        <form action="Administrador" class="form-producto" id="ingresoproducto">
                            <ul class="form-items-producto">
                                <li>
                                    <h2>Editar Producto</h2>
                                </li>
                                <li>
                                    <input type="text" placeholder="Id Producto..." name="idproducto" value="<%= p.getIdProducto()%>" id="idproducto" readonly required />                    
                                </li>                                
                                <li>
                                    <input type="text" placeholder="Nombre..." name="nombreproducto" value="<%= p.getNombre()%>" id="nombreproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <input type="text" placeholder="Descripcion..." name="descripcionproducto" value="<%= p.getDescripcion()%>" id="descripcionproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <input type="file" accept="image/*" onchange="ingresarImagen(this.files[0].name)" placeholder="Presentacion..." name="presentacionproducto" id="presentacionproductoId" />
                                    <input type="hidden" placeholder="Presentacion..." name="nombreimagenproducto" value="<%= p.getPresentacion()%>" id="nombreimagenId" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <%
                                        ProductoDAO daoMarca = new ProductoDAO();
                                        List<Producto> marcas = daoMarca.listarMarcas();
                                    %> 
                                    <select name="marcaproducto" value="<%= p.getIdMarca()%>" onfocus='this.size = 4;' onblur='this.size = 1;' onchange='this.size = 1; this.blur();'>
                                        <%
                                            for (Producto marca : marcas) {
                                        %>
                                        <option value="<%= marca.getIdMarca()%>"><%= marca.getNombreMarca()%></option>                                                                                                                                   
                                        <%}%>
                                        <input type="hidden" name="producto" value="" />
                                    </select>

                                </li>
                                <li>
                                    <label>Fecha de Vencimiento</label>
                                    <input type="date" placeholder="Fecha Vencimineto..." name="vencimientoproducto" value="<%= p.getFechaVencimiento()%>" id="vencimientoproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <input type="text" placeholder="Precio Compra..." name="preciocompraproducto" value="<%= p.getPrecioCompra()%>" id="preciocompraproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <input type="text" placeholder="Precio Venta..." name="precioventaproducto" value="<%= p.getPrecioVenta()%>" id="precioventaproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>
                                    <input type="text" placeholder="Cantidad en Stock..." name="cantidadproducto" value="<%= p.getCantidad()%>" id="cantidadproducto" required />
                                    <input type="hidden" name="producto" value="" />
                                </li>
                                <li>  
                                    <%
                                        ProductoDAO dao = new ProductoDAO();
                                        List<Producto> subcategorias = dao.listarSubcategorias();
                                    %>
                                    <select name="subcategoriaproducto" value="<%= p.getIdSubcategoria()%>" onfocus='this.size = 4;' onblur='this.size = 1;' onchange='this.size = 1; this.blur();' >
                                        <%
                                            for (Producto subcategoria : subcategorias) {
                                        %>
                                        <option value="<%= subcategoria.getIdSubcategoria()%>"><%= subcategoria.getNombreSubcategoria()%></option>                        
                                        <%}%>
                                        <input type="hidden" name="producto" value="" />                        
                                    </select>     

                                </li>
                                <li>
                                    <input class="btn-agregarproducto" type="submit" value="Actualizar" name="accion">                                    
                                </li>
                                <li>
                                    <a class="btn-cancelar" href="Administrador?accion=listarProducto">Cancelar</a>
                                </li>
                            </ul>
                        </form>                        
                    </div>                    
                </div>
            </main>
        </div>   
    </body>
</html>
