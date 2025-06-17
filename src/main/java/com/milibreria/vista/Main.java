package com.milibreria.vista;

import com.milibreria.controlador.UsuarioDAO;
import com.milibreria.modelo.Usuario;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.listar();

        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " " + u.getNombre() + " " + u.getCorreo());
        }
    }
}

