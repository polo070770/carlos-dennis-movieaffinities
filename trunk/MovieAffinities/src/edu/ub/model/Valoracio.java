/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 *
 * @author maikel
 */
public class Valoracio {

    private String idPelicula;
    private int idClient; //Diagrama de clases es un String
    private int valoracio;
    private Data dataValoracio;
    private int id;

    public Valoracio(String idPelicula, int idClient, int valoracio, Data dataValoracio, int id) {
        this.idPelicula = idPelicula;
        this.idClient = idClient;
        this.valoracio = valoracio;
        this.dataValoracio = dataValoracio;
        this.id = id;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getValoracio() {
        return valoracio;
    }

    public void setValoracio(int valoracio) {
        this.valoracio = valoracio;
    }

    public Data getDataValoracio() {
        return dataValoracio;
    }

    public void setDataValoracio(Data dataValoracio) {
        this.dataValoracio = dataValoracio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
