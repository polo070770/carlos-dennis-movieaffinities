package edu.ub.informatica.disseny.movieaff;

import edu.ub.controlador.MovieAffDataManager;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Test de carrega de fitxer XML de Movie Affinities
 * 
 */
public class MovieAffXMLTest extends DefaultHandler {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MovieAffXMLTest("data/MovieAff.xml");
	}

	/**
	 * Parseja el fitxer XML i guarda les dades
	 * 
	 * @param nomFitxer fitxer XML a parsejar
	 */
	public MovieAffXMLTest(String nomFitxer) {
		MovieAffDataManager dataManager = new MovieAffDataManager();
		dataManager.obtenirDades(nomFitxer);
	}
}
