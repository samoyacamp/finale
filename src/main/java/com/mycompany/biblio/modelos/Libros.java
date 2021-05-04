/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.modelos;

import java.sql.Date;

/**
 *
 * @author sergi
 */
public class Libros {
    private int id;
    private String nombre;
    private String editorial;
    private String autor;
    private String genero;
    private Date fecha;
    private double precio;
    private String saga;

    public Libros(Date fecha) {
        this.fecha = fecha;
    }
   
    

    public Libros(int id, String nombre, String editorial, String autor, String genero, double precio, String saga) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
        this.saga = saga;
    }

    public Libros() {
    }

    public Libros(int i, int parseInt, String text, String text0, String text1, int indexOf, Date valueOf, float parseFloat, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }
    @Override
    public String toString() {
        return "Libros{" + "id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", autor=" + autor + ", genero=" + genero + ", precio=" + precio + ", saga=" + saga + '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
