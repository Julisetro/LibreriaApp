package com.milibreria.controlador;

import com.milibreria.modelo.Usuario;
import com.milibreria.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt("id"),
                                      rs.getString("nombre"),
                                      rs.getString("correo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Actualiza el resgistro de un usuario en la BD.
     * @param u Objeto Usuario ya modificado (id, nombre, correo).
     * @throws java.sql.SQLException Si algo falla en la operación SQL.
     */
    
    public void actualizar(Usuario u) throws SQLException {
        String sql = 
                "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setInt(3, u.getId());
            
            int filas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
        }
    }
}



