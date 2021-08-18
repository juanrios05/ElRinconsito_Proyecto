/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanb
 */
public class UsuarioDAO extends Conexion {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    Usuario u = new Usuario();
    int r;
    
    public List listarUsuarios() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_usuario";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setPerfilUsuario(rs.getString("id_perfil"));
                list.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return list;
    }
    
    public Usuario listarProducto(String cedula) {
        String sql = "CALL sp_ObtenerUsuario(?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();            
            while (rs.next()) {
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setCorreo(rs.getString("correo"));
                u.setClave(rs.getString("clave"));
                u.setPerfilUsuario(rs.getString("id_perfil"));  
                System.out.println(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
    public Usuario validar(String correo, String clave) {
        Usuario usuario = new Usuario();
        String consulta = "CALL sp_IngresoUsuario(?,?)";
        con = cn.getConexion();                
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, clave);            
            rs = ps.executeQuery();
            rs.next();
            do {
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setPerfilUsuario(rs.getString("id_perfil"));                
            } while (rs.next());
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuario;              
    }
    
    public int registroUsuario(Usuario usuario) {

        String registrarUsuario = "CALL sp_RegistroUsuario(?,?,?,?,?,?,?,'2')";

        try {
            con = cn.getConexion();
            ps = getConexion().prepareStatement(registrarUsuario);
            ps.setString(1, usuario.getCedula());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getClave());

            if (ps.executeUpdate() == 1) {
                return r;
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return r;
    }
}
