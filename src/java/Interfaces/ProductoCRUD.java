package Interfaces;

import Modelos.Marca;
import Modelos.Producto;
import Modelos.Subcategoria;
import java.util.List;

public interface ProductoCRUD {
    public List listarProductos();
    public List listarMarcas();
    public List listarSubcategorias();
    public Producto listarProducto(String idProducto);
    public boolean agregarProducto(Producto prod);
    public boolean editarProducto(Producto prod);
    public boolean eliminarProducto(String idProducto);    
    public boolean agregarMarca(Marca marca);
    public boolean agregarSubcategoria(Subcategoria subcategoria);    
}
