package edu.ub.vista;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ub.controlador.ControladorMovieAff;
import edu.ub.model.Client;

/**
 *
 * Classe Main Movie Affinities
 *
 * @author maikel
 */
public class MovieAffinities {

    ControladorMovieAff _ctrlMovieAff;
    Client userLogat;

    public MovieAffinities() {

        _ctrlMovieAff = new ControladorMovieAff();

    }

    public static void main(String[] args) {

        MovieAffinities aplicacioUb = new MovieAffinities();

        aplicacioUb.mostraClients();
        aplicacioUb.mostraCataleg();

    }

    public void mostraClients() {
        System.out.println(_ctrlMovieAff.getStringListClients());
    }

    public void mostraCataleg() {
        System.out.println(_ctrlMovieAff.getStringCataleg());
    }
}
