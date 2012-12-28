/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.ArrayList;

/**
 * Clase Pelicula
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Pelicula {

    //Atributs per defecte
    private String titol;
    private String descripcio;
    private String idPelicula;
    private Data anyPublicacio;
    private int minuts;
    //Atributs adicionals
    private int valoracio;
    private int visualitzacions;
    private ArrayList<Artista> list_Actor;
    private ArrayList<Artista> list_Director;
    private ArrayList<Genere> list_GeneresPelis;
    private ArrayList<Valoracio> valoracions_peli;
    private Productora productora;

    /**
     * Constructor
     *
     * @param titol títol de la pel·lícula
     * @param descripcio descripció de la pel·lícula
     * @param idPelicula id de la pel·lícula
     * @param anyPublicacio any de publicació de la pel·lícula
     * @param minuts durada de la pel·lícula
     */
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
        this.list_GeneresPelis = new ArrayList();
        this.valoracions_peli = new ArrayList();
    }

    /**
     * Retorna l'id
     *
     * @return
     */
    public String getIdPelicula() {
        return idPelicula;
    }

    public String getTitol() {
        return this.titol;
    }

    public ArrayList<Genere> getGeneres() {
        return this.list_GeneresPelis;
    }

    /**
     * Canvia la productora
     *
     * @param productora productora de la pel·lícula
     */
    public void setProductora(Productora productora) {
        this.productora = productora;
    }

    /**
     * Afegeix un director
     *
     * @param director director de la pel·lícula
     */
    public void addDirector(Artista director) {
        this.list_Director.add(director);
    }

    /**
     * Afegeix un actor
     *
     * @param actor actor de la pel·lícula
     */
    public void addActor(Artista actor) {
        this.list_Actor.add(actor);
    }

    /**
     * Afegeix un gènere
     *
     * @param genere gènere de la pel·lícula
     */
    public void addGenere(Genere genere) {
        this.list_GeneresPelis.add(genere);
    }

    /**
     * Afegeix una valoració
     *
     * @param valoracio valoració de la pel·lícula
     */
    public void addValoracio(Valoracio valoracio) {
        this.valoracions_peli.add(valoracio);
    }

    /**
     * Mètode que retorna un string amb les dades d'una pel·lícula
     *
     * @return r + s
     */
    @Override
    public String toString() {

        String s;
        /*s = "\nActors: ";
         for (Artista a : list_Actor) {
         s += a.toString();
         }*/
        /*s += "\nDirectors: ";
         for (Artista a : list_Director) {
         s += a.toString();
         }*/
        /*s = "\nGeneres: ";
         for (Genere g : list_GeneresPelis) {
         s += g.getGenere() + " ";
         }*/

        /*s = "\nProductora: " + productora.getNom();*/

        s = "\nValoracions: ";
        for (Valoracio v : valoracions_peli) {
            s += v.getValoracio() + " ";
        }

        String r;
        r = "\nTitol: " + this.titol
                + "\n--------------------------------------------------"
                + "\nMinuts: " + this.minuts + "\nAny: " + this.anyPublicacio.toStringAnyPublicacio()
                + "\nDescripció: " + this.descripcio;
        return r + s;
    }

    public boolean mateixTitol(String nomPeli) {
        return this.titol.equals(nomPeli);
    }

    public void valorarPeli(int idClient, int puntuacio, Data dataValoracio) {
        int idValoracio;
        idValoracio = valoracions_peli.size();
        Valoracio valoracioPeli = new Valoracio(this.idPelicula, idClient, puntuacio, dataValoracio, idValoracio);

        valoracions_peli.add(valoracioPeli);
    }

    public boolean mateixGenere(String generePref) {
        boolean b = false;
        String tmp;
        int i = 0;

        while (i < list_GeneresPelis.size() && !b) {
            tmp = list_GeneresPelis.get(i).getGenere();

            if (tmp.equals(generePref)) {
                b = true;
            }
            i++;
        }
        return b;
    }
}
