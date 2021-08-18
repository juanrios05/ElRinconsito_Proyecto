package Modelos;

public class Producto {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private String presentacion;
    private int idMarca;
    private String nombreMarca;
    private String fechaVencimiento;
    private double precioCompra;
    private double precioVenta;    
    private int cantidad;
    private int idSubcategoria;      
    private String nombreSubcategoria;
    private String idProveedorProducto;
    private String nombreProveedorProducto;

    public Producto() {
    }

    public Producto(String idProducto, String nombre, String descripcion, String presentacion, int idMarca, String nombreMarca, String fechaVencimiento, double precioCompra, double precioVenta, int cantidad, int idSubcategoria, String nombreSubcategoria, String idProveedorProducto, String nombreProveedorProducto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.fechaVencimiento = fechaVencimiento;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.idSubcategoria = idSubcategoria;
        this.nombreSubcategoria = nombreSubcategoria;
        this.idProveedorProducto = idProveedorProducto;
        this.nombreProveedorProducto = nombreProveedorProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombreSubcategoria() {
        return nombreSubcategoria;
    }

    public void setNombreSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public String getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(String idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public String getNombreProveedorProducto() {
        return nombreProveedorProducto;
    }

    public void setNombreProveedorProducto(String nombreProveedorProducto) {
        this.nombreProveedorProducto = nombreProveedorProducto;
    }

       

}
