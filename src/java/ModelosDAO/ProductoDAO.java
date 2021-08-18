/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.ProductoCRUD;
import Modelos.Marca;
import Modelos.Producto;
import Modelos.Subcategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanb
 */
public class ProductoDAO implements ProductoCRUD {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto p = new Producto();

    @Override
    public List listarProductos() {
        ArrayList<Producto> list = new ArrayList<>();
        String sql = "CALL sp_ObtenerProductos";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getString("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPresentacion(rs.getString("presentacion"));
                prod.setIdMarca(rs.getInt("id_marca"));
                prod.setNombreMarca(rs.getString("marca"));
                prod.setFechaVencimiento(rs.getString("fecha_vencimiento"));
                prod.setPrecioCompra(rs.getDouble("precio_compra"));
                prod.setPrecioVenta(rs.getDouble("precio_venta"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setIdSubcategoria(rs.getInt("id_subcategoria"));
                prod.setNombreSubcategoria(rs.getString("subcategoria"));
                prod.setIdProveedorProducto(rs.getString("id_proveedor"));
                prod.setNombreProveedorProducto(rs.getString("nombre_proveedor"));
                list.add(prod);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return list;
    }

    @Override
    public List listarMarcas() {
        ArrayList<Producto> marcas = new ArrayList<>();
        con = cn.getConexion();
        try {
            String consulta = "CALL sp_ListarMarca";
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto marca = new Producto();
                marca.setIdMarca(rs.getInt("id_marca"));
                marca.setNombreMarca(rs.getString("marca"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return marcas;
    }

    @Override
    public List listarSubcategorias() {
        ArrayList<Producto> subcategorias = new ArrayList<>();
        con = cn.getConexion();
        try {
            String consulta = "CALL sp_ListarSubcategoria";
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto subcategoria = new Producto();
                subcategoria.setIdSubcategoria(rs.getInt("id_subcategoria"));
                subcategoria.setNombreSubcategoria(rs.getString("subcategoria"));
                subcategorias.add(subcategoria);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return subcategorias;
    }

    @Override
    public Producto listarProducto(String idProducto) {
        String sql = "CALL sp_ObtenerProducto(?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, idProducto);
            rs = ps.executeQuery();            
            while (rs.next()) {
                p.setIdProducto(rs.getString("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPresentacion(rs.getString("presentacion"));
                p.setIdMarca(rs.getInt("id_marca"));
                p.setNombreMarca(rs.getString("marca"));
                p.setFechaVencimiento(rs.getString("fecha_vencimiento"));
                p.setPrecioCompra(rs.getDouble("precio_compra"));
                p.setPrecioVenta(rs.getDouble("precio_venta"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setIdSubcategoria(rs.getInt("id_subcategoria"));
                p.setNombreSubcategoria(rs.getString("subcategoria"));                
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return p;
    }

    @Override
    public boolean agregarProducto(Producto prod) {
        String sql = "CALL sp_IngresarProducto(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getIdProducto());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getDescripcion());
            ps.setString(4, prod.getPresentacion());
            ps.setInt(5, prod.getIdMarca());
            ps.setString(6, prod.getFechaVencimiento());
            ps.setDouble(7, prod.getPrecioCompra());
            ps.setDouble(8, prod.getPrecioVenta());
            ps.setInt(9, prod.getCantidad());
            ps.setInt(10, prod.getIdSubcategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }

    @Override
    public boolean editarProducto(Producto prod) {
        String sql = "UPDATE tbl_producto SET nombre='" + prod.getNombre() + "',descripcion='" + prod.getDescripcion() + "',presentacion='" + prod.getPresentacion() + "',id_marca=" + prod.getIdMarca() + ",fecha_vencimiento='" + prod.getFechaVencimiento() + "',precio_compra=" + prod.getPrecioCompra() + ",precio_venta=" + prod.getPrecioVenta() + ",cantidad=" + prod.getCantidad() + ",id_subcategoria=" + prod.getIdSubcategoria() + " WHERE id_producto='" + prod.getIdProducto() + "'";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(String idProducto) {
        String sql = "DELETE FROM tbl_producto WHERE id_producto='" + idProducto + "'";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }   

    @Override
    public boolean agregarMarca(Marca marca) {
        String sql = "CALL sp_AgregarMarca(null,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);           
            ps.setString(1, marca.getMarcaProducto());
            ps.executeUpdate();            
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;        
    }

    @Override
    public boolean agregarSubcategoria(Subcategoria subcategoria) {
        String sql = "CALL sp_AgregarSubcategoria(null,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, subcategoria.getNombreSubcategoriaProducto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }        

}
