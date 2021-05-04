/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.DAO;

import com.mycompany.biblio.App;
import com.mycompany.biblio.modelos.Libros;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author sergi
 */
public class LibroDAO {
    private Connection conexion;
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("localhost");
        String port = configuration.getProperty("3306");
        String name = configuration.getProperty("biblioteca");
        String username = configuration.getProperty("root");
        String password = configuration.getProperty("paco123");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    public void guardarLibro(Libros libro)throws SQLException {
    String sql = "INSERT INTO biblioteca.libros(ID,NOMBRE,EDITORIAL,AUTOR,GENERO,FECHA,PRECIO,SAGA) VALUES(?,?,?,?,?,?,?.?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, libro.getId());
        sentencia.setString(2, libro.getNombre());
        sentencia.setString(3, libro.getEditorial());
        sentencia.setString(4, libro.getAutor());
        sentencia.setString (5, libro.getGenero());
        sentencia.setDate(6, libro.getFecha());
        sentencia.setDouble(7, libro.getPrecio());
        sentencia.executeUpdate();
            
            
            }
    
    public void selectLibros(Libros libro)throws SQLException {
    String sql = "SELECT * FROM LIBROS";
    }
     public List<Libros> listLibros() throws SQLException {
        List<Libros> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Libros libro = new Libros();
            libro.setId(resultado.getInt(1));
            libro.setNombre(resultado.getString(2));
            libro.setEditorial(resultado.getString(3));
            libro.setAutor(resultado.getString(4));
            libro.setGenero(resultado.getString(5));
            libro.setFecha(resultado.getDate(6));
            libro.setSaga(resultado.getString(7));
            libros.add(libro);
        }

        return libros;
    }
}
