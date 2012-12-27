package edu.ub.vista;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ub.controlador.ControladorMovieAff;
import edu.ub.model.Client;
import edu.ub.model.Data;
import java.util.Scanner;

/**
 *
 * Clase Main Movie Affinities
 *
 * @author Michel Dennis Quitaquis i Carlos Cortés Sánchez
 */
public class MovieAffinities {

    ControladorMovieAff _ctrlMovieAff;
    Client userLogat;

    static private enum OpcionsMenuPrincipal {

        REGISTRE, LOGIN, VEURE_CATALEG, SORTIR
    };

    static private enum OpcionsSubmenu1 {

        VEURE_CATALEG, VEURE_PELI, VALORAR_PELI, OBTENIR_PELI_NO_VISTA, SORTIR
    };

    static private enum OpcionsSubmenu2 {

        ELIMINAR_PELI, VEURE_PELIS_MES_VALORADES, GENERAR_INFORME_CLIENT, SORTIR
    };
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal = {"Registrar-se",
        "Logar-se",
        "Veure catàleg de pel·lícules",
        "Sortir"};
    // Declarem descripcions personalitzades per a les opcions del menú secundari 1
    static private String[] descMenu1 = {"Veure catàleg de pel·lícules",
        "Veure pel·lícula",
        "Valorar pel·lícula",
        "Obtenir recomanacions de pel·lícules",
        "Sortir"};
    // Declarem descripcions personalitzades per a les opcions del menú secundari 2
    static private String[] descMenu2 = {"Eliminar pel·lícula",
        "Veure pel·lícules més valorades",
        "Generar informe de clients",
        "Sortir"};

    /**
     * Constructor
     */
    public MovieAffinities() {

        _ctrlMovieAff = new ControladorMovieAff();

    }

    public static void main(String[] args) {

        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);

        // Creem un objecte principal
        MovieAffinities aplicacio = new MovieAffinities();

        // Iniciem la gestió del menú principal de l'aplicació
        aplicacio.gestioMenuPrincipal(sc);

        MovieAffinities aplicacioUb = new MovieAffinities();

        aplicacioUb.mostraClients();
        aplicacioUb.mostraCataleg();

    }

    private void gestioMenuPrincipal(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<MovieAffinities.OpcionsMenuPrincipal> menu = new Menu<MovieAffinities.OpcionsMenuPrincipal>("Menu Principal", MovieAffinities.OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        MovieAffinities.OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries
            switch (opcio) {
                case REGISTRE:
                    _ctrlMovieAff.afegirClient(registrar(sc));
                    System.out.println("Registre correcte!");
                    mostraClients();
                    break;
                case LOGIN:
                    //LOGIN
                    break;
                case VEURE_CATALEG:
                    mostraCataleg();
                    break;
                case SORTIR:
                    System.out.println("Adeu!");
                    break;
            }

        } while (opcio != MovieAffinities.OpcionsMenuPrincipal.SORTIR);
    }

    private void entradaClient(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<MovieAffinities.OpcionsSubmenu1> menu = new Menu<MovieAffinities.OpcionsSubmenu1>("Menu Client", MovieAffinities.OpcionsSubmenu1.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu1);

        // Obtenim una opció des del menú i fem les accions pertinents
        MovieAffinities.OpcionsSubmenu1 opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries
            switch (opcio) {
                case VEURE_CATALEG:
                    break;
                case VEURE_PELI:
                    break;
                case VALORAR_PELI:
                    break;
                case OBTENIR_PELI_NO_VISTA:
                    break;
                case SORTIR:
                    break;
            }

        } while (opcio != MovieAffinities.OpcionsSubmenu1.SORTIR);
    }

    private void entradaAdmin(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<MovieAffinities.OpcionsSubmenu2> menu = new Menu<MovieAffinities.OpcionsSubmenu2>("Menu Administrador", MovieAffinities.OpcionsSubmenu2.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu2);

        // Obtenim una opció des del menú i fem les accions pertinents
        MovieAffinities.OpcionsSubmenu2 opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries
            switch (opcio) {
                case ELIMINAR_PELI:
                    break;
                case VEURE_PELIS_MES_VALORADES:
                    break;
                case GENERAR_INFORME_CLIENT:
                    break;
                case SORTIR:
                    break;
            }

        } while (opcio != MovieAffinities.OpcionsSubmenu2.SORTIR);
    }

    /**
     * Mostra la llista de clients
     */
    public void mostraClients() {
        System.out.println(_ctrlMovieAff.getStringListClients());
    }

    /**
     * Mostra el catàleg de pel·lícules
     */
    public void mostraCataleg() {
        System.out.println(_ctrlMovieAff.getStringCataleg());
    }

    /**
     *
     */
    public Client registrar(Scanner sc) {
        String nom;
        System.out.println("\nNom?");
        nom = sc.nextLine();

        String nacionalitat;
        System.out.println("Nacionalitat?");
        nacionalitat = sc.nextLine();

        String adreca;
        System.out.println("Adreça?");
        adreca = sc.nextLine();

        String dni;
        System.out.println("Dni?");
        dni = sc.next();

        int dia;
        System.out.println("Dia de naixement?");
        dia = sc.nextInt();

        int mes;
        System.out.println("Mes de naixement?");
        mes = sc.nextInt();

        int any;
        System.out.println("Any de naixement?");
        any = sc.nextInt();

        String nomUser;
        System.out.println("Nom d'usuari?");
        nomUser = sc.next();
        boolean en_us = comprovaUser(nomUser);
        while (en_us) {
            System.out.println("Nom usuari en ús, escriu un altre:");
            nomUser = sc.next();
            en_us = comprovaUser(nomUser);
        }

        String pass;
        System.out.println("Password?");
        pass = sc.next();

        Client client;
        Data data;
        data = new Data(dia, mes, any);

        int id = _ctrlMovieAff.obteTamanyClients() + 1;

        client = new Client(id, nom, nomUser, dni,
                adreca, pass, false, 0, data, nacionalitat);

        return client;
    }

    public void login(Scanner sc) {
        String nomUsuari;
        System.out.println("Nom d'usuari?");
        nomUsuari = sc.nextLine();

        String pass;
        System.out.println("Contrasenya?");
        pass = sc.next();

        if (!_ctrlMovieAff.comprovaAdmin(nomUsuari, pass)) {
            int nivell = _ctrlMovieAff.comprovaClients(nomUsuari, pass);
            switch (nivell) {
                case -2:
                    System.out.println("Nom d'usuari mal introduit.");
                case -1:
                    System.out.println("Password mal introduit.");
                default:
                    userLogat = _ctrlMovieAff.obteClient(nivell);
                    System.out.println("Client logat correctament.");
                    entradaClient(sc);
            }
        } else {
            userLogat = _ctrlMovieAff.obteAdministrador();
            System.out.println("Administrador logat correctament.");
            entradaAdmin(sc);
        }

    }

    private boolean comprovaUser(String nomUser) {
        return _ctrlMovieAff.comprovaNomUser(nomUser);
    }
}