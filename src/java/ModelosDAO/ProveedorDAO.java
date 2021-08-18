/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.ProveedorCRUD;
import Modelos.Proveedor;
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
public class ProveedorDAO implements ProveedorCRUD{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Proveedor pvdor = new Proveedor();

    @Override
    public List listarProovedores() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String sql = "CALL sp_ObtenerProveedores";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(rs.getString("id_proveedor"));
                prov.setNombreProveedor(rs.getString("nombre_proveedor"));
                prov.setTelefonoProveedor(rs.getString("telefono"));
                prov.setCorreoProveedor(rs.getString("correo"));
                prov.setDireccionProveedor(rs.getString("direccion"));
                list.add(prov);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return list;
    }

    @Override
    public Proveedor listarProveedor(String idProveedor) {
        String sql = "CALL sp_ObtenerProveedor(?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, idProveedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                pvdor.setIdProveedor(rs.getString("id_proveedor"));
                pvdor.setNombreProveedor(rs.getString("nombre_proveedor"));
                pvdor.setTelefonoProveedor(rs.getString("telefono"));
                pvdor.setCorreoProveedor(rs.getString("correo"));
                pvdor.setDireccionProveedor(rs.getString("direccion"));                
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return pvdor;
    }

    @Override
    public boolean agregarProveedor(Proveedor prov) {
        String sql = "CALL sp_IngresarProveedor(?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getIdProveedor());
            ps.setString(2, prov.getNombreProveedor());
            ps.setString(3, prov.getTelefonoProveedor());
            ps.setString(4, prov.getCorreoProveedor());
            ps.setString(5, prov.getDireccionProveedor());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }

    @Override
    public boolean editarProveedor(Proveedor prov) {
        String sql = "UPDATE tbl_proveedor SET nombre_proveedor='" + prov.getNombreProveedor() + "',telefono='" + prov.getTelefonoProveedor() + "',correo='" + prov.getCorreoProveedor() + "',direccion='" + prov.getDireccionProveedor() +"' WHERE id_proveedor='" + prov.getIdProveedor() + "'";
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
    public boolean eliminarProveedor(String idProveedor) {
        String sql = "DELETE FROM tbl_proveedor WHERE id_proveedor='" + idProveedor + "'";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return false;
    }
    
}
