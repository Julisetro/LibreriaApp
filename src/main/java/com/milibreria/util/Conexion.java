package com.milibreria.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/usuarios";
    private static final String USER = "root";
    private static final String PASS = "215190";
    
    public static Connection conectar() {
    try {
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (Exception e) {
        System.out.println("Error de conexión:" + e.getMessage());
        return null;
        }
    }
}
