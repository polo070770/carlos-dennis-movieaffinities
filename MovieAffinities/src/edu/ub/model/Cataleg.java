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

    /**
     * Dona de baixa una pel·lícula
     * 
     * @return 
     */
    public String baixaPelicula() {
        String s = "";
        boolean esborro;
        int tamany, i;
        tamany = list_Pelis.size();
        i = 0;
        Pelicula pelicula;
        //Recorrem el catàleg
        while (i < tamany) {
            //obtenim la pel·lícula actual
            pelicula = list_Pelis.get(i);
            //consultem si la seva valoració es baixa
            esborro = pelicula.valoracioBaixa();
            //si ho es ...
            if (esborro) {
                s += pelicula.toString();
                //esborrem
                list_Pelis.remove(i);
                tamany--;
            }
            i++;
        }
        return s;
    }

    /**
     * Retorna les pel·lícules amb les valoracions més altes
     * 
     * @return 
     */
    public String ranking() {
        String s = "";
        int i = 5;
        float valora = 0;
        
        //Mentre la valoració sigui més gran que 3 ...
        //(considerem que si una valoració es inferior a 3, aquesta pel·lícula té una valoració dolenta)
        while (i >= 3) {
            for (Pelicula pel : list_Pelis) {
                //per a cada pel·lícula calculem el ranking
                valora = pel.valoracio();
                if (valora >= i && valora < (i + 1)) {
                    s += "\n" + pel.toString();
                }
            }
            i--;
        }
        return s;
    }

    /**
     * Busca una pel·lícula segons un títol donat
     * 
     * @param nomPeli títol de la pel·lícula
     * @return 
     */
    public String trobarNomPeli(String nomPeli) {
        boolean trobat = false;
        int i = 0;
        String id = null;
        Pelicula pelicula;
        //Mentre tinguem pel·lícules i no haguem trobat el títol buscat ...
        while (i < list_Pelis.size() && !trobat) {
            //obtenim la pel·lícula actual
            pelicula = list_Pelis.get(i);
            //comparem títols
            trobat = pelicula.mateixTitol(nomPeli);
            //si son iguals els títols ...
            if (trobat) {
                //obtenim l'identificador de la pel·lícula
                id = pelicula.getIdPelicula();
            }

            i++;
        }

        return id;
    }

    /**
     * Visualitza una pel·lícula
     * 
     * @param posicio posició de la pel·lícula
     * @param c client que veu la pel·lícula
     * @return 
     */
    public String visualitzarPelicula(int posicio, Client c) {
        Pelicula tmp;
        tmp = list_Pelis.get(posicio);
        //marquem la pel·lícula com vista
        c.peliculaVista(tmp);

        return tmp.toString();

    }

    /**
     * Valora una pel·lícula
     * 
     * @param idPelicula identificador de la pel·lícula
     * @param idClient identificador del client
     * @param puntuacio valoració de la pel·lícula
     * @param data_act data actual
     */
    public void puntuaPelicula(String idPelicula, int idClient, int puntuacio, Data data_act) {
        Pelicula pelicula;
        pelicula = getPelicula(idPelicula);
        
        pelicula.valorarPeli(idClient, puntuacio, data_act);

    }

    /**
     * Obté pel·lícules recomanades per a un client
     * 
     * @param userLogat
     * @return 
     */
    public String obtindreRecomanacions(Client userLogat) {
        String generePref = userLogat.generePreferit();
        String pelisRecomanades = "";
        //Per a cada pel·lícula del catàleg ...
        for (Pelicula pelicula : list_Pelis) {
            boolean trobat;
            String titol_tmp;
            boolean haVist;
            //comparem generes de pel·lícules
            trobat = pelicula.mateixGenere(generePref);
            //si coincideixen ...
            if (trobat) {
                //obtenim el títol
                titol_tmp = pelicula.getTitol();
                //comprovem si ja s'ha vist
                haVist = userLogat.haVistPeli(titol_tmp);
                //si no s'ha vist, l'afegim a la llista de pel·lícules recomanades
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

    /**
     * Obté l'identificador d'una pel·lícula
     * 
     * @param opt posició de la pel·lícula
     * @return 
     */
    public String getIdPelicula(int opt) {
        String tmp = null;
        if (opt < list_Pelis.size()) {
            tmp = list_Pelis.get(opt).getIdPelicula();
        }
        return tmp;
    }

    /**
     * Obté una pel·lícula
     * 
     * @param idPelicula identificador de la pel·lícula
     * @return 
     */
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

    /**
     * Obté els generes d'una pel·lícula
     *  
     * @param pos posició de la pel·lícula
     * @return 
     */
    public ArrayList<Genere> getGeneresPelicula(int pos) {
        return list_Pelis.get(pos).getGeneres();
    }
}
