<%-- 
    Document   : carritoCompras
    Created on : 18/08/2021, 02:15:51 PM
    Author     : juanb
--%>

<%@page import="Modelos.Carrito"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style2.css">
        <title>Carrito compras</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">        
    </head>
    <body>       
        <header>
            <div>

                <a class="logo" href="sesioniniciada.jsp">El Rinconsito</a>
            </div>

        </header>
        <div class="container mt-4">

            <%
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = new GregorianCalendar();

                int dia = c2.get(Calendar.DAY_OF_MONTH);
                int mes = c2.get(Calendar.MONTH);
                int annio = c2.get(Calendar.YEAR);
                int hora = c2.get(Calendar.HOUR_OF_DAY);
                int minuto = c2.get(Calendar.MINUTE);
                int segundo = c2.get(Calendar.SECOND);

                String fechaI1 = annio + "-" + (mes + 1) + "-" + dia;

                out.println("<h4>fecha: " + fechaI1 + "</h4>");

            %>

            <div class="row" class="text-center">  

                <h2 class="th" style='text-align:center'>CARRITO COMPRAS</h2>
                <div class="col-lg-8">                 
                    <table border="8" class="table">
                        <thead class="thead-light">
                            <tr class="text-center">
                                <th>Item</th>                               
                                <th>Articulo</th>
                                <th>Descripcion</th>
                                <th>Cantidad</th> 
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% Carrito carrito = (Carrito) request.getAttribute("carrito");
                                double total = 0;
                                for (int i = 0; i < carrito.getListaProductos().size(); i++) {
                                    out.println("<tr>"
                                            + "<td style='text-align:center'>" + carrito.getListaProductos().get(i).getNombre() + "</td>"
                                            + "<td style='text-align:center'><img src= 'img/" + carrito.getListaProductos().get(i).getPresentacion() + "  ' class=\"imagen-carrito2\"></td>"
                                            + "<td style='text-align:center'>" + carrito.getListaProductos().get(i).getDescripcion() + "</td>"
                                            + "<td style='text-align:center'> 1 </td>"
                                            + "<td style='text-align:center'>" + carrito.getListaProductos().get(i).getPrecioCompra() + "</td>"
                                            + "</tr>");
                                    total += carrito.getListaProductos().get(i).getPrecioCompra();
                                    ;
                                }
                                request.setAttribute("carrito", carrito);
                            %>
                        </tbody>
                    </table>                    
                </div>
                <div class="col-lg-3">                  
                    <div class="card">
                        <div class="card-header">
                            Generar Compra
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <%out.println("<a class='form-control text-center'><i class='fas fa-dollar-sign h5'> " + total + "</i></a>");%>
                            <label>Total a Pagar:</label>
                            <%out.println("<a class='form-control text-center'><i class='fas fa-dollar-sign h4' primary> " + total + "</i></a>");%>
                        </div>
                        <div class="card-footer">

                            <a href="#" data-toggle="modal" data-target="#myModalPago" class="btn btn-info btn-block form-control text-center">Realizar Pago</a>

                            <form method="POST" action="Controlador">                           
                                <button type="submit" id="PresentacionPDF" name="accion" value="realizarPago" class="btn btn-danger" >Factura compra pdf </i></button>
                            </form>
                        </div>
                    </div>
                </div> 
            </div>          
        </div>                
        <div class="modal fade" id="myModalPago" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">         
                <div class="modal-content">                   
                    <div class="modal-header text-center"> 
                        <label><i class="fa-dollar-sign">PAGO REALIZADO</i></label>
                        <button type="button" class="close" data-dismiss="modal" >
                            <span aria-hidden="true">&times;</span>
                        </button>  
                    </div>

                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
