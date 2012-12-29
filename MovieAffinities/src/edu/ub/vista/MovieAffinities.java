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
    Data dataActual;

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

        dataActual = new Data();
        _ctrlMovieAff = new ControladorMovieAff();

    }

    /**
     * Métode principal
     * @param args 
     */
    public static void main(String[] args) {

        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);

        // Creem un objecte principal
        MovieAffinities aplicacio = new MovieAffinities();

        // Iniciem la gestió del menú principal de l'aplicació
        aplicacio.gestioMenuPrincipal(sc);

    }

    /**
     * Menú principal de l'aplicació
     * 
     * @param sc 
     */
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

    /**
     * Submenú de client
     * 
     * @param sc 
     */
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

    /**
     * Submenú d'administrador
     * 
     * @param sc 
     */
    private void entradaAdministrador(Scanner sc) {

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
                    baixaPelicula();
                    break;
                case VEURE_PELIS_MES_VALORADES:
                    ranking();
                    break;
                case GENERAR_INFORME_CLIENT:
                    generarInforme();
                    break;
                case SORTIR:
                    break;
            }
        } while (opcio != MovieAffinities.OpcionsSubmenu2.SORTIR);
    }

    /**
     * Submenú dins de "Veure Catàleg"
     * 
     * @param sc 
     */
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

    /**
     * Submenú dins de "Valorar Pel·lícula"
     * 
     * @param sc 
     */
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

    //Metodes de l'aplicació
    
    /**
     * Mostra el catàleg de pel·lícules
     */
    public void mostrarCataleg() {
        System.out.println(_ctrlMovieAff.mostrarCataleg());
    }

    /**
     * Métode per registrar un nou client
     * 
     * @param sc 
     */
    public void registrar(Scanner sc) {
        //introduim les dades del registre
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
        //comprovem la disponibilitat del nom d'usuari
        boolean en_us = comprovaUser(nomUser);
        while (en_us) {
            System.out.println("Nom usuari en ús, escriu un altre:");
            nomUser = sc.next();
            en_us = comprovaUser(nomUser);
        }

        String pass;
        System.out.println("Password?");
        pass = sc.next();
        
        //afegim la data de naixment del client
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

    /**
     * Métode per logar-se a l'aplicació
     * 
     * @param sc 
     */
    public void login(Scanner sc) {
        //introduim les dades del login
        String nomUser;
        System.out.println("Nom d'usuari?");
        nomUser = sc.next();

        String pass;
        System.out.println("Contrasenya?");
        pass = sc.next();

        boolean admin;
        //comprovem si es administrador
        admin = _ctrlMovieAff.comprovaAdmin(nomUser, pass);
        //si no ho es ...
        if (!admin) {
            //comprovem el nom d'usuari i la contrasenya del client
            int nivell = _ctrlMovieAff.comprovaClients(nomUser, pass);
            switch (nivell) {
                case -2:
                    //error d'usuari
                    System.err.println("Nom d'usuari incorrecte.");
                    break;
                case -1:
                    //error de contrasenya
                    System.err.println("Contrasenya incorrecta.");
                    break;
                default:
                    //client logat correctament
                    userLogat = _ctrlMovieAff.obteClient(nivell - 1);
                    System.out.println("\nClient logat correctament.\n");
                    entradaClient(sc);
            }
        } else {
            userLogat = _ctrlMovieAff.obteAdministrador();
            System.out.println("\nAdministrador logat correctament.\n");
            entradaAdministrador(sc);
        }

    }

    /**
     * Métode per veure una pel·lícula
     * 
     * @param sc 
     */
    public void veurePelicula(Scanner sc) {
        //si no hi ha un stream obert
        if (!userLogat.isEstatStream()) {
            //mostrem el catàleg
            mostrarCataleg();

            System.out.println("\nQuina pel·lícula vols visualitzar.");
            System.out.print(">>");
            int posicio = sc.nextInt();

            ArrayList<Genere> generesPeli = _ctrlMovieAff.obteGeneresPeli(posicio);
            //si ha vist més de dues pel·lícules, li posem una falta
            if (userLogat.volVeurePeli(generesPeli)) {
                System.err.println("\nHas vist més de dues pel·lícules avui, tens una falta!");
            }

            System.out.println("\nVisualitzant la pel·lícula.........");

            System.out.println(_ctrlMovieAff.visualitzaPelicula(posicio - 1, userLogat));
            userLogat.setEstatStream(false);

            System.out.println("\t\n......streaming tancat.\n");
        //si hi ha un stream obert, avisem
        } else {
            System.out.println("Tens un altre canal de streaming obert!");
        }
    }

    /**
     * Métode per valorar una pel·lícula del catàleg
     * 
     * @param sc
     * @return 
     */
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

    /**
     * Métode per valorar una pel·lícula introduïnt el seu títol
     * 
     * @param sc
     * @return 
     */
    public String valorarPeliculaNom(Scanner sc) {

        String nomPeli;
        String idPeli;

        System.out.println("Introdueix el nom de la pel·lícula.");
        System.out.print(">>");
        nomPeli = sc.nextLine();

        idPeli = _ctrlMovieAff.trobarNomPeli(nomPeli);

        return idPeli;
    }

    /**
     * Métode per valorar una pel·lícula donat un identificador
     * 
     * @param idPelicula identificador de la pel·lícula
     * @param sc 
     */
    public void valorarPelicula(String idPelicula, Scanner sc) {

        if (idPelicula != null) {

            int puntuacio;
            int idClient;

            System.out.println("\nQuina es la teva valoracio? (Entre 1 i 5)");
            System.out.print(">>");
            puntuacio = sc.nextInt();
            //mentre la valoració no estigui entre 1 i 5
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

    /**
     * Métode per obtindre recomanacions de pel·lícules
     */
    public void obtenirRecomanacio() {
        System.out.println(_ctrlMovieAff.obtindreRecomanacions(userLogat));
    }

    /**
     * Métode que mostra les pel·lícules donades de baixa
     */
    public void baixaPelicula() {
        System.out.println("\nPel·lícules donades de baixa......");
        System.out.println(_ctrlMovieAff.baixaPelicula());
    }

    /**
     * Métode que mostra les pel·lícules amb més ranking
     */
    public void ranking() {
        System.out.println(_ctrlMovieAff.ranking());
    }

    /**
     * Métode que mostra el resultat de l'informe generat
     */
    public void generarInforme() {

        int mAct = dataActual.obtenirMesActual();

        if (_ctrlMovieAff.generarInforme(mAct)) {
            System.out.println(_ctrlMovieAff.mostrarInformeClients());
        }

    }

    /**
     * Métode que comprova si un nom d'usuari ja está en ús
     * 
     * @param nomUser nom d'usuari a comprovar
     * @return 
     */
    public boolean comprovaUser(String nomUser) {
        return _ctrlMovieAff.comprovaNomUser(nomUser);
    }
}