/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Marca;
import Modelos.Producto;
import Modelos.Proveedor;
import Modelos.Subcategoria;
import ModelosDAO.ProductoDAO;
import ModelosDAO.ProveedorDAO;
import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanb
 */
public class Administrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String inicio = "sesioniniciadaadministrador.jsp";
    String listarProducto = "productos.jsp";
    String agregarProducto = "agregarproducto.jsp";
    String editarProducto = "editarproducto.jsp";
    String agregarMarca = "agregarmarca.jsp";
    String agregarSubcategoria = "agregarsubcategoria.jsp";
    String listarProveedor = "proveedores.jsp";
    String agregarProveedor = "agregarproveedor.jsp";
    String editarProveedor = "editarproveedor.jsp";
    String listarVentas = "ventas.jsp";
    String respaldarBD = "respaldobd.jsp";
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Marca marcas = new Marca();
    Subcategoria subcategorias = new Subcategoria();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    String idProd;
    String idProv;
    Modelos.Usuario usuario = new Modelos.Usuario();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    public String obtenerProductos() {
        ProductoDAO pd = new ProductoDAO();
        String htmlCode = "";
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
        for (Iterator it = pd.listarProductos().iterator(); it.hasNext();) {
            Producto productos = (Producto) it.next();
            htmlCode += "<li>\n"
                    + "                            <div class=\"producto\">\n"
                    + "                                    <a href=\"Controlador?id=" + productos.getIdProducto() + "\">\n"
                    + "                                        <img src=\"img/" + productos.getPresentacion() + "\" alt=" + productos.getNombre() + ">\n"
                    + "                                    </a>\n"
                    + "                                    <div class=\"nombre-producto\">\n"
                    + "                                        " + productos.getNombre() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"descripcion-producto\">\n"
                    + "                                        " + productos.getDescripcion() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"marca-producto\">\n"
                    + "                                        " + productos.getNombreMarca() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"precio-producto\">\n"
                    + "                                        " + formatoImporte.format(productos.getPrecioVenta()) + "\n"
                    + "                                    </div>\n"
                    + "                            </div>\n"
                    + "                        </li>";
        }
        return htmlCode;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("listarProducto")) {
            acceso = listarProducto;
            request.setAttribute("usuario", usuario);
        } else if (accion.equalsIgnoreCase("agregarProducto")) {
            acceso = agregarProducto;
        } else if (accion.equalsIgnoreCase("Agregar")) {
            String idProducto = request.getParameter("idproducto");
            String nombre = request.getParameter("nombreproducto");
            String descripcion = request.getParameter("descripcionproducto");
            String presentacion = request.getParameter("nombreimagenproducto");
            int marca = Integer.parseInt(request.getParameter("marcaproducto"));
            Date fechaVencimiento = Date.valueOf(request.getParameter("vencimientoproducto"));
            double precioCompra = Double.parseDouble(request.getParameter("preciocompraproducto"));
            double precioVenta = Double.parseDouble(request.getParameter("precioventaproducto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
            int subcategoria = Integer.parseInt(request.getParameter("subcategoriaproducto"));
            producto.setIdProducto(idProducto);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPresentacion(presentacion);
            producto.setIdMarca(marca);
            producto.setFechaVencimiento(fechaVencimiento.toString());
            producto.setPrecioCompra(precioCompra);
            producto.setPrecioVenta(precioVenta);
            producto.setCantidad(cantidad);
            producto.setIdSubcategoria(subcategoria);
            productoDAO.agregarProducto(producto);
            acceso = listarProducto;
        } else if (accion.equalsIgnoreCase("editarProducto")) {
            request.setAttribute("idprod", request.getParameter("idProducto"));
            acceso = editarProducto;
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            idProd = request.getParameter("idproducto");
            String nombre = request.getParameter("nombreproducto");
            String descripcion = request.getParameter("descripcionproducto");
            String presentacion = request.getParameter("nombreimagenproducto");
            int marca = Integer.parseInt(request.getParameter("marcaproducto"));
            Date fechaVencimiento = Date.valueOf(request.getParameter("vencimientoproducto"));
            double precioCompra = Double.parseDouble(request.getParameter("preciocompraproducto"));
            double precioVenta = Double.parseDouble(request.getParameter("precioventaproducto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
            int subcategoria = Integer.parseInt(request.getParameter("subcategoriaproducto"));
            producto.setIdProducto(idProd);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPresentacion(presentacion);
            producto.setIdMarca(marca);
            producto.setFechaVencimiento(fechaVencimiento.toString());
            producto.setPrecioCompra(precioCompra);
            producto.setPrecioVenta(precioVenta);
            producto.setCantidad(cantidad);
            producto.setIdSubcategoria(subcategoria);
            productoDAO.editarProducto(producto);
            acceso = listarProducto;
        } else if (accion.equalsIgnoreCase("nuevamarca")) {
            acceso = agregarMarca;
        } else if (accion.equalsIgnoreCase("Agregar Marca")) {
            String marcaProducto = request.getParameter("nombremarca");
            marcas.setMarcaProducto(marcaProducto);
            productoDAO.agregarMarca(marcas);
            acceso = agregarProducto;
        } else if (accion.equalsIgnoreCase("nuevasubcategoria")) {
            acceso = agregarSubcategoria;
        } else if (accion.equalsIgnoreCase("Agregar Subcategoria")) {
            String subcategoriaProducto = request.getParameter("nombresubcategoria");
            subcategorias.setNombreSubcategoriaProducto(subcategoriaProducto);
            productoDAO.agregarSubcategoria(subcategorias);
            acceso = agregarProducto;
        } else if (accion.equalsIgnoreCase("eliminarProducto")) {
            idProd = request.getParameter("idProducto");
            producto.setIdProducto(idProd);
            productoDAO.eliminarProducto(idProd);
            acceso = listarProducto;
        } else if (accion.equalsIgnoreCase("inicio")) {
            acceso = inicio;
        } else if (accion.equalsIgnoreCase("listarProveedor")) {
            acceso = listarProveedor;
        } else if (accion.equalsIgnoreCase("agregarProveedor")) {
            acceso = agregarProveedor;
        } else if (accion.equalsIgnoreCase("Agregar Proveedor")) {
            String idProveedor = request.getParameter("idproveedor");
            String nombreProveedor = request.getParameter("nombreproveedor");
            String telefonoProveedor = request.getParameter("telefonoproveedor");
            String correoProveedor = request.getParameter("correoproveedor");
            String direccionProveedor = request.getParameter("direccionproveedor");
            proveedor.setIdProveedor(idProveedor);
            proveedor.setNombreProveedor(nombreProveedor);
            proveedor.setTelefonoProveedor(telefonoProveedor);
            proveedor.setCorreoProveedor(correoProveedor);
            proveedor.setDireccionProveedor(direccionProveedor);
            proveedorDAO.agregarProveedor(proveedor);
            acceso = listarProveedor;
        } else if (accion.equalsIgnoreCase("editarProveedor")) {
            request.setAttribute("idprov", request.getParameter("idProveedor"));
            acceso = editarProveedor;
        } else if (accion.equalsIgnoreCase("Actualizar Proveedor")) {
            idProv = request.getParameter("idproveedor");
            String nombreProveedor = request.getParameter("nombreproveedor");
            String telefonoProveedor = request.getParameter("telefonoproveedor");
            String correoProveedor = request.getParameter("correoproveedor");
            String direccionProveedor = request.getParameter("direccionproveedor");
            proveedor.setIdProveedor(idProv);
            proveedor.setNombreProveedor(nombreProveedor);
            proveedor.setTelefonoProveedor(telefonoProveedor);
            proveedor.setCorreoProveedor(correoProveedor);
            proveedor.setDireccionProveedor(direccionProveedor);
            proveedorDAO.editarProveedor(proveedor);
            acceso = listarProveedor;
        } else if (accion.equalsIgnoreCase("eliminarProveedor")) {
            idProv = request.getParameter("idProveedor");
            proveedor.setIdProveedor(idProv);
            proveedorDAO.eliminarProveedor(idProv);
            acceso = listarProveedor;
        } else if (accion.equalsIgnoreCase("listarVentas")) {
            acceso = listarVentas;
        } else if (accion.equalsIgnoreCase("copiaSeguridadBaseDatos")) {
            acceso = respaldarBD;
        } 
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
