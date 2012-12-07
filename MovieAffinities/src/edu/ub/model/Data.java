/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.model;

/**
 *
 * @author maikel
 */
public class Data{
    
    private int dia;
    private int mes;
    private int any;
    
    public Data(int any){
        this.dia = 0;
        this.mes = 0;
        this.any = any;
    }
    
    public Data(int dia, int mes, int any){
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    
    public String toStringAnyPublicacio(){
        return String.valueOf(this.any);
    }
    
}
