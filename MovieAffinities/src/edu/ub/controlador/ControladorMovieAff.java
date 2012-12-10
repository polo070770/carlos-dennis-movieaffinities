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
 *
 * @author maikel
 */
public class ControladorMovieAff {

    private ArrayList<Client> list_Clients;
    private Cataleg cataleg;
    private MovieAffDataManager dataManager;
    Client administrador;

    public ControladorMovieAff() {

        list_Clients = new ArrayList();
        cataleg = new Cataleg();
        dataManager = new MovieAffDataManager();
        dataManager.obtenirDades("data/MovieAff.xml", this);

    }

    public void afegirClient(Client client) {

        list_Clients.add(client);

    }

    public String getStringListClients() {
        String r = "";
        for (Client c : list_Clients) {
            r += "\n" + c.toString();
        }
        return r;
    }

    public void afegirPelicula(Pelicula pelicula) {
        cataleg.addPelicula(pelicula);
    }

    public String getStringCataleg() {
        return cataleg.mostrarCataleg();
    }

    public void afegirActor(Artista actor, String idPelicula) {
        cataleg.addActorPelicula(actor, idPelicula);
    }

    public void afegirDirector(Artista director, String idPelicula) {
        cataleg.addDirectorPelicula(director, idPelicula);
    }

    public void afegirGenere(Genere genere, String idPelicula) {
        cataleg.addGenerePelicula(genere, idPelicula);
    }

    public void afegirProductora(Productora productora, String idPelicula) {
        cataleg.addProductoraPelicula(productora, idPelicula);
    }

    public void asignarAdministrador(Client administrador) {
        this.administrador = administrador;
    }
    public void afegirValoracioPelicula(Valoracio valoracio, String idPelicula){
        cataleg.addValoracioPelicula(valoracio, idPelicula);
    }
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
