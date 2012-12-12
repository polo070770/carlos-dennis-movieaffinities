/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 * Clase Data
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class Data{
    
    private int dia;
    private int mes;
    private int any;
    
    /**
     * Constructor (PRODUCTORA,PEL·LÍCULA)
     * @param any any de publicació o producció
     */
    public Data(int any){
        this.dia = 0;
        this.mes = 0;
        this.any = any;
    }
    
    /**
     * Constructor (DATA DE NAIXEMENT)
     * @param dia dia de naixement
     * @param mes mes de naixement
     * @param any any de naixement
     */
    public Data(int dia, int mes, int any){
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    
    public String toStringAnyPublicacio(){
        return String.valueOf(this.any);
    }
    
}
