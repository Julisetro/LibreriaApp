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
}

