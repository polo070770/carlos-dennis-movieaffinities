/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 * Clase Productora
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Productora {

    private String nom;
    private int id;

    /**
     * Constructor
     *
     * @param nom nom de la productora
     * @param id id de la productora
     */
    public Productora(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    /**
     * Retorna el nom
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Canvia el nom
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retorna l'id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Canvia l'id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
