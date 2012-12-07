/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.ArrayList;

/**
 *
 * @author maikel
 */
public class Pelicula {

    private String titol;
    private String descripcio;
    private int valoracio;
    private int visualitzacions;
    private String idPelicula;
    private Data anyPublicacio;
    private int minuts;
    private ArrayList<Artista> list_Actor;
    private ArrayList<Artista> list_Director;

    public Pelicula(String titol, String descripcio, String idPelicula, Data anyPublicacio, int minuts) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.idPelicula = idPelicula;
        this.anyPublicacio = anyPublicacio;
        this.minuts = minuts;
        this.valoracio = 0;
        this.visualitzacions = 0;
        this.list_Actor = new ArrayList();
        this.list_Director = new ArrayList();
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void addDirector(Artista director) {
        this.list_Director.add(director);
    }

    public void addActor(Artista actor) {
        this.list_Actor.add(actor);
    }

    @Override
    public String toString() {
        
        String s = "\nActors: ";
        for (Artista a: list_Actor){
            s += a.toString();
        }
        
        s += "\nDirectors: ";
        for (Artista a: list_Director){
            s += a.toString();
        }
        
        String r;
        r = "\nFilm amb ID: " + this.idPelicula
                + "\n--------------------------------------------------"
                + "\nTitol: " + this.titol + "\nMinuts: " + this.minuts + "\nAny: " + this.anyPublicacio.toStringAnyPublicacio()
                + "\nDescripció: " + this.descripcio;
        return r + s;
    }
}
