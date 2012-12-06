/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.controlador;

import edu.ub.model.Client;
import java.util.ArrayList;

/**
 *
 * @author maikel
 */
public class ControladorMovieAff {

    private ArrayList<Client> list_Clients;

    public ControladorMovieAff() {

        list_Clients = new ArrayList();

    }

    public void afegirClient(Client client) {

        list_Clients.add(client);

    }

    private void crearClient(int idClient, String nom, String nomUsuari,
            String dni, String adresa, String password, boolean vip, int numFaltes) {
    }
}
