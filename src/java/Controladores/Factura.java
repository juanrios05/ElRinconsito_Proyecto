package Controladores;

import Modelos.Carrito;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Factura extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        try {

            Carrito carrito = (Carrito) request.getAttribute("carrito");
            Document documento = new Document() {
            };
            PdfWriter.getInstance(documento, out);
            documento.open();
            Rectangle one = new Rectangle(700, 400);
            documento.setPageSize(one);
            documento.setMargins(20, 8, 8, 8);

            documento.add(new Paragraph("FACTURA COMPRA"));
            documento.add(new Paragraph());

            //documento.add(new Paragraph("Este es el segundo y tiene una fuente rara", FontFactory.getFont("arial", // fuente
            // 22, // tamaño
            //Font.ITALIC, // estilo
            // BaseColor.CYAN)));
            // color
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Item");
            tabla.addCell("Articulo");
            tabla.addCell("Descripcion");
            tabla.addCell("cantidad");
            tabla.addCell("total");

            double total = 0;
            double preciocompra = 0;

            for (int i = 0; i <= carrito.getListaProductos().size() - 1; i++) {
                tabla.addCell(carrito.getListaProductos().get(i).getNombre());
                tabla.addCell(carrito.getListaProductos().get(i).getPresentacion());
                tabla.addCell(carrito.getListaProductos().get(i).getDescripcion());
                tabla.addCell("1");
                preciocompra = carrito.getListaProductos().get(i).getPrecioCompra();
                String precio = String.valueOf(preciocompra);
                tabla.addCell(precio);
                total += carrito.getListaProductos().get(i).getPrecioCompra();

            }

            documento.add(tabla);
            documento.close();

        } catch (Exception e) {
            System.out.print(e);
        }
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
