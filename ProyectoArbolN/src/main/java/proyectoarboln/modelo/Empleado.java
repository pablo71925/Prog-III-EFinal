/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarboln.modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Pablo Fernandez
 */
public class Empleado implements Serializable{
 private String nombre;
 private String apellidos;
 private Ciudad ciudad;
 private double salario;
 private byte edad;
 private String identificacion;
 private String genero;
 
 public Empleado(){
 }

    public Empleado(String nombre, String apellidos, Ciudad ciudad, double salario, byte edad, String identificacion, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.salario = salario;
        this.edad = edad;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

        public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public double getSalario() {
        return salario;
    }

    public byte getEdad() {
        return edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
  
 
}
