package EAHibernate;

import EA.Read;

import java.io.IOException;
import java.util.ArrayList;


import static EA.Game.printGame;
import static EA.Tools.cls;
import static EAHibernate.Games.*;

public class Main {
    public static void main(final String[] args) throws IOException {

        boolean repeatAll, repeatSub;
        int chooser;

        //Main menu
        do {
            repeatAll = true;
            repeatSub = false;
            cls();
            System.out.println("+++++++EA DB MANAGER+++++++");
            System.out.println("+++++++++HIBERNATE+++++++++");
            System.out.println("+       [1] Games         +");
            System.out.println("+    [2] Franchises       +");
            System.out.println("+      [3] Studios        +");
            System.out.println("+-------------------------+");
            System.out.println("+     [4] Developers      +");
            System.out.println("+-------------------------+");
            System.out.println("+      [5] Clients        +");
            System.out.println("+-------------------------+");
            System.out.println("+     [6] Divisions       +");
            System.out.println("+-------------------------+");
            System.out.println("+      [7] Sales          +");
            System.out.println("+-------------------------+");
            System.out.println("+       [0] Exit          +");
            chooser = Read.Int("+++++++++++++++++++++++++++");
            switch (chooser) {
                case 1:
                    //Games
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> games = null;
                        System.out.println("+++++++++++GAMES+++++++++++");
                        System.out.println("+      [1] Game List      +");
                        System.out.println("+       [2] New Game      +");
                        System.out.println("+     [3] Delete Game     +");
                        System.out.println("+      [4] Edit Game      +");
                        System.out.println("+-------------------------+");
                        System.out.println("+        [0] Back         +");
                        chooser = Read.Int("+-------------------------+");
                        switch (chooser) {

                            case 1:

                                printGames();
                                Read.Pause();
                                break;
                            case 2:

                                insertGame();
                                Read.Pause();
                                break;
                        }
                    } while (repeatAll);
            }}while (repeatAll);}}
                                /*
                            case 3:
                                deleteGame();
                            case 4:
                                //TODO: Añadir update
                            case 0:
                                repeatSub = false;
                                break;
                        }
                        break;
                    } while (repeatSub);
                    break;
                case 2:
                    //Franchises
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> franchises = null;
                        System.out.println("++++++++++++FRANCHISES+++++++++++++");
                        System.out.println("+        [1] Franchise List       +");
                        System.out.println("+---------------------------------+");
                        System.out.println("+        [2] Add Franchise        +");
                        System.out.println("+      [3] Delete Franchise       +");
                        System.out.println("+---------------------------------+");
                        System.out.println("+    [4] Add Game to Franchise    +");
                        System.out.println("+  [5] Delete Game from Franchise +");
                        System.out.println("+---------------------------------+");
                        System.out.println("+       [6] Edit Franchise        +");
                        System.out.println("+---------------------------------+");
                        System.out.println("+            [0] Back             +");
                        chooser = Read.Int("+++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                franchises = select("Franchises");
                                System.out.println("FRANCHISE LIST:");
                                System.out.println("``````````````````````````");
                                printFranchise(franchises);
                                Read.Pause();
                                break;
                            case 2:
                                insertFranchise();
                                break;
                            case 3:
                                deleteFranchise();
                                break;
                            case 4:
                                addGame();
                                break;
                            case 5:
                                deleteGameF();
                                break;
                            case 6:
                                updateFranchise();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                        }
                        break;
                    } while (repeatSub);
                case 3:
                    //Studios
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> studios = null;
                        System.out.println("++++++++++++++STUDIOS+++++++++++++++");
                        System.out.println("+         [1] Studio List          +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+         [2] Add Studio           +");
                        System.out.println("+       [3] Delete Studio          +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+   [4] Add Franchise to Studio    +");
                        System.out.println("+ [5] Delete Franchise from Studio +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+        [6] Edit Studio           +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+            [0] Back              +");
                        chooser = Read.Int("++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                studios = select("Studios");
                                System.out.println("Studio list:");
                                System.out.println("``````````````````````````");
                                printStudio(studios);
                                Read.Pause();
                                break;
                            case 2:
                                insertStudios("Studio");
                                break;
                            case 3:
                            case 0:
                                repeatSub = false;
                                break;
                        }
                        break;
                    } while (repeatSub);
                    break;

                case 4:
                    //Developers
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> developers = null;
                        System.out.println("++++++++++++++DEVELOPERS+++++++++++++++");
                        System.out.println("+           [1] Dev List              +");
                        System.out.println("+         [2] Add Developer           +");
                        System.out.println("+       [3] Delete Developer          +");
                        System.out.println("+        [4] Edit Developer           +");
                        System.out.println("+-------------------------------------+");
                        System.out.println("+        [5] Add Game to Dev          +");
                        System.out.println("+     [6] Remove Game from Dev        +");
                        System.out.println("+-------------------------------------+");
                        System.out.println("+   [7] List of Developing Games      +");
                        System.out.println("+-------------------------------------+");
                        System.out.println("+            [0] Back                 +");
                        chooser = Read.Int("+++++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {

                            case 1:
                                developers = select("Developers");
                                System.out.println("DEVELOPER LIST:");
                                System.out.println("``````````````````````````");
                                printDeveloper(developers);
                                Read.Pause();
                                break;
                            case 2:
                                insertDevelopers();
                                break;
                            case 3:
                                deleteDeveloper();
                                break;
                            case 4:
                                updateDeveloper();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                            //TODO: El resto
                        }
                    } while (repeatSub);
                    break;
                case 5:
                    //Clients
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> clients = null;
                        System.out.println("++++++++++++++CLIENTS+++++++++++++++");
                        System.out.println("+       [1] Client list            +");
                        System.out.println("+      [2] Add new client          +");
                        System.out.println("+       [3] Delete client          +");
                        System.out.println("+        [4] Edit client           +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+            [0] Back              +");
                        chooser = Read.Int("++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                clients = select("Clients");
                                System.out.println("CLIENT LIST:");
                                System.out.println("``````````````````````````");
                                printClient(clients);
                                Read.Pause();
                                break;
                            case 2:
                                insertClients();
                                break;
                            case 3:
                                deleteClients();
                                break;
                            case 4:
                                updateClient();
                            case 0:
                                repeatSub = false;
                                break;
                        }
                        break;
                    } while (repeatSub);
                    break;
                case 6:
                    //Divisions
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> divisions = null;
                        System.out.println("++++++++++++++DIVISIONS+++++++++++++++");
                        System.out.println("+        [1] Division list           +");
                        System.out.println("+        [2] Add division            +");
                        System.out.println("+       [3] Delete division          +");
                        System.out.println("+        [4] Edit division           +");
                        System.out.println("+------------------------------------+");
                        System.out.println("+             [0] Back               +");
                        chooser = Read.Int("++++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                divisions = select("divisions");
                                System.out.println("DIVISION LIST:");
                                System.out.println("``````````````````````````");
                                printDivision(divisions);
                                Read.Pause();
                                break;
                            case 2:
                                insertDivisions();
                                break;
                            case 3:
                                deleteDivision();
                                break;
                            case 4:
                                break;//TODO:Update
                            case 0:
                                repeatAll = false;
                                break;
                        }
                    } while (repeatSub);
                case 7:
                    printSales();
                default://Switch general
                    break;
            }
        } while (repeatAll);

    }
    }

*/