/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarboln;

import javax.swing.JOptionPane;
import proyectoarboln.exception.ArbolNException;
import proyectoarboln.modelo.ArbolN;
import proyectoarboln.modelo.Ciudad;
import proyectoarboln.modelo.Empleado;

/**
 *
 * @author Juan Pablo Fernandez
 */
public class PruebaArbolN {

    public static void main(String[] args) {
        ArbolN arbol = new ArbolN();
        Ciudad mzls = new Ciudad(1, "Manizales");
        Ciudad per = new Ciudad(1, "Pereira");
        
        Empleado carloaiza = new Empleado("Carlos Alberto", "Loaiza", mzls, 12000, (byte) 50, "75147236", "M");
        Empleado esteban = new Empleado("Esteban", "Alzate Rios", per, 4000, (byte) 20, "85147236", "M");
        Empleado hoover = new Empleado("Hoover", "Colorado", mzls, 5000, (byte) 40, "12345687", "M");
        Empleado karen = new Empleado("Karen", "Ortegon", mzls, 8000, (byte) 26, "22345687", "F");
        Empleado leidy = new Empleado("Leidy", "Osorio", per, 9000, (byte) 29, "1053824456", "F");

        

        try {
            arbol.adicionarNodo(carloaiza, "", arbol.getRaiz());
            arbol.adicionarNodo(esteban, carloaiza.getIdentificacion(), arbol.getRaiz());
            arbol.adicionarNodo(hoover, esteban.getIdentificacion(), arbol.getRaiz());
            arbol.adicionarNodo(karen, esteban.getIdentificacion(), arbol.getRaiz());
            arbol.adicionarNodo(leidy, esteban.getIdentificacion(), arbol.getRaiz());
        
            

            System.out.println("Jefe: " + carloaiza.getNombre() + " " + carloaiza.getApellidos() + " Cc " + carloaiza.getIdentificacion() + " Salario " + carloaiza.getSalario() + "\n"
                    + "Empleado 1: " + esteban.getNombre() + " Cc " + esteban.getIdentificacion() + " Salario $" + esteban.getSalario() + "\n"
                    + "Empleado 2: " + hoover.getNombre() + " Cc " + hoover.getIdentificacion() + " Salario $" + hoover.getSalario() + "\n"
                    + "Empleado 3: " + karen.getNombre() + " Cc " + karen.getIdentificacion() + " Salario $" + karen.getSalario() + "\n"
                     + "Empleado 4: " + leidy.getNombre() + " Cc " + leidy.getIdentificacion() + " Salario $" + leidy.getSalario() + "\n"
            );

            System.out.println("Total nómina: " + arbol.sumarNomina(0, arbol.getRaiz()));
            System.out.println("Total masculinos: " + arbol.buscarGenero("M", arbol.getRaiz()));
            System.out.println("Total femeninos: " + arbol.buscarGenero("F", arbol.getRaiz()));
            System.out.println("Total ciudad Manizales: " + arbol.listarCiudad(mzls, arbol.getRaiz()));
            System.out.println("Total ciudad Pereira: " + arbol.listarCiudad(per, arbol.getRaiz()));
            System.out.println("Promedio edad Maculinos: " + arbol.promediarEdadM ("",(byte) 0, arbol.getRaiz())/arbol.contadorEdadM("", arbol.getRaiz()));
            System.out.println("Promedio edad Femeninos: " + arbol.promediarEdadF ("",(byte) 0, arbol.getRaiz())/arbol.contadorEdadF("", arbol.getRaiz()));
          
        } catch (ArbolNException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
