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
    
    /**
     * Inserta un nuevo usuario en la tabla 'usuarios'.
     *
     * @param u Objeto Usuario con nombre y correo (id se ignora porque es AUTO_INCREMENT).
     * @return  El id generado por la BD o -1 si algo salió mal.
     */
    public int crearUsuario(Usuario u){
        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?,?)";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas ==0) {
                System.out.println("No se inserto ningun registro.");
                return -1;
            }
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    u.setId(idGenerado);
                    return idGenerado;
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar usuarios: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Elimina un usuario por su id.
     *
     * @param id Clave primaria del usuario que se quiere borrar.
     * @return   true  → se borró al menos 1 fila.  
     *           false → no existía ese id o hubo error.
     */
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                System.out.println("Usuario con id = " + id + " eliminado.");
                return true;
            } else {
                System.out.println("No se encontro usuario con id = " + id);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }     
    }
}



