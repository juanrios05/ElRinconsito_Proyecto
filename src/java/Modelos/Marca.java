package Modelos;

public class Marca {

    private int idMarcaProducto;
    private String marcaProducto;

    public Marca() {
    }

    public Marca(int idMarcaProducto, String marcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
        this.marcaProducto = marcaProducto;
    }

    public int getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(int idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }
}
