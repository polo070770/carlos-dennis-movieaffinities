package edu.ub.vista;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ub.controlador.ControladorMovieAff;
import edu.ub.model.Client;

/**
 *
 * Clase Main Movie Affinities
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class MovieAffinities {

    ControladorMovieAff _ctrlMovieAff;
    Client userLogat;

    /**
     * Constructor
     */
    public MovieAffinities() {

        _ctrlMovieAff = new ControladorMovieAff();

    }

    public static void main(String[] args) {

        MovieAffinities aplicacioUb = new MovieAffinities();

        aplicacioUb.mostraClients();
        aplicacioUb.mostraCataleg();

    }

    /**
     * Mostra la llista de clients
     */
    public void mostraClients() {
        System.out.println(_ctrlMovieAff.getStringListClients());
    }

    /**
     * Mostra el catàleg de pel·lícules
     */
    public void mostraCataleg() {
        System.out.println(_ctrlMovieAff.getStringCataleg());
    }
}
