/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.controlador;

import edu.ub.model.Artista;
import edu.ub.model.Cataleg;
import edu.ub.model.Client;
import edu.ub.model.Pelicula;
import java.util.ArrayList;

/**
 *
 * @author maikel
 */
public class ControladorMovieAff {

    private ArrayList<Client> list_Clients;
    private MovieAffDataManager dataManager;
    private Cataleg cataleg;

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
    
    
    public void afegirPelicula(Pelicula pelicula){
        cataleg.addPelicula(pelicula);
    }
    
    public String getStringCataleg(){
        return cataleg.mostrarCataleg();
    }
    
    public void afegirActor(Artista actor, String idPelicula){
        cataleg.addActorPelicula(actor,idPelicula);        
    }
    
    public void afegirDirector(Artista director, String idPelicula){
        cataleg.addDirectorPelicula(director,idPelicula);
    }
    
}
