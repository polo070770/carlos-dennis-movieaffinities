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
public class Cataleg {

    private ArrayList<Pelicula> list_Pelis;

    public Cataleg() {
        list_Pelis = new ArrayList();
    }

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

    public void addPelicula(Pelicula pelicula) {
        list_Pelis.add(pelicula);
    }

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
}
