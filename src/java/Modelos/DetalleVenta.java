package Modelos;

public class DetalleVenta {
    private int idDetalleVenta;
    private String idProductoVenta;
    private String nombreProductoVenta;
    private double precioProductoVenta;
    private int idVenta;
    private String fechaFacturaVenta;
    private String cedulaVenta;
    private String nombresUsuarioVenta;
    private String apellidosUsuarioVenta; 
    private int cantidadProducto;
    private double precioTotalVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, String idProductoVenta, String nombreProductoVenta, double precioProductoVenta, int idVenta, String fechaFacturaVenta, String cedulaVenta, String nombresUsuarioVenta, String apellidosUsuarioVenta, int cantidadProducto, double precioTotalVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.idProductoVenta = idProductoVenta;
        this.nombreProductoVenta = nombreProductoVenta;
        this.precioProductoVenta = precioProductoVenta;
        this.idVenta = idVenta;
        this.fechaFacturaVenta = fechaFacturaVenta;
        this.cedulaVenta = cedulaVenta;
        this.nombresUsuarioVenta = nombresUsuarioVenta;
        this.apellidosUsuarioVenta = apellidosUsuarioVenta;
        this.cantidadProducto = cantidadProducto;
        this.precioTotalVenta = precioTotalVenta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public String getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(String idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public String getNombreProductoVenta() {
        return nombreProductoVenta;
    }

    public void setNombreProductoVenta(String nombreProductoVenta) {
        this.nombreProductoVenta = nombreProductoVenta;
    }

    public double getPrecioProductoVenta() {
        return precioProductoVenta;
    }

    public void setPrecioProductoVenta(double precioProductoVenta) {
        this.precioProductoVenta = precioProductoVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaFacturaVenta() {
        return fechaFacturaVenta;
    }

    public void setFechaFacturaVenta(String fechaFacturaVenta) {
        this.fechaFacturaVenta = fechaFacturaVenta;
    }

    public String getCedulaVenta() {
        return cedulaVenta;
    }

    public void setCedulaVenta(String cedulaVenta) {
        this.cedulaVenta = cedulaVenta;
    }

    public String getNombresUsuarioVenta() {
        return nombresUsuarioVenta;
    }

    public void setNombresUsuarioVenta(String nombresUsuarioVenta) {
        this.nombresUsuarioVenta = nombresUsuarioVenta;
    }

    public String getApellidosUsuarioVenta() {
        return apellidosUsuarioVenta;
    }

    public void setApellidosUsuarioVenta(String apellidosUsuarioVenta) {
        this.apellidosUsuarioVenta = apellidosUsuarioVenta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioTotalVenta() {
        return precioTotalVenta;
    }

    public void setPrecioTotalVenta(double precioTotalVenta) {
        this.precioTotalVenta = precioTotalVenta;
    }

    
}
