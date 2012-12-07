/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 *
 * @author maikel
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
    private float cuotaMensual;
    private boolean estatStream;
    private int numPelisVistes;

    /**
     * 
     * @param idClient
     * @param nom
     * @param nomUsuari
     * @param dni
     * @param adresa
     * @param password
     * @param vip
     * @param numFaltes
     * @param nacionalitat
     * @param cuotaMensual
     * @param estatStream
     * @param numPelisVistes 
     */
    public Client(int idClient, String nom, String nomUsuari, String dni,
            String adreca, String password, boolean vip, int numFaltes) {
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
        this.nacionalitat = "Desconocido";
        this.cuotaMensual = 0;
        this.estatStream = false;
        this.numPelisVistes = 0;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public float getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(float cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isEstatStream() {
        return estatStream;
    }

    public void setEstatStream(boolean estatStream) {
        this.estatStream = estatStream;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public int getNumFaltes() {
        return numFaltes;
    }

    public void setNumFaltes(int numFaltes) {
        this.numFaltes = numFaltes;
    }

    public int getNumPelisVistes() {
        return numPelisVistes;
    }

    public void setNumPelisVistes(int numPelisVistes) {
        this.numPelisVistes = numPelisVistes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    @Override
    public String toString(){
        String r;
        r = "\nClient ID: " + this.idClient + "\n-----------------" +
		"\nNom: " + this.nom + "\nUsuari: " + this.nomUsuari + "\nDni: " + this.dni +
		"\nAdreça: " + this.adreca + "\nPassword: " + this.password + "\nEs VIP: " + this.vip +
		"\nNombre de faltes: " + this.numFaltes;        
        return r;
    }
    
}
