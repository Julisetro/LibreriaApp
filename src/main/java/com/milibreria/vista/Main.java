package com.milibreria.vista;

import com.milibreria.controlador.UsuarioDAO;
import com.milibreria.modelo.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    // --- recursos compartidos ---
    private static final Scanner sc = new Scanner(System.in);
    private static final UsuarioDAO dao = new UsuarioDAO();
    
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("> ");
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1 -> listarUsuarios();
                case 2 -> insertarUsuario();
                case 3 -> actualizarUsuario();
                case 4 -> eliminarUsuario();
                case 0 -> salir = true;
                default -> System.out.println("Opción invalida. \n");
            }
        }
        System.out.println("Programa finalizado. ");
    }
    
    /* --- Menu --- */
    private static void mostrarMenu() {
        System.out.println("""
                           ====== MENÚ CRUD USUARIOS ======
                           1. Listar usuarios
                           2. Insertar usuario   (pendiente)
                           3. Actualizar usuario
                           4. Eliminar usuario   (pendiente)
                           0. Salir
                           """);
    }

    /* --- READ --- */
    private static void listarUsuarios() {
        List<Usuario> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay usuarios registrados.\n");
        } else {
            lista.forEach(u ->
                    System.out.printf("%-3d %-20s %s%n",
                            u.getId(), u.getNombre(), u.getCorreo()));
            System.out.println();
        }
    }
    
    /* --- UPDATE --- */
    private static void actualizarUsuario() {
        try {
            System.out.print("ID del usuario a modificar: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo correo: ");
            String correo = sc.nextLine();
            
            Usuario u = new Usuario(id, nombre, correo);
            dao.actualizar(u);
            System.out.println("Usuario actualizado. \n");
        } catch (SQLException e) {
            System.err.println("Error actualizando: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido (debe ser numérico).\n");
        }
    }
    
        /* ------------- PENDIENTE: CREATE ------------- */
    private static void insertarUsuario() {
        System.out.println("Funcionalidad de inserción aún no implementada.\n");
    }

    /* ------------- PENDIENTE: DELETE ------------- */
    private static void eliminarUsuario() {
        System.out.println("Funcionalidad de eliminación aún no implementada.\n");
    }    
}
