package Controladores;

import Modelos.Carrito;
import Modelos.Producto;
import ModelosDAO.ProductoDAO;
import Modelos.Usuario;
import ModelosDAO.UsuarioDAO;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanb
 */
@MultipartConfig
public class ControladorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();

    String idProducto;
    
    Carrito carrito = new Carrito();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductoDAO productoDao = new ProductoDAO();
        List<Producto> listaProductos = new ArrayList<>();
        
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (accion.equals("verCarrito")) {
            request.setAttribute("carrito", carrito);
            request.getRequestDispatcher("carritoCompras.jsp").forward(request, response);
        }

        if (accion.equals("realizarPago")) {
            request.setAttribute("carrito", carrito);
            request.getRequestDispatcher("Factura").forward(request, response);
        }

        if (accion.equals("agregarCarrito")) {
            String idProducto = request.getParameter("idProducto");
            Producto producto = productoDao.listarProducto(idProducto);
            carrito.getListaProductos().add(producto);
            carrito.setCantidadProductos(carrito.getListaProductos().size());
            request.setAttribute("contador", carrito.getListaProductos().size());
            request.getRequestDispatcher("sesioniniciada.jsp").forward(request, response);
        }

        if (menu != null) {

            if (menu.equals("Principal")) {
                request.getRequestDispatcher("sesioniniciada.jsp").forward(request, response);
            }

            if (menu.equals("PrincipalAdministrador")) {
                request.getRequestDispatcher("sesioniniciadaadministrador.jsp").forward(request, response);
            }

            if (menu.equals("Registro")) {
                if (accion.equals("Registrarse")) {
                    String cedula = request.getParameter("cedula");
                    String nombres = request.getParameter("nombres");
                    String apellidos = request.getParameter("apellidos");
                    String telefono = request.getParameter("telefono");
                    String direccion = request.getParameter("direccion");
                    String correo = request.getParameter("correo");
                    String clave = request.getParameter("clave");
                    String confirmarClave = request.getParameter("confirmarClave");
                    String perfilUsuario = "2";
                    usuario.setCedula(cedula);
                    usuario.setNombres(nombres);
                    usuario.setApellidos(apellidos);
                    usuario.setTelefono(telefono);
                    usuario.setDireccion(direccion);
                    usuario.setCorreo(correo);
                    usuario.setClave(clave);
                    usuario.setPerfilUsuario(perfilUsuario);
                    usuarioDao.registroUsuario(usuario);
                    request.getRequestDispatcher("iniciosesion.jsp").forward(request, response);
                }
            }
        }
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
                    + "                                        <img src=\"img/" + productos.getPresentacion() + "\" width=\"500px\" alt=\"" + productos.getNombre() + "\">\n"
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

    public String obtenerProductosUsuario() {
        ProductoDAO pd = new ProductoDAO();
        String htmlCode = "";
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
        for (Iterator it = pd.listarProductos().iterator(); it.hasNext();) {
            Producto producto = (Producto) it.next();
            htmlCode += "<li>\n"
                    + "                            <div class=\"producto\">\n"
                    + "                                    <a href=\"Controlador?id=" + producto.getIdProducto() + "\">\n"
                    + "                                        <img src=\"img/" + producto.getPresentacion() + "\" alt=\"Arroz Diana\">\n"
                    + "                                    </a>\n"
                    + "                                    <div class=\"nombre-producto\">\n"
                    + "                                        " + producto.getNombre() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"descripcion-producto\">\n"
                    + "                                        " + producto.getDescripcion() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"marca-producto\">\n"
                    + "                                        " + producto.getNombreMarca() + "\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"precio-producto\">\n"
                    + "                                        " + formatoImporte.format(producto.getPrecioVenta()) + "\n"
                    + "                                    </div>\n"
                    + "                                     <div class=\"precio-producto\"> <a class=\"agregarcarritoboton\" href=\"Controlador?accion=agregarCarrito&idProducto=" + producto.getIdProducto() + "\">Agregar al carrito <i class=\"fas fa-cart-plus\"></i> </a>\n"
                    + "                                       "
                    + "                                    </div>\n"
                    + "                                    </div>\n"
                    + " </li>";
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
        processRequest(request, response);
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
