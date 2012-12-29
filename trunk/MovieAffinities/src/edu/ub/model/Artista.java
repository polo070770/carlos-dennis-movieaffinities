/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 * Clase Artista
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Artista {

    //Atributs per defecte
    private String nom;
    private String id;
    //Atributs adicionals
    private float cache;
    private String nacionalitat;

    /**
     * Constructor
     *
     * @param nom nom de l'artista
     * @param id id de l'artista
     */
    public Artista(String nom, String id) {
        this.nom = nom;
        this.nacionalitat = null;
        this.id = id;
    }

    /**
     * Retorna un string amb les dades de l'artista
     *
     * @return r
     */
    @Override
    public String toString() {
        String r;
        r = "\nArtista amb ID: " + this.id
                + "\n--------------------------------------"
                + "\nNom: " + this.nom;
        return r;
    }
}
