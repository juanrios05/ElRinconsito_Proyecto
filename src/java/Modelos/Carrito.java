package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> listaProductos = new ArrayList<>();
    private int cantidadProductos;
    private int total;

    public Carrito() {
    }

    public Carrito(int cantidadProductos, int total) {
        this.cantidadProductos = cantidadProductos;
        this.total = total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
