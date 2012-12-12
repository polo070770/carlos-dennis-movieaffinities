/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.ArrayList;

/**
 * Clase Cataleg
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Cataleg {

    private ArrayList<Pelicula> list_Pelis;

    /**
     * Constructor
     */
    public Cataleg() {
        list_Pelis = new ArrayList();
    }

    /**
     * Métode que mostra el catàleg, retornant una llista de pel·lícules
     * @return r 
     */
    public String mostrarCataleg() {
        String r = "";
        for (Pelicula p : list_Pelis) {
            r += "\n" + p.toString();
        }
        return r;
    }

    public String mostrarPelNoPrefNoVistes(String g) {
        return "";
    }

    public void baixaPelicula() {
    }

    public String ranking() {
        return "";
    }

    public int trobarNomPeli(String nomPeli) {
        return 0;
    }

    public void visualitzarPelicula(int posicio, Client c) {
    }

    public void puntuaPelicula(String idClient, int puntuacio, Pelicula pelicula) {
    }

    public String obtindreRecomanacions(Client userLogat) {
        return "";
    }

    /**
     * Mètode per afegir una pel·lícula
     * @param pelicula pel·lícula que s'afegeix
     */
    public void addPelicula(Pelicula pelicula) {
        list_Pelis.add(pelicula);
    }

    /**
     * Mètode per afegir un director a una pel·lícula
     * @param director director de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addDirectorPelicula(Artista director, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < list_Pelis.size()){
            if(list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)){
                list_Pelis.get(i).addDirector(director);
                trobat = true;
            }
            i ++;
        }
    }

    /**
     * Mètode per afegir un actor a una pel·lícula
     * @param actor actor de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addActorPelicula(Artista actor, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < list_Pelis.size()){
            if(list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)){
                list_Pelis.get(i).addActor(actor);
                trobat = true;
            }
            i ++;
        }
    }
    
    /**
     * Mètode per afegir un gènere a una pel·lícula
     * @param genere gènere de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addGenerePelicula(Genere genere, String idPelicula){
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < list_Pelis.size()){
            if(list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)){
                list_Pelis.get(i).addGenere(genere);
                trobat = true;
            }
            i ++;
        }
    }
    
    /**
     * Mètode per afegir una productora a una pel·lícula
     * @param productora productora de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addProductoraPelicula(Productora productora, String idPelicula){
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < list_Pelis.size()){
            if(list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)){
                list_Pelis.get(i).setProductora(productora);
                trobat = true;
            }
            i ++;
        }
    }
    
    /**
     * Mètode per afegir una valoració a una pel·lícula
     * @param valoracio valoració de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addValoracioPelicula(Valoracio valoracio, String idPelicula){
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < list_Pelis.size()){
            if(list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)){
                list_Pelis.get(i).addValoracio(valoracio);
                trobat = true;
            }
            i ++;
        }
    }
    
    
    
}
