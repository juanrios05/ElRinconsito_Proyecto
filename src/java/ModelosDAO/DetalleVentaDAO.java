package ModelosDAO;

import Config.Conexion;
import Interfaces.DetalleVentaCRUD;
import Modelos.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO implements DetalleVentaCRUD {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;    

    @Override
    public List listarVentas() {
        ArrayList<DetalleVenta> list = new ArrayList<>();
        String sql = "CALL sp_ObtenerDetalleVentas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rs.getInt("id_detalle_factura_venta"));
                detalleVenta.setIdProductoVenta(rs.getString("id_producto"));
                detalleVenta.setNombreProductoVenta(rs.getString("nombre"));
                detalleVenta.setPrecioProductoVenta(rs.getDouble("precio_venta"));
                detalleVenta.setIdVenta(rs.getInt("id_factura_venta"));
                detalleVenta.setFechaFacturaVenta(rs.getString("fecha"));
                detalleVenta.setCedulaVenta(rs.getString("cedula"));
                detalleVenta.setNombresUsuarioVenta(rs.getString("nombres"));
                detalleVenta.setApellidosUsuarioVenta(rs.getString("apellidos"));
                detalleVenta.setCantidadProducto(rs.getInt("cantidad"));
                detalleVenta.setPrecioTotalVenta(rs.getDouble("precio"));
                list.add(detalleVenta);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return list;
    }
    
}
