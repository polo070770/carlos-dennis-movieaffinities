package edu.ub.controlador;

import edu.ub.controlador.ControladorMovieAff;
import edu.ub.model.Actor;
import edu.ub.vista.MovieAffXMLParser;

import edu.ub.model.Client;
import edu.ub.model.Pelicula;
import edu.ub.model.Artista;
import edu.ub.model.Data;
import edu.ub.model.Director;
import edu.ub.model.Valoracio;
import edu.ub.model.Genere;
import edu.ub.model.Productora;

/**
 * Data manager per Movie Affinities. Crea les estructures de dades necessàries
 * per a manegar l'aplicació de gestió de Movie Affinities.
 *
 */
public class MovieAffDataManager {

    private ControladorMovieAff ctrlMovieAff;

    /* -------------------------------------------------------------------
     * Metodes a implementar per vosaltres. En aquests metodes creareu els
     * vostres objectes a partir de la informacio obtinguda del fitxer XML
     * 
     * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
     * dades que retorna el metode, es a dir que sou lliures de
     * modificar-ho al gust, excepte les crides inicials que es fan.
     * -------------------------------------------------------------------
     */
    /**
     * Obté les dades del fitxer XML passat per paràmetre
     *
     * @param nomFitxer ruta del fitxer XML del que obtenir les dades
     */
    public void obtenirDades(String nomFitxer, ControladorMovieAff ctrl) {
        MovieAffXMLParser parser = new MovieAffXMLParser(this);
        ctrlMovieAff = ctrl;
        parser.parse(nomFitxer);
    }

    /**
     * Crea un nou film a partir de la informacio obtinguda del fitxer XML
     *
     * @param id id del film. El podeu utilitzar o no
     * @param mins duració del film
     * @param year any en el que es va estrenar
     * @param title títol del film
     */
    public void crearMovie(String id, String mins, String year, String title, String desc) {

        /*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
         *  d'una nova pel·licula.
         */

        /*System.out.println("\nFilm amb ID: " + id);
         System.out.println("--------------------------------------------------");
         System.out.println("Titol: " + title);
         System.out.println("Minuts: " + mins);
         System.out.println("Any: " + year);
         System.out.println("Descripció: " + desc);*/

        int any = Integer.valueOf(year);
        Data data = new Data(any);
        int min = Integer.valueOf(mins);

        Pelicula pelicula = new Pelicula(title, desc, id, data, min);

        ctrlMovieAff.afegirPelicula(pelicula);

    }

    /**
     * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
     *
     * @param id id del artista. El podeu utilitzar o no
     * @param nom nom del artista
     * @param tipus tipus (director\actor) del artista
     * @param idMovie film al qual treballa. El podeu utilitzar o no
     */
    public void crearArtista(String id, String nom, String tipus, String idMovie) {

        /* TODO: Aqui feu el necessari per a crear els artistes per als films
         */

        /*System.out.println("\nArtista amb ID: " + id);
         System.out.println("--------------------------------------");
         System.out.println("Nom: " + nom);
         System.out.println("Tipus: " + tipus);
         System.out.println("Film ID: " + idMovie);*/

        if (tipus.equalsIgnoreCase("actor")) {
            Actor actor = new Actor(nom, id);
            ctrlMovieAff.afegirActor(actor, idMovie);
        } else if (tipus.equalsIgnoreCase("director")) {
            Director director = new Director(nom, id);
            ctrlMovieAff.afegirDirector(director, idMovie);
        }

    }

    /**
     * Crea genere del fitxer XML
     *
     * @param id id del genere
     * @param nom nom del genere
     * @param idMovie id del film del genere. El podeu utilitzar o no
     */
    public void crearGenere(String id, String nom, String idMovie) {

        /* TODO: Aqui feu el necessari per a crear els generes per als films
         */

        /*System.out.println("\nGenere amb ID: " + id);
         System.out.println("--------------------------------------");
         System.out.println("Nom: " + nom);
         System.out.println("Film ID: " + idMovie);*/
    }

    /**
     * Crea productora del fitxer XML
     *
     * @param id id de la productora
     * @param nom nom de la productora
     * @param idMovie id del film que va fer. El podeu utilitzar o no
     */
    public void crearProductora(String id, String nom, String idMovie) {

        /* TODO: Aqui feu el necessari per a crear les productores per als films
         */

        /*System.out.println("\nProductora amb ID: " + id);
         System.out.println("--------------------------------------");
         System.out.println("Nom: " + nom);
         System.out.println("Film ID: " + idMovie);*/
    }

    /**
     * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
     *
     * @param id id de la valoracio. El podeu utilitzar o no
     * @param client identificador del client. El podeu utilitzar o no
     * @param film identificador del film. El podeu utilitzar o no
     * @param puntuacio puntuacio donada al film
     * @param data data en la que es va fer la puntuacio
     */
    public void crearValoracio(String id, String client, String film, String puntuacio, String data) {

        /* TODO: A partir d'aqui creeu la valoracio
         */
        /*System.out.println("\nValoracio amb ID: " + id);
         System.out.println("--------------------------------------");
         System.out.println("Client: " + client);
         System.out.println("Film: " + film);
         System.out.println("Puntuacio: " + puntuacio);
         System.out.println("Data: " + data);*/
    }

    /**
     * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
     *
     * @param id id del administrador
     * @param nom nom del administrador
     * @param usuari usuari del administrador
     * @param password password del administrador
     */
    public void crearAdmin(String id, String nom, String usuari, String password) {

        /* TODO: Creeu aqui el vostre admin
         */

        /*System.out.println("\nAdmin ID: " + id);
         System.out.println("-----------------");
         System.out.println("Nom: " + nom);
         System.out.println("Usuari: " + usuari);
         System.out.println("Password: " + password);*/
    }

    /**
     * Crea un nou client a partir de la informacio obtinguda del fitxer XML
     *
     * @param id id del client
     * @param nom nom del client
     * @param dni dni del client
     * @param adreca adreça del client
     * @param usuari usuari al sistema del client
     * @param password password del client
     * @param vip true si el client es vip. false si no
     * @param faltes nombre de faltes
     */
    public void crearClient(String id, String nom, String dni, String adreca,
            String usuari, String password, String vip, String faltes) {

        /* TODO: Creeu aqui el vostre client
         */

        /*System.out.println("\nClient ID: " + id);
         System.out.println("-----------------");
         System.out.println("Nom: " + nom);
         System.out.println("Usuari: " + usuari);
         System.out.println("Dni: " + dni);
         System.out.println("Adreça: " + adreca);
         System.out.println("Password: " + password);
         System.out.println("Es VIP: " + vip);
         System.out.println("Nombre de faltes: " + faltes);*/

        int id_1 = Integer.valueOf(id);

        boolean vip_1 = false;
        if (vip.equalsIgnoreCase("yes")) {
            vip_1 = true;
        } else if (vip.equalsIgnoreCase("no")) {
            vip_1 = false;
        }

        int faltes_1 = Integer.parseInt(faltes);

        Client client = new Client(id_1, nom, usuari, dni, adreca, password, vip_1, faltes_1);

        ctrlMovieAff.afegirClient(client);

    }
}
