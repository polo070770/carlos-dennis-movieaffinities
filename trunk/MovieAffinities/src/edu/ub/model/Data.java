/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

import java.util.Calendar;

/**
 * Clase Data
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Data {

    private int dia;
    private int mes;
    private int any;

    public Data() {
        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH);
        any = c.get(Calendar.YEAR);
    }

    /**
     * Constructor (PRODUCTORA,PEL·LÍCULA)
     *
     * @param any any de publicació o producció
     */
    public Data(int any) {
        this.dia = 0;
        this.mes = 0;
        this.any = any;
    }

    /**
     * Constructor (DATA DE NAIXEMENT)
     *
     * @param dia dia de naixement
     * @param mes mes de naixement
     * @param any any de naixement
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Converteix a string l'any de publicació
     * 
     * @return 
     */
    public String toStringAnyPublicacio() {
        return String.valueOf(this.any);
    }

    /**
     * Obté el mes actual
     * 
     * @return 
     */
    public int obtenirMesActual() {
        return this.mes;
    }
}
