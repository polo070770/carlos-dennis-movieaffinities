/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.controlador;

import edu.ub.model.Artista;
import edu.ub.model.Cataleg;
import edu.ub.model.Client;
import edu.ub.model.Data;
import edu.ub.model.Genere;
import edu.ub.model.Pelicula;
import edu.ub.model.Productora;
import edu.ub.model.Valoracio;
import java.util.ArrayList;

/**
 * Clase ControladorMovieAff
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class ControladorMovieAff {

    private ArrayList<Client> list_Clients;
    private Cataleg cataleg;
    private MovieAffDataManager dataManager;
    private Client administrador;
    private int mes_UltimInforme;

    /**
     * Constructor
     */
    public ControladorMovieAff() {

        list_Clients = new ArrayList();
        cataleg = new Cataleg();
        dataManager = new MovieAffDataManager();
        dataManager.obtenirDades("data/MovieAff.xml", this);
        mes_UltimInforme = 0;

    }

    /**
     * Afegeix un client a la llista de clients
     *
     * @param client client que s'afegeix
     */
    public void afegirClient(Client client) {
        list_Clients.add(client);
    }

    /**
     * Afegeix una pel·lícula al catàleg
     *
     * @param pelicula pel·lícula que s'afegeix
     */
    public void afegirPelicula(Pelicula pelicula) {
        cataleg.addPelicula(pelicula);
    }

    /**
     * Afegeix un actor a una pel·lícula
     *
     * @param actor actor de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirActor(Artista actor, String idPelicula) {
        cataleg.addActorPelicula(actor, idPelicula);
    }

    /**
     * Afegeix un director a una pel·lícula
     *
     * @param director director de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirDirector(Artista director, String idPelicula) {
        cataleg.addDirectorPelicula(director, idPelicula);
    }

    /**
     * Afegeix un gènere a una pel·lícula
     *
     * @param genere gènere de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirGenere(Genere genere, String idPelicula) {
        cataleg.addGenerePelicula(genere, idPelicula);
    }

    /**
     * Afegeix una productora a una pel·lícula
     *
     * @param productora productora de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirProductora(Productora productora, String idPelicula) {
        cataleg.addProductoraPelicula(productora, idPelicula);
    }

    /**
     * Afegeix un administrador
     *
     * @param administrador administrador
     */
    public void asignarAdministrador(Client administrador) {
        this.administrador = administrador;
    }

    /**
     * Afegeix una valoració a una pel·lícula
     *
     * @param valoracio valoració de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void afegirValoracioPelicula(Valoracio valoracio, String idPelicula) {
        cataleg.addValoracioPelicula(valoracio, idPelicula);
    }

    /**
     * Afegeix una valoració a un client
     *
     * @param valoracio valoració que fa el client
     * @param idClient id de la pel·lícula
     */
    public void afegirValoracioClient(Valoracio valoracio, int idClient) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < 7) {
            if (list_Clients.get(i).getIdClient() == idClient) {
                list_Clients.get(i).addValoracio(valoracio);
                trobat = true;
            }
            i++;
        }
    }
    
    /**
     * Retorna el tamany de la llista de clients
     * 
     * @return  
     */
    public int obteTamanyClients() {
        return list_Clients.size();
    }

    /**
     * Retorna un string amb el catàleg
     * 
     * @return
     */
    public String mostrarCataleg() {
        return cataleg.mostrarCataleg();
    }

    /**
     * Retorna un client de la llista de clients
     * 
     * @param id identificador del client
     * @return 
     */
    public Client obteClient(int id) {
        return list_Clients.get(id);
    }

    /**
     * Retorna l'administrador de l'aplicació
     * 
     * @return 
     */
    public Client obteAdministrador() {
        return this.administrador;
    }

    /**
     * Comprova si existeix un nom d'usuari
     * 
     * @param nomUser nom d'usuari a comprovar
     * @return 
     */
    public boolean comprovaNomUser(String nomUser) {
        boolean trobat = false;
        int i = 0;
        Client client;
        //Mentre no s'hagi trobat i tinguem clients
        while (!trobat && i < list_Clients.size()) {
            //Recorrem la llista i obtenim el client actual
            client = list_Clients.get(i);
            //Si el nom d'usuari del client actual coincideix amb el nom d'usuari desitjat ...
            if (client.getNomUsuari().equals(nomUser)) {
                //nom d'usuari ja en ús
                trobat = true;
            }
            i++;
        }
        return trobat;
    }

    /**
     * Comprova si l'usuari es l'administrador
     * 
     * @param nomUsuari nom d'usuari a comprovar
     * @param pass contrasenya a comprovar
     * @return 
     */
    public boolean comprovaAdmin(String nomUsuari, String pass) {
        boolean admin = false;
        //Comparem nom d'usuari i contrasenya introduits amb les de l'administrador
        if (this.administrador.getNomUsuari().equals(nomUsuari)
                && this.administrador.getPassword().equals(pass)) {
            //login com administrador
            admin = true;
        }
        return admin;
    }

    /**
     * Comprova si el nom d'usuari i la contrasenya coincideixen amb
     * les que hi han guardades al registre
     * 
     * @param nomUsuari nom d'usuari a comprovar
     * @param pass contrasenya a comprovar
     * @return 
     */
    public int comprovaClients(String nomUsuari, String pass) {
        int id = -2;
        int i = 0;
        Client client;
        //Recorrem la llista de clients
        while (i < list_Clients.size() && id == -2) {
            //obtenim el client actual
            client = list_Clients.get(i);
            //si hi ha coincidencia entre noms d'usuari ...
            if (client.getNomUsuari().equals(nomUsuari)) {
                id = -1;
                //comparem contrasenyes
                if (client.getPassword().equals(pass)) {
                    //obtenim l'identificador del client
                    id = client.getIdClient();
                }
            }
            i++;
        }
        return id;
    }

    /**
     * Visualitza una pel·lícula
     * 
     * @param posicio posició de la pel·lícula
     * @param userLogat usuari que veu la pel·lícula
     * @return 
     */
    public String visualitzaPelicula(int posicio, Client userLogat) {
        return cataleg.visualitzarPelicula(posicio, userLogat);
    }

    /**
     * Busca una pel·lícula pel seu títol
     * 
     * @param nomPeli títol de la pel·lícula
     * @return 
     */
    public String trobarNomPeli(String nomPeli) {
        return cataleg.trobarNomPeli(nomPeli);
    }

    /**
     * Obté l'identificador d'una pel·lícula
     * 
     * @param opt posició de la pel·lícula
     * @return 
     */
    public String obteIdPelicula(int opt) {
        return cataleg.getIdPelicula(opt);
    }

    /**
     * Valora una pel·lícula
     * 
     * @param idPelicula identificador de la pel·lícula
     * @param idClient identificador del client
     * @param puntuacio valoració introduïda
     * @param data_act data actual
     */
    public void puntuaPelicula(String idPelicula, int idClient, int puntuacio, Data data_act) {
        cataleg.puntuaPelicula(idPelicula, idClient, puntuacio, data_act);
    }

    /**
     * Retorna els generes d'una pel·lícula
     * 
     * @param pos posició de la pel·lícula
     * @return 
     */
    public ArrayList<Genere> obteGeneresPeli(int posicio) {
        return cataleg.getGeneresPelicula(posicio);
    }

    /**
     * Obté les pel·lícules recomanades per a un client
     * 
     * @param userLogat client que obté les recomanacions
     * @return 
     */
    public String obtindreRecomanacions(Client userLogat) {
        return cataleg.obtindreRecomanacions(userLogat);
    }

    /**
     * Dona de baixa una pel·lícula
     * 
     * @return 
     */
    public String baixaPelicula() {
        return cataleg.baixaPelicula();
    }

    /**
     * Obté les pel·lícules amb les valoracions més altes
     * 
     * @return 
     */
    public String ranking() {
        return cataleg.ranking();
    }

    /**
     * Generar informes de clients
     * 
     * @param mAct mes actual
     * @return 
     */
    public boolean generarInforme(int mAct) {
        boolean generem = false;
        //Si el mes actual es major que el mes de l'ultim informe generat
        if (mAct > this.mes_UltimInforme) {
            //generem informe
            generem = true;
            //actualitzem el mes de l'ultim informe
            this.mes_UltimInforme = mAct;
        }
        return generem;
    }

    /**
     * Retorna un string amb la llista de clients
     * 
     * @return
     */
    public String mostrarInformeClients() {
        String r = "";
        for (Client c : list_Clients) {
            r += "\n" + c.mostrarInforme();
        }
        return r;
    }
}
