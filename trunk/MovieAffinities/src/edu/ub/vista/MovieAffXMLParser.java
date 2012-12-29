package edu.ub.vista;

import edu.ub.controlador.MovieAffDataManager;
import edu.ub.controlador.ControladorMovieAff;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Parser per a obtenir dades d'un fitxer XML de Movie Affinities
 *
 */
public class MovieAffXMLParser {

    /**
     * Data manager
     */
    MovieAffDataManager dataManager;
    ControladorMovieAff ctrlMovieAff;

    /**
     * Constructor
     */
    public MovieAffXMLParser(MovieAffDataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Parseja un fitxer XML de Movie Affinities i guarda les dades al sistema
     *
     * @param nomFitxer
     */
    public void parse(String nomFitxer) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(nomFitxer));
            doc.getDocumentElement().normalize();

            // Obtenim dades
            this.obtenirMovies(doc);
            this.obtenirClients(doc);
            this.obtenirValoracions(doc);
            this.obtenirAdministradors(doc);

        } catch (SAXParseException err) {
            System.out.println("** Error parsejant" + ", linia " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * Obte els films per Movie Affinities
     *
     * @param doc document XML del que obtenir les dades
     */
    private void obtenirMovies(Document doc) {
        NodeList movies = doc.getElementsByTagName("movie");
        String id, mins, year, title, desc;
        int numMovies = movies.getLength();

        // Parsejo tots els elements movies
        for (int i = 0; i < numMovies; i++) {
            Node movie = movies.item(i);

            if (movie.getNodeType() == Node.ELEMENT_NODE) {
                Element eMovie = (Element) movie;
                id = movie.getAttributes().getNamedItem("id").getTextContent();
                mins = movie.getAttributes().getNamedItem("mins").getTextContent();
                year = movie.getAttributes().getNamedItem("year").getTextContent();

                NodeList nTitle = eMovie.getElementsByTagName("title");
                Element eTitle = (Element) nTitle.item(0);
                title = eTitle.getTextContent();

                NodeList nDesc = eMovie.getElementsByTagName("description");
                Element eDesc = (Element) nDesc.item(0);
                desc = eDesc.getTextContent();

                // Creem un nou film amb la informacio obtinguda
                dataManager.crearMovie(id, mins, year, title, desc);

                // Obtenim informacio de la productora
                this.obtenirProductora(eMovie, id);

                // Obtenim informacio dels generes
                this.obtenirGeneres(eMovie, id);

                // Obtenim informacio dels artistes
                this.obtenirArtistes(eMovie, id);
            }
        }
    }

    /**
     * Obte la productura que va fer el film
     *
     * @param eMovie film on buscar els generes
     * @param idMovie id del film
     */
    private void obtenirProductora(Element eMovie, String idMovie) {
        String nom, id;
        Node productora = eMovie.getElementsByTagName("productora").item(0);

        if (productora.getNodeType() == Node.ELEMENT_NODE) {
            id = productora.getAttributes().getNamedItem("id").getTextContent();
            nom = productora.getAttributes().getNamedItem("name").getTextContent();

            dataManager.crearProductora(id, nom, idMovie);
        }
    }

    /**
     * Obte els generes als quals un film pertany
     *
     * @param eMovie film on buscar els generes
     * @param idMovie id del film al qual pertanyen els generes
     */
    private void obtenirGeneres(Element eMovie, String idMovie) {
        NodeList generes = eMovie.getElementsByTagName("genere");
        String nom, id;
        int numGeneres = generes.getLength();

        // Parsejo tots els elements artist
        for (int i = 0; i < numGeneres; i++) {
            Node genere = generes.item(i);

            if (genere.getNodeType() == Node.ELEMENT_NODE) {
                id = genere.getAttributes().getNamedItem("id").getTextContent();
                nom = genere.getAttributes().getNamedItem("name").getTextContent();

                dataManager.crearGenere(id, nom, idMovie);
            }
        }
    }

    /**
     * Obte informacio sobre els artistes que hi participen a un film
     *
     * @param eMovie film on buscar els artistes
     * @param idMovie id de la pelicula
     */
    private void obtenirArtistes(Element eMovie, String idMovie) {
        NodeList artistes = eMovie.getElementsByTagName("artist");
        String id, nom, tipus;
        int numArtistes = artistes.getLength();

        // Parsejo tots els elements artist
        for (int i = 0; i < numArtistes; i++) {
            Node artist = artistes.item(i);

            if (artist.getNodeType() == Node.ELEMENT_NODE) {
                id = artist.getAttributes().getNamedItem("id").getTextContent();
                nom = artist.getAttributes().getNamedItem("nom").getTextContent();
                tipus = artist.getAttributes().getNamedItem("tipus").getTextContent();

                dataManager.crearArtista(id, nom, tipus, idMovie);
            }
        }
    }

    /**
     * Obte informacio sobre les valoracions
     *
     * @param doc fitxer XML del que obtenir les dades
     */
    private void obtenirValoracions(Document doc) {
        NodeList valoracions = doc.getElementsByTagName("valoracio");
        String id, client, film, puntuacio, data;
        int numValoracions = valoracions.getLength();

        // Parsejo tots els elements valoracio
        for (int i = 0; i < numValoracions; i++) {
            Node valoracio = valoracions.item(i);

            if (valoracio.getNodeType() == Node.ELEMENT_NODE) {

                id = valoracio.getAttributes().getNamedItem("id").getTextContent();
                client = valoracio.getAttributes().getNamedItem("client").getTextContent();
                film = valoracio.getAttributes().getNamedItem("movie").getTextContent();
                puntuacio = valoracio.getAttributes().getNamedItem("puntuacio").getTextContent();
                data = valoracio.getAttributes().getNamedItem("data").getTextContent();

                dataManager.crearValoracio(id, client, film, puntuacio, data);
            }
        }
    }

    /**
     * Obte informacio sobre els administradors
     *
     * @param doc fitxer XML del que obtenir les dades
     */
    private void obtenirAdministradors(Document doc) {
        NodeList admins = doc.getElementsByTagName("admin");
        String id, nom, usuari, password;
        int numAdmins = admins.getLength();

        // Parsejo tots els elements admin
        for (int i = 0; i < numAdmins; i++) {
            Node admin = admins.item(i);

            if (admin.getNodeType() == Node.ELEMENT_NODE) {
                id = admin.getAttributes().getNamedItem("id").getTextContent();
                Element eAdmin = (Element) admin;

                NodeList nNom = eAdmin.getElementsByTagName("nom");
                Element eNom = (Element) nNom.item(0);
                nom = eNom.getTextContent();

                NodeList nUsuari = eAdmin.getElementsByTagName("usuari");
                Element eUsuari = (Element) nUsuari.item(0);
                usuari = eUsuari.getTextContent();

                NodeList nPassword = eAdmin.getElementsByTagName("password");
                Element ePassword = (Element) nPassword.item(0);
                password = ePassword.getTextContent();

                // Creem l'admin
                dataManager.crearAdmin(id, nom, usuari, password);
            }
        }
    }

    /**
     * Obte informacio sobre els clients
     *
     * @param doc fitxer XML del que obtenir les dades
     */
    private void obtenirClients(Document doc) {
        NodeList clients = doc.getElementsByTagName("client");
        String id, nom, usuari, password, vip, faltes, dni, adreca;
        int numAdmins = clients.getLength();

        // Parsejo tots els elements client
        for (int i = 0; i < numAdmins; i++) {
            Node client = clients.item(i);

            if (client.getNodeType() == Node.ELEMENT_NODE) {
                id = client.getAttributes().getNamedItem("id").getTextContent();
                vip = client.getAttributes().getNamedItem("vip").getTextContent();
                faltes = client.getAttributes().getNamedItem("faltes").getTextContent();
                Element eClient = (Element) client;

                NodeList nNom = eClient.getElementsByTagName("nom");
                Element eNom = (Element) nNom.item(0);
                nom = eNom.getTextContent();

                NodeList nDni = eClient.getElementsByTagName("dni");
                Element eDni = (Element) nDni.item(0);
                dni = eDni.getTextContent();

                NodeList nAdreca = eClient.getElementsByTagName("adreca");
                Element eAdreca = (Element) nAdreca.item(0);
                adreca = eAdreca.getTextContent();

                NodeList nUsuari = eClient.getElementsByTagName("usuari");
                Element eUsuari = (Element) nUsuari.item(0);
                usuari = eUsuari.getTextContent();

                NodeList nPassword = eClient.getElementsByTagName("password");
                Element ePassword = (Element) nPassword.item(0);
                password = ePassword.getTextContent();

                // Creem el client
                dataManager.crearClient(id, nom, dni, adreca, usuari, password, vip, faltes);

            }
        }
    }
}
