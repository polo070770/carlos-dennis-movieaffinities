/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 * Calse Genere
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Genere {

    private int id;
    private String nom;

    /**
     * Constructor
     * @param id id del gènere
     * @param nom nom del gènere
     */
    public Genere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Retorna l'id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Canvia l'id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nom
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Canvia el nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Retorna el gènere
     * @return 
     */
    public String getGenere(){
        return this.nom;
    }
}
