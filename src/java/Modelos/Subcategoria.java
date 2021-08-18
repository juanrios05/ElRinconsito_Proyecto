package Modelos;

public class Subcategoria {
    private int idSubcategoriaProducto;
    private String nombreSubcategoriaProducto;

    public Subcategoria() {
    }

    public Subcategoria(int idSubcategoriaProducto, String nombreSubcategoriaProducto) {
        this.idSubcategoriaProducto = idSubcategoriaProducto;
        this.nombreSubcategoriaProducto = nombreSubcategoriaProducto;
    }

    public int getIdSubcategoriaProducto() {
        return idSubcategoriaProducto;
    }

    public void setIdSubcategoriaProducto(int idSubcategoriaProducto) {
        this.idSubcategoriaProducto = idSubcategoriaProducto;
    }

    public String getNombreSubcategoriaProducto() {
        return nombreSubcategoriaProducto;
    }

    public void setNombreSubcategoriaProducto(String nombreSubcategoriaProducto) {
        this.nombreSubcategoriaProducto = nombreSubcategoriaProducto;
    }
}
