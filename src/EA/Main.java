package EA;

import java.io.IOException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Game.printGame;
import static EA.Tools.cls;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        boolean repeatAll, repeatSub;
        int chooser;
        ArrayList<Object> games = null;
        //Main menu
        do {
            repeatAll = true;
            repeatSub = false;
            cls();
            System.out.println("+++++++EA DB MANAGER+++++++");
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
            System.out.println("+       [0] Exit          +");
            System.out.println("+++++++++++++++++++++++++++");
            chooser = Read.Int();
            switch (chooser) {
                case 1:
                    //Games
                    do {
                        repeatSub = true;
                        cls();
                        System.out.println("+++++++++++GAMES+++++++++++");
                        System.out.println("+      [1] Game List      +");
                        System.out.println("+       [2] Search        +");
                        System.out.println("+     [3] Delete Game     +");
                        System.out.println("+      [4] Edit Game      +");
                        System.out.println("+-------------------------+");
                        System.out.println("+        [0] Back         +");
                        System.out.println("+-------------------------+");
                        System.out.println("+ To add a new game go to +");
                        System.out.println("+    franchises section   +");
                        System.out.println("+-------------------------+");
                        chooser = Read.Int();
                        switch (chooser) {
                            case 1:
                                if (games != null) {
                                    games.clear();
                                }
                                games = select("Games");
                                System.out.println("GAME LIST:");
                                System.out.println("``````````````````````````");
                                printGame(games);
                                break;
                            case 2:
                                games.clear();
                                System.out.println("Searching for a game...");
                                System.out.println("Type the name of the game:");
                                String gameName = Read.String();
                                games = select("Games", "Name LIKE '%" + gameName + "%'");
                                if (games.size() != 0) {
                                    System.out.println(games.size() + " games found:");
                                    printGame(games);
                                } else {
                                    System.out.println("No games found");
                                }
                                break;
                            case 3:
                                //TODO: Añadir delete
                            case 4:
                                //TODO: Añadir update
                            case 0:
                                repeatSub = false;
                                break;
                        }
                        break;
                    } while (repeatSub);
                case 2:
                    //Franchises
                    cls();
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
                    System.out.println("+++++++++++++++++++++++++++++++++++");
                    break;
                case 3:
                    //Studios
                    cls();
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
                    System.out.println("++++++++++++++++++++++++++++++++++++");
                    break;
                case 4:
                    //Developers
                    cls();
                    System.out.println("++++++++++++++DEVELOPERS+++++++++++++++");
                    System.out.println("+           [1] Dev List              +");
                    System.out.println("+            [2] Search               +");
                    System.out.println("+         [3] Add Developer           +");
                    System.out.println("+       [4] Delete Developer          +");
                    System.out.println("+        [5] Edit Developer           +");
                    System.out.println("+-------------------------------------+");
                    System.out.println("+        [6] Add Game to Dev          +");
                    System.out.println("+     [7] Remove Game from Dev        +");
                    System.out.println("+-------------------------------------+");
                    System.out.println("+   [8] List of Developing Games      +");
                    System.out.println("+-------------------------------------+");
                    System.out.println("+            [0] Back                 +");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    break;
                case 5:
                    //Clients
                    cls();
                    System.out.println("[1] Client list");
                    System.out.println("[2] Add new client");
                    System.out.println("[3] Delete client");
                    System.out.println("[4] Edit client");
                    System.out.println("---------------");
                    System.out.println("[0] Back");
                    break;
                case 6:
                    //Divisions
                    cls();
                    System.out.println("[1] Division list");
                    System.out.println("[2] Add division");
                    System.out.println("[3] Delete division");
                    System.out.println("[4] Edit division");
                    System.out.println("---------------");
                    System.out.println("[0] Back");
                    break;
                case 0:
                    repeatAll = false;

            }
        } while (repeatAll);

    }


}
