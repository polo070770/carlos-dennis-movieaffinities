/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.ArrayList;

/**
 * Clase Cataleg
 *
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
     *
     * @return r
     */
    public String mostrarCataleg() {
        String r = "";
        for (Pelicula pelicula : list_Pelis) {
            r += "\n" + pelicula.toString();
        }
        return r;
    }

    public String mostrarPelNoPrefNoVistes(String g) {
        return "";
    }

    public String baixaPelicula() {
        String s = "";
        boolean esborro;
        int tamany, i;
        tamany = list_Pelis.size();
        i = 0;
        Pelicula pelicula;
        while (i < tamany) {
            pelicula = list_Pelis.get(i);
            esborro = pelicula.valoracioBaixa();
            if (esborro) {
                s += pelicula.toString();
                list_Pelis.remove(i);
                tamany--;
            }
            i++;
        }
        return s;
    }

    public String ranking() {
        String s = "";
        int i = 5;
        float valora = 0;

        while (i >= 3) {
            for (Pelicula pel : list_Pelis) {
                valora = pel.valoracio();
                if (valora >= i && valora < (i + 1)) {
                    s += "\n" + pel.toString();
                }
            }
            i--;
        }
        return s;
    }

    public String trobarNomPeli(String nomPeli) {
        boolean trobat = false;
        int i = 0;
        String id = null;
        Pelicula pelicula;

        while (i < list_Pelis.size() && !trobat) {

            pelicula = list_Pelis.get(i);
            trobat = pelicula.mateixTitol(nomPeli);

            if (trobat) {
                id = pelicula.getIdPelicula();
            }

            i++;
        }

        return id;
    }

    public String visualitzarPelicula(int posicio, Client c) {
        Pelicula tmp;
        tmp = list_Pelis.get(posicio);

        c.peliculaVista(tmp);

        return tmp.toString();

    }

    public void puntuaPelicula(String idPelicula, int idClient, int puntuacio, Data data_act) {
        Pelicula pelicula;
        pelicula = getPelicula(idPelicula);

        pelicula.valorarPeli(idClient, puntuacio, data_act);

    }

    public String obtindreRecomanacions(Client userLogat) {
        String generePref = userLogat.generePreferit();
        String pelisRecomanades = "";

        for (Pelicula pelicula : list_Pelis) {
            boolean trobat;
            String titol_tmp;
            boolean haVist;

            trobat = pelicula.mateixGenere(generePref);

            if (trobat) {
                titol_tmp = pelicula.getTitol();

                haVist = userLogat.haVistPeli(titol_tmp);

                if (!haVist) {
                    pelisRecomanades += pelicula.toString();
                }
            }
        }
        return pelisRecomanades;
    }

    /**
     * Mètode per afegir una pel·lícula
     *
     * @param pelicula pel·lícula que s'afegeix
     */
    public void addPelicula(Pelicula pelicula) {
        list_Pelis.add(pelicula);
    }

    /**
     * Mètode per afegir un director a una pel·lícula
     *
     * @param director director de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addDirectorPelicula(Artista director, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < list_Pelis.size()) {
            if (list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)) {
                list_Pelis.get(i).addDirector(director);
                trobat = true;
            }
            i++;
        }
    }

    /**
     * Mètode per afegir un actor a una pel·lícula
     *
     * @param actor actor de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addActorPelicula(Artista actor, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < list_Pelis.size()) {
            if (list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)) {
                list_Pelis.get(i).addActor(actor);
                trobat = true;
            }
            i++;
        }
    }

    /**
     * Mètode per afegir un gènere a una pel·lícula
     *
     * @param genere gènere de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addGenerePelicula(Genere genere, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < list_Pelis.size()) {
            if (list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)) {
                list_Pelis.get(i).addGenere(genere);
                trobat = true;
            }
            i++;
        }
    }

    /**
     * Mètode per afegir una productora a una pel·lícula
     *
     * @param productora productora de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addProductoraPelicula(Productora productora, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < list_Pelis.size()) {
            if (list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)) {
                list_Pelis.get(i).setProductora(productora);
                trobat = true;
            }
            i++;
        }
    }

    /**
     * Mètode per afegir una valoració a una pel·lícula
     *
     * @param valoracio valoració de la pel·lícula
     * @param idPelicula id de la pel·lícula
     */
    public void addValoracioPelicula(Valoracio valoracio, String idPelicula) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < list_Pelis.size()) {
            if (list_Pelis.get(i).getIdPelicula().equalsIgnoreCase(idPelicula)) {
                list_Pelis.get(i).addValoracio(valoracio);
                trobat = true;
            }
            i++;
        }
    }

    public String getIdPelicula(int opt) {
        String tmp = null;
        if (opt < list_Pelis.size()) {
            tmp = list_Pelis.get(opt).getIdPelicula();
        }
        return tmp;
    }

    public Pelicula getPelicula(String idPelicula) {
        boolean trobat = false;
        int i = 0;
        Pelicula pelicula = null;
        while (i < list_Pelis.size() && !trobat) {
            pelicula = list_Pelis.get(i);
            if (pelicula.getIdPelicula().equals(idPelicula)) {
                trobat = true;
            }
            i++;
        }
        return pelicula;
    }

    public ArrayList<Genere> getGeneresPelicula(int pos) {
        return list_Pelis.get(pos).getGeneres();
    }
}
