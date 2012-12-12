/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 * Clase Valoracio
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Valoracio {

    private String idPelicula;
    private int idClient; //Diagrama de clases es un String
    private int valoracio;
    private Data dataValoracio;
    private int id;

    /**
     * Constructor
     * @param idPelicula id de la pel·lícula
     * @param idClient id del client
     * @param valoracio valoració de la pel·lícula
     * @param dataValoracio data en que s'ha fet la valoració
     * @param id id de la valoració
     */
    public Valoracio(String idPelicula, int idClient, int valoracio, Data dataValoracio, int id) {
        this.idPelicula = idPelicula;
        this.idClient = idClient;
        this.valoracio = valoracio;
        this.dataValoracio = dataValoracio;
        this.id = id;
    }

    /**
     * Retorna l'id de la pel·lícula
     * @return 
     */
    public String getIdPelicula() {
        return idPelicula;
    }

    /**
     * Canvia l'id de la pel·lícula
     * @param idPelicula 
     */
    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * Retorna l'id del client
     * @return 
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Canvia l'id del client
     * @param idClient 
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retorna la valoració
     * @return 
     */
    public int getValoracio() {
        return valoracio;
    }

    /**
     * Canvia la valoració
     * @param valoracio 
     */
    public void setValoracio(int valoracio) {
        this.valoracio = valoracio;
    }

    /**
     * Retorna la data
     * @return 
     */
    public Data getDataValoracio() {
        return dataValoracio;
    }

    /**
     * Canvia la data
     * @param dataValoracio 
     */
    public void setDataValoracio(Data dataValoracio) {
        this.dataValoracio = dataValoracio;
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
}
