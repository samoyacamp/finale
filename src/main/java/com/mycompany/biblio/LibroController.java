/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.modelos.Usuario;
import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Genero;
import com.mycompany.biblio.modelos.Libros;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/**
 *
 * @author sergi
 */
public class LibroController {    
    private static Usuario user;
    private static LibroDAO ldao;
    private Libros librosSel;
    private ObservableList<Genero> generoz= FXCollections.observableArrayList(Arrays.asList(Genero.values()));
    @FXML
    private ComboBox genero;
    @FXML
    private TextField id;
    @FXML
    private TextField nombre;
    @FXML
    private TextField editorial;
    @FXML
    private TextField autor;
    @FXML 
    private DatePicker fecha;
    @FXML
    private TextField precio;
    @FXML
    private TextField saga;
    @FXML
    private Label hellouser;
    @FXML
    private ListView listaLibro;

    
    @FXML
    private void addl(){
        try{
//    private int id;
//    private String nombre;
//    private String editorial;
//    private String autor;
//    private String genero;
//    private Date fecha;
//    private double precio;
//    private String saga;
          ldao.guardarLibro(new Libros(-1,Integer.parseInt(id.getText()), nombre.getText(),editorial.getText(),autor.getText(),
                  generoz.indexOf(genero.getText()), Date.valueOf(fecha.getValue()),Float.parseFloat(precio.getText()),saga.getText()));
            initLists();
        }
        
        catch(SQLException ex){
         AlertsUtil.mostrarError("Error al modificar la ruta seleccionada. " + ex.getMessage());

        }
       
    }
     public void initLists(){
        hellouser.setText("Bienvenido "+ user.getNombre());
        genero.setItems(generoz);
        genero.setItems(generoz);
        listaLibro.getItems().clear();
        try {
            List<Libros> libro = ldao.listLibros();
            listaLibro.setItems(FXCollections.observableList(libro));
            List<Libros> libros = ldao.listLibros();
            listaLibro.setItems(FXCollections.observableList(libros));
            

        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error cargando los datos de la aplicación");
        }
     
     
     
     }
     }
     

