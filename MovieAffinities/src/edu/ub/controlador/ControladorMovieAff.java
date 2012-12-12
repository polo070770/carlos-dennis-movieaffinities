/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.controlador;

import edu.ub.model.Artista;
import edu.ub.model.Cataleg;
import edu.ub.model.Client;
import edu.ub.model.Genere;
import edu.ub.model.Pelicula;
import edu.ub.model.Productora;
import edu.ub.model.Valoracio;
import java.util.ArrayList;

/**
 * Clase ControladorMovieAff
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class ControladorMovieAff {

    private ArrayList<Client> list_Clients;
    private Cataleg cataleg;
    private MovieAffDataManager dataManager;
    Client administrador;

    /**
     * Constructor
     */
    public ControladorMovieAff() {

        list_Clients = new ArrayList();
        cataleg = new Cataleg();
        dataManager = new MovieAffDataManager();
        dataManager.obtenirDades("data/MovieAff.xml", this);

    }

    /**
     * Afegeix un client a la llista de clients
     * @param client client que s'afegeix
     */
    public void afegirClient(Client client) {

        list_Clients.add(client);

    }

    /**
     * Retorna un string amb la llista de clients
     * @return 
     */
    public String getStringListClients() {
        String r = "";
        for (Client c : list_Clients) {
            r += "\n" + c.toString();
        }
        return r;
    }

    /**
     * Afegeix una pel·lícula al catàleg
     * @param pelicula pel·lícula que s'afegeix
     */
    public void afegirPelicula(Pelicula pelicula) {
        cataleg.addPelicula(pelicula);
    }

    /**
     * Retorna un string amb el catàleg
     * @return 
     */
    public String getStringCataleg() {
        return cataleg.mostrarCataleg();
    }

    /**
     * Afegeix un actor a una pel·lícula
     * @param actor actor de la pel·lícula 
     * @param idPelicula id de la pel·lícula
     */
    public void afegirActor(Artista actor, String idPelicula) {
        cataleg.addActorPelicula(actor, idPelicula);
    }

    /**
     * Afegeix un director a una pel·lícula
     * @param director director de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirDirector(Artista director, String idPelicula) {
        cataleg.addDirectorPelicula(director, idPelicula);
    }

    /**
     * Afegeix un gènere a una pel·lícula
     * @param genere gènere de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirGenere(Genere genere, String idPelicula) {
        cataleg.addGenerePelicula(genere, idPelicula);
    }

    /**
     * Afegeix una productora a una pel·lícula
     * @param productora productora de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirProductora(Productora productora, String idPelicula) {
        cataleg.addProductoraPelicula(productora, idPelicula);
    }

    /**
     * Afegeix un administrador
     * @param administrador administrador 
     */
    public void asignarAdministrador(Client administrador) {
        this.administrador = administrador;
    }
    
    /**
     * Afegeix una valoració a una pel·lícula
     * @param valoracio valoració de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirValoracioPelicula(Valoracio valoracio, String idPelicula){
        cataleg.addValoracioPelicula(valoracio, idPelicula);
    }
    
    /**
     * Afegeix una valoració a un client
     * @param valoracio valoració que fa el client
     * @param idClient id de la pel·lícula
     */
    public void afegirValoracioClient(Valoracio valoracio, int idClient){
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < 7){
            if(list_Clients.get(i).getIdClient() == idClient){
                list_Clients.get(i).addValoracio(valoracio);
                trobat = true;
            }
            i++;
        }
    }
}
