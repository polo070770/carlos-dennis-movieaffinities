package edu.ub.model;

import edu.ub.model.Artista;

/**
 *
 * @author maikel
 */
public class Actor extends Artista {

    private String nomArtistic;

    public Actor(String nom, String id) {
        super(nom, id);
        this.nomArtistic = null;
    }
}
