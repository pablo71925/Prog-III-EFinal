/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarboln.modelo;

import java.io.Serializable;
import proyectoarboln.exception.ArbolNException;

/**
 *
 * @author Juan Pablo Fernandez
 */
public class ArbolN implements Serializable {

    private NodoN raiz;

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }

    public void adicionarNodo(Empleado dato, String identificacionPadre, NodoN ayudante)
            throws ArbolNException {
        //si hay datos
        ///Revisar si el empleado ya existe
        //encontrar al papa
        //si el papa existe lo adiciono
        if (raiz == null) {
            raiz = new NodoN(dato);
        } else {
            //buscar empleado
            if (buscarNodo(dato.getIdentificacion(), raiz) == null) {
                //encontrar el padre
                NodoN padreEncontrado = buscarNodo(identificacionPadre, raiz);
                if (padreEncontrado != null) {
                    // encontro al padre
                    padreEncontrado.getHijos().add(new NodoN(dato));
                } else {
                    throw new ArbolNException("padre con identificaion" + identificacionPadre
                            + "no existe");
                }
            } else {
                throw new ArbolNException("empleado con identificacion" + dato.getIdentificacion()
                        + "ya existe");
            }
        }
    }

    public NodoN buscarNodo(String identificacion, NodoN ayudante) {
        if (ayudante.getDato().getIdentificacion() == identificacion) {
            return ayudante;
        } else {
            //recorrer los hijos
            for (NodoN hijo : ayudante.getHijos()) {
                NodoN nodoEncontrado = buscarNodo(identificacion, hijo);
                if (nodoEncontrado != null) {
                    return nodoEncontrado;
                }
            }
        }
        return null;
    }

    double sumarNomina;

    public int sumarNomina(double salario, NodoN ayudante) {

        sumarNomina = ayudante.getDato().getSalario();

        for (NodoN hijo : ayudante.getHijos()) {
            sumarNomina += sumarNomina(salario, hijo);
        }

        return (int) sumarNomina;
    }

    int conteoGenero = 0;

    public int buscarGenero(String genero, NodoN ayudante) {
        int total = 0;
        if (ayudante.getDato().getGenero() == genero) {
            conteoGenero++;
        }
        //recorrer los hijos
        for (NodoN hijo : ayudante.getHijos()) {
            conteoGenero = buscarGenero(genero, hijo);
        }
        total = conteoGenero;
        conteoGenero = 0;
        return total;
    }

    int listarCiudad = 0;

    public int listarCiudad(Ciudad ciudad, NodoN ayudante) {
        int total = 0;
        if (ayudante.getDato().getCiudad() == ciudad) {
            listarCiudad++;
        }
        //recorrer los hijos
        for (NodoN hijo : ayudante.getHijos()) {
            listarCiudad = listarCiudad(ciudad, hijo);
        }
        total = listarCiudad;
        listarCiudad = 0;

        return total;
    }

    int conteoGeneroM = 0;

    public int promediarEdadM(String genero, byte edad, NodoN ayudante) {

        double promediarEdad = 0;
        if (ayudante.getDato().getGenero() == "M") {
            conteoGeneroM++;
            promediarEdad = ayudante.getDato().getEdad();

        }
        for (NodoN hijo : ayudante.getHijos()) {

            promediarEdad += promediarEdadM(genero, edad, hijo);

        }

        return (int) (promediarEdad);

    }

    int conteoGeneroF = 0;

    public int promediarEdadF(String genero, byte edad, NodoN ayudante) {

        double promediarEdad = 0;
        if (ayudante.getDato().getGenero() == "F") {
            conteoGeneroF++;
            promediarEdad = ayudante.getDato().getEdad();

        }
        for (NodoN hijo : ayudante.getHijos()) {

            promediarEdad += promediarEdadF(genero, edad, hijo);

        }

        return (int) (promediarEdad);

    }

    int conteoEdadM = 0;

    public int contadorEdadM(String genero, NodoN ayudante) {

        if (ayudante.getDato().getGenero() == "M") {
            conteoEdadM++;
        }
        for (NodoN hijo : ayudante.getHijos()) {
            conteoEdadM = contadorEdadM(genero, hijo);

        }

        return conteoEdadM;
    }

    int conteoEdadF = 0;

    public int contadorEdadF(String genero, NodoN ayudante) {

        if (ayudante.getDato().getGenero() == "F") {
            conteoEdadF++;
        }
        for (NodoN hijo : ayudante.getHijos()) {
            conteoEdadF = contadorEdadF(genero, hijo);

        }

        return conteoEdadF;
    }
    
    
}
