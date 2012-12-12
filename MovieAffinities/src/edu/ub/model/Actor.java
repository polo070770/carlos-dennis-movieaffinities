package edu.ub.model;

import edu.ub.model.Artista;

/**
 * Clase Actor
 * 
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Actor extends Artista {

    private String nomArtistic;

    /**
     * Constructor 
     * @param nom nom de l'actor
     * @param id id de l'actor
     */
    public Actor(String nom, String id) {
        super(nom, id);
        this.nomArtistic = null;
    }
}
