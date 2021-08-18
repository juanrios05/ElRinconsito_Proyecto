package Interfaces;

import Modelos.Proveedor;
import java.util.List;

public interface ProveedorCRUD {
    public List listarProovedores();
    public Proveedor listarProveedor(String idProveedor);
    public boolean agregarProveedor(Proveedor prov);
    public boolean editarProveedor(Proveedor prov);
    public boolean eliminarProveedor(String idProveedor);   
}
