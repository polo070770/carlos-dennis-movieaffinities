/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.ArrayList;

/**
 * Clase Client
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Client {

    //Atributs per defecte
    private int idClient;
    private String nom;
    private String nomUsuari;
    private String dni;
    private String adreca;
    private String password;
    private boolean vip;
    private int numFaltes;
    //Atributs adicionals
    private String nacionalitat;
    private double cuotaMensual;
    private boolean estatStream;
    private int numPelisVistes;
    private ArrayList<Valoracio> valoracions_client;
    private Data data_naixament;
    private ArrayList<Pelicula> list_PelisVistes;
    private ArrayList<Genere> generesVistes;

    /**
     * Constructor del Client (USUARI)
     *
     * @param idClient id del client
     * @param nom nom del client
     * @param nomUsuari nom d'usuari del client
     * @param dni dni del client
     * @param adresa adreça del client
     * @param password contrasenya del client
     * @param vip estatus del client
     * @param numFaltes nombre de faltes del client
     * @param nacionalitat nacionalitat del client
     * @param cuotaMensual cuota del client
     * @param estatStream estat de la pel·lícula que visualitza
     * @param numPelisVistes nombre de pel·lícules vistes
     */
    public Client(int idClient, String nom, String nomUsuari, String dni,
            String adreca, String password, boolean vip, int numFaltes, Data data_naixament, String nacionalitat) {
        //Per defecte
        this.idClient = idClient;
        this.nom = nom;
        this.nomUsuari = nomUsuari;
        this.dni = dni;
        this.adreca = adreca;
        this.password = password;
        this.vip = vip;

        //Adicionals
        this.numFaltes = numFaltes;
        this.nacionalitat = nacionalitat;
        this.cuotaMensual = 0;
        this.estatStream = false;
        this.numPelisVistes = 0;
        this.valoracions_client = new ArrayList();
        this.data_naixament = data_naixament;
        this.list_PelisVistes = new ArrayList();
        this.generesVistes = new ArrayList();

    }

    /**
     * Constructor del Client (ADMINISTRADOR)
     *
     * @param nom nom de l'administrador
     * @param nomUsuari nom d'usuari de l'administrador
     * @param password contrasenya de l'administrador
     */
    public Client(String nom, String nomUsuari, String password) {
        this.nom = nom;
        this.nomUsuari = nomUsuari;
        this.password = password;
    }

    /**
     * Retorna l'adreça
     *
     * @return
     */
    public String getAdreca() {
        return adreca;
    }

    /**
     * Canvia l'adreça
     *
     * @param adreca
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Retorna la cuota mensual
     *
     * @return
     */
    public double getCuotaMensual() {
        return cuotaMensual;
    }

    /**
     * Canvia la cuota mensual
     *
     * @param cuotaMensual
     */
    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    /**
     * Retorna el dni
     *
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     * Canvia el dni
     *
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Retorna l'estat del Stream
     *
     * @return
     */
    public boolean isEstatStream() {
        return estatStream;
    }

    /**
     * Canvia l'estat del Stream
     *
     * @param estatStream
     */
    public void setEstatStream(boolean estatStream) {
        this.estatStream = estatStream;
    }

    /**
     * Retorna l'id
     *
     * @return
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Canvia l'id
     *
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retorna la nacionalitat
     *
     * @return
     */
    public String getNacionalitat() {
        return nacionalitat;
    }

    /**
     * Canvia la nacionalitat
     *
     * @param nacionalitat
     */
    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
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
     * Retorna el nom d'usuari
     *
     * @return
     */
    public String getNomUsuari() {
        return nomUsuari;
    }

    /**
     * Canvia el nom d'usuari
     *
     * @param nomUsuari
     */
    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    /**
     * Retorna el nombre de faltes
     *
     * @return
     */
    public int getNumFaltes() {
        return numFaltes;
    }

    /**
     * Canvia el nombre de faltes
     *
     * @param numFaltes
     */
    public void setNumFaltes(int numFaltes) {
        this.numFaltes = numFaltes;
    }

    /**
     * Retorna el nombre de pel·lícules vistes
     *
     * @return
     */
    public int getNumPelisVistes() {
        return numPelisVistes;
    }

    /**
     * Canvia el nombre de pel·lícules vistes
     *
     * @param numPelisVistes
     */
    public void setNumPelisVistes(int numPelisVistes) {
        this.numPelisVistes = numPelisVistes;
    }

    /**
     * Retorna la contrasenya
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Canvia la contrasenya
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna l'estatus
     *
     * @return
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * Canvia l'estatus
     *
     * @param vip
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * Mètode que retorna un string amb les dades del client
     *
     * @return r + s
     */
    @Override
    public String toString() {
        String s = "\nValoracions: ";
        for (Valoracio v : valoracions_client) {
            s += v.getValoracio() + " en la peli " + v.getIdPelicula() + ". \n";
        }

        String r;
        r = "\nClient ID: " + this.idClient + "\n-----------------"
                + "\nNom: " + this.nom + "\nUsuari: " + this.nomUsuari + "\nDni: " + this.dni
                + "\nAdreça: " + this.adreca + "\nPassword: " + this.password + "\nEs VIP: " + this.vip
                + "\nNombre de faltes: " + this.numFaltes;
        return r + s;
    }

    /**
     * Mètode per afegir una valoració
     *
     * @param valoracio
     */
    public void addValoracio(Valoracio valoracio) {
        this.valoracions_client.add(valoracio);
    }

    /**
     * Métode que indica que un client vol veure una pel·lícula d'un dels seus
     * generes preferits. Suma el cost de la pel·lícula a la cuota mensual.
     * Si cal posa una falta.
     * 
     * @param generesPelis llista de generes
     * @return 
     */
    public boolean volVeurePeli(ArrayList<Genere> generesPelis) {
        boolean falta = false;
        
        //augmentem el nombre de pel·lícules 
        this.numPelisVistes++;
        //posem l'estat del stream com a obert
        this.estatStream = true;
        
        //per cada genere en la llista de generes
        for (Genere genere : generesPelis) {
            //afegim el genere de la pel·lícula al la llista de generes
            generesVistes.add(genere);
        }
        //si el nombre de pel·lícules es major que 2 ...
        if (getNumPelisVistes() > 2) {
            //posem una falta
            this.numFaltes++;
            falta = true;
        }

        //Si es vip ...
        if (isVip()) {
            //cobrem la pel·lícula a 0.9
            this.cuotaMensual = this.cuotaMensual + 0.9;
        //si no ...
        } else {
            //la cobrem a 1
            this.cuotaMensual = this.cuotaMensual + 1;
        }

        return falta;
    }

    /**
     * Afegeix una pel·lícula a la llista de pel·lícules vistes pel client
     * 
     * @param tmp pel·lícula que s'acaba de veure
     */
    public void peliculaVista(Pelicula tmp) {
        list_PelisVistes.add(tmp);
    }

    /**
     * Valora una pel·lícula
     * 
     * @param idPelicula identificador de la pel·lícula
     * @param puntuacio valoració de la pel·lícula
     * @param dataValoracio data en que es fa la valoració
     */
    public void puntuaPelicula(String idPelicula, int puntuacio, Data dataValoracio) {
        int idValoracio;
        idValoracio = valoracions_client.size();
        Valoracio valoracio = new Valoracio(idPelicula, this.idClient, puntuacio, dataValoracio, idValoracio);

        valoracions_client.add(valoracio);
    }

    /**
     * Estableix els generes preferits d'un client
     * 
     * @return 
     */
    public String generePreferit() {
        String generePref, genere_1, genere_2;
        generePref = "";

        int i, j;
        i = 0;
        int cont_1, cont_2;
        cont_1 = 0;

        while (i < generesVistes.size()) {
            j = 0;
            cont_2 = 0;
            genere_1 = generesVistes.get(i).getNom();

            while (j < generesVistes.size()) {
                genere_2 = generesVistes.get(j).getNom();

                if (genere_1.equals(genere_2)) {
                    cont_2++;
                }

                j++;
            }

            if (cont_2 > cont_1) {
                generePref = genere_1;
                cont_1 = cont_2;
            }
            i++;
        }

        return generePref;
    }

    /**
     * Comprova si una pel·lícula ja ha sigut vista per un client
     * 
     * @param titol_tmp títol de la pel·lícula
     * @return 
     */
    public boolean haVistPeli(String titol_tmp) {
        boolean vista = false;
        int i = 0;
        Pelicula pelicula;

        while (i < list_PelisVistes.size() && !vista) {

            pelicula = list_PelisVistes.get(i);
            vista = pelicula.mateixTitol(titol_tmp);
            i++;
        }

        return vista;
    }

    /**
     * Mostra l'informe generat
     * 
     * @return 
     */
    public String mostrarInforme() {
        String r;
        r = "\nClient ID: " + this.idClient + "\n-----------------"
                + "\nNom: " + this.nom + "\nUsuari: " + this.nomUsuari + "\nDni: " + this.dni
                + "\nAdreça: " + this.adreca + "\nPassword: " + this.password + "\nEs VIP: " + this.vip
                + "\nNombre de faltes: " + this.numFaltes
                + "\nCuota mensual: " + this.cuotaMensual;

        String s = "\nPelis vistes: ";
        for (Pelicula pel : list_PelisVistes) {
            s = s + "\n" + pel.toString();
        }
        return r + s;
    }
}
