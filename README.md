# Codificación de módulos del software según requerimientos del proyecto GA7-220501096-AA2-EV01

## Descripción

Este proyecto corresponde a la actividad **"Codificación de módulos del software según requerimientos del proyecto GA7-220501096-AA2-EV01"**, y consiste en una aplicación de consola en Java que implementa las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una base de datos MySQL.

---

## Características

- Arquitectura modular, separando la lógica en clases:  
  - **Conexion.java**: Manejo centralizado de la conexión a la base de datos.
  - **Usuario.java**: Modelo de datos del usuario.
  - **UsuarioDAO.java**: Acceso y manipulación de datos usando el patrón DAO.
  - **Main.java**: Interfaz de usuario por consola y gestión del flujo del programa.

- Operaciones implementadas:
  - Crear usuario
  - Consultar/listar usuarios
  - Actualizar usuario
  - Eliminar usuario

- Uso de herramientas de versionamiento (**Git** y **GitHub**) para el control y seguimiento del desarrollo.
- Aplicación de estándares de codificación en nombres de clases, métodos, variables y estructura de paquetes.

---

## Requisitos

- Java JDK 8 o superior
- MySQL Server
- IDE recomendado: NetBeans (puede usarse cualquier IDE Java)
- Cliente de Git (opcional para manejo de versiones)

---

## Instalación y configuración

1. **Clona este repositorio**
    ```sh
    git clone https://github.com/tu-usuario/tu-repo.git
    ```
2. **Abre el proyecto en NetBeans o tu IDE favorito.**

3. **Configura la base de datos MySQL:**
    - Crea una base de datos llamada `usuarios`.
    - Crea la tabla `usuarios` con la siguiente estructura:
      ```sql
      CREATE TABLE usuarios (
          id INT AUTO_INCREMENT PRIMARY KEY,
          nombre VARCHAR(100) NOT NULL,
          correo VARCHAR(100) NOT NULL
      );
      ```
    - Actualiza los parámetros de conexión (usuario y contraseña) en `Conexion.java` según tu configuración local.

4. **Compila y ejecuta la aplicación**
    - Desde el IDE, ejecuta el archivo `Main.java`.
    - O, desde terminal:
      ```sh
      javac *.java
      java Main
      ```

---

## Uso

Al ejecutar el programa, aparecerá un menú en consola para gestionar los usuarios:

=== Menú ===
1. Listar usuarios
2. Insertar usuario
3. Actualizar usuario
4. Eliminar usuario
0. Salir
Elige:
Elige la opción ingresando el número correspondiente y sigue las indicaciones para completar la operación deseada.
