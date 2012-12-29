package edu.ub.vista;

import edu.ub.controlador.ControladorMovieAff;
import edu.ub.model.Client;
import edu.ub.model.Data;
import edu.ub.model.Genere;
import edu.ub.model.Pelicula;
import java.util.ArrayList;
import java.util.Calendar;
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

    static private enum OpcionsSubmenu3 {

        VEURE_CATALEG, VEURE_PELIS_RECOMANADES, ENRERE
    }

    static private enum OpcionsSubmenu4 {

        VEURE_CATALEG, INTRODUIR_NOM, ENRERE
    }
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal = {"Registrar-se",
        "Logar-se",
        "Veure catàleg de pel·lícules",
        "Sortir"};
    // Declarem descripcions personalitzades per a les opcions del menú secundari 1
    static private String[] descMenu1 = {"Veure catàleg",
        "Veure pel·lícula",
        "Valorar pel·lícula",
        "Obtenir recomanacions de pel·lícules",
        "Sortir"};
    // Declarem descripcions personalitzades per a les opcions del menú secundari 2
    static private String[] descMenu2 = {"Eliminar pel·lícula",
        "Veure pel·lícules més valorades",
        "Generar informe de clients",
        "Sortir"};
    static private String[] descMenu3 = {
        "Consultar catàleg", "Veure pel·lícules recomanades", "Enrere"
    };
    static private String[] descMenu4 = {
        "Veure el catàleg", "Introduir el nom de la pel·lícula", "Enrere"
    };

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
                    registrar(sc);
                    break;
                case LOGIN:
                    //LOGIN
                    login(sc);
                    break;
                case VEURE_CATALEG:
                    mostrarCataleg();
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
                    veureCataleg(sc);
                    break;
                case VEURE_PELI:
                    veurePelicula(sc);
                    break;
                case VALORAR_PELI:
                    valorarPelicula(sc);
                    break;
                case OBTENIR_PELI_NO_VISTA:
                    obtenirRecomanacio();
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

    public void veureCataleg(Scanner sc) {
        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<MovieAffinities.OpcionsSubmenu3> menu = new Menu<MovieAffinities.OpcionsSubmenu3>("Consultar catàleg o obtindre recomanacions?",
                MovieAffinities.OpcionsSubmenu3.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu3);

        // Obtenim una opció des del menú i fem les accions pertinents
        MovieAffinities.OpcionsSubmenu3 opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries
            switch (opcio) {
                case VEURE_CATALEG:
                    mostrarCataleg();
                    break;
                case VEURE_PELIS_RECOMANADES:
                    obtenirRecomanacio();
                    break;
                case ENRERE:
                    break;
            }

        } while (opcio != MovieAffinities.OpcionsSubmenu3.ENRERE);
    }

    public void valorarPelicula(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<MovieAffinities.OpcionsSubmenu4> menu = new Menu<MovieAffinities.OpcionsSubmenu4>("Com vols valorar la pel·lícula?", MovieAffinities.OpcionsSubmenu4.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu4);

        // Obtenim una opció des del menú i fem les accions pertinents
        MovieAffinities.OpcionsSubmenu4 opcio = null;

        String idPelicula;

        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries
            switch (opcio) {
                case VEURE_CATALEG:
                    idPelicula = valorarPeliculaCataleg(sc);
                    valorarPelicula(idPelicula, sc);
                    break;
                case INTRODUIR_NOM:
                    idPelicula = valorarPeliculaNom(sc);
                    valorarPelicula(idPelicula, sc);
                    break;
                case ENRERE:
                    break;
            }

        } while (opcio != MovieAffinities.OpcionsSubmenu4.ENRERE);

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
    public void mostrarCataleg() {
        System.out.println(_ctrlMovieAff.mostrarCataleg());
    }

    /**
     *
     */
    public void registrar(Scanner sc) {
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
        
        System.out.println(client.toString());

        _ctrlMovieAff.afegirClient(client);
        
        System.out.println("\nRegistre correcte!\n");

    }

    public void login(Scanner sc) {
        String nomUser;
        System.out.println("Nom d'usuari?");
        nomUser = sc.next();

        String pass;
        System.out.println("Contrasenya?");
        pass = sc.next();
        
        boolean admin;
        admin = _ctrlMovieAff.comprovaAdmin(nomUser, pass);

        if (!admin) {
            int nivell = _ctrlMovieAff.comprovaClients(nomUser, pass);
            switch (nivell) {
                case -2:
                    System.err.println("Nom d'usuari mal introduit.");
                    break;
                case -1:
                    System.err.println("Password mal introduit.");
                    break;
                default:
                    userLogat = _ctrlMovieAff.obteClient(nivell - 1);
                    System.out.println("\nClient logat correctament.\n");
                    entradaClient(sc);
            }
        } else {
            userLogat = _ctrlMovieAff.obteAdministrador();
            System.out.println("\nAdministrador logat correctament.\n");
            entradaAdmin(sc);
        }

    }

    public void veurePelicula(Scanner sc) {

        if (!userLogat.isEstatStream()) {

            mostrarCataleg();

            System.out.println("\nQuina pel·lícula que vols visualitzar.");
            System.out.print(">>");
            int posicio = sc.nextInt();

            ArrayList<Genere> generesPeli = _ctrlMovieAff.obteGenerePeli(posicio);

            if (userLogat.volVeurePeli(generesPeli)) {
                System.err.println("\nHas vist més de dues pel·lícules avui, tens una falta!");
            }

            System.out.println("\nVisualitzant la pel·lícula.........");

            System.out.println(_ctrlMovieAff.visualitzaPelicula(posicio - 1, userLogat));
            userLogat.setEstatStream(false);

            System.out.println("\t\n......streaming tancat.\n");

        } else {
            System.out.println("Tens un altre canal de streaming obert!");
        }
    }

    public String valorarPeliculaCataleg(Scanner sc) {

        int posPeli;
        String idPeli;

        mostrarCataleg();

        System.out.println("\nQuina pel·lícula vols puntuar?");
        System.out.print(">>");
        posPeli = sc.nextInt();

        idPeli = _ctrlMovieAff.obteIdPelicula(posPeli - 1);

        return idPeli;

    }

    public String valorarPeliculaNom(Scanner sc) {

        String nomPeli;
        String idPeli;

        System.out.println("Introdueix el nom de la pel·lícula.");
        System.out.print(">>");
        nomPeli = sc.nextLine();

        idPeli = _ctrlMovieAff.trobarNomPeli(nomPeli);

        return idPeli;
    }

    public void valorarPelicula(String idPelicula, Scanner sc) {

        if (idPelicula != null) {

            int puntuacio;
            int idClient;

            System.out.println("\nQuina es la teva valoracio? (Entre 1 i 5)");
            System.out.print(">>");
            puntuacio = sc.nextInt();

            while (puntuacio < 1 || puntuacio > 5) {
                System.err.println("\nValoració incorrecte. Introdueix una valoració. (Entre 1 i 5)");
                System.out.print(">>");
                puntuacio = sc.nextInt();
            }

            Calendar c = Calendar.getInstance();
            Data data_act = new Data(c.get(Calendar.DATE), c.get(Calendar.MONTH), c.get(Calendar.YEAR));

            userLogat.puntuaPelicula(idPelicula, puntuacio, data_act);

            idClient = userLogat.getIdClient();

            _ctrlMovieAff.puntuaPelicula(idPelicula, idClient, puntuacio, data_act);

        } else {
            System.err.println("\nNo s'ha trobat la pel·lícula, torna-ho a intentar.");
        }

    }

    public void obtenirRecomanacio() {
        System.out.println(_ctrlMovieAff.obtindreRecomanacions(userLogat));
    }

    public boolean comprovaUser(String nomUser) {

        return _ctrlMovieAff.comprovaNomUser(nomUser);

    }
}