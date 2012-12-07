/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 *
 * @author maikel
 */
public class Artista {

    private String nom;
    private String nacionalitat;
    private float cache;
    private String id;

    public Artista(String nom, String id) {
        this.nom = nom;
        this.nacionalitat = null;
        this.id = id;
    }

    public String toString() {
        String r;
        r = "\nArtista amb ID: " + this.id
                + "\n--------------------------------------"
                + "\nNom: " + this.nom;
        return r;
    }
}
