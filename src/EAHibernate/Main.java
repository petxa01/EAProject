package EAHibernate;

import EA.Read;

import java.io.IOException;
import java.util.ArrayList;

import static EA.Tools.cls;
import static EAHibernate.Games.*;
import static EAHibernate.Studios.deleteStudios;
import static EAHibernate.Studios.insertStudio;
import static EAHibernate.Studios.updateStudios;

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
            System.out.println("+      [4] Sales          +");
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
                            case 3:
                                deleteGames();
                                Read.Pause();
                                break;
                            case 4:
                                updateGames();
                                Read.Pause();
                                break;
                            case 0:
                                repeatSub = false;
                        }
                    } while (repeatSub);
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
                        System.out.println("+        [4] Edit Studio           +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+            [0] Back              +");
                        chooser = Read.Int("++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                insertStudio();
                                Read.Pause();
                                break;
                            case 2:
                                insertStudio();
                                Read.Pause();
                                break;
                            case 3:
                                deleteStudios();
                                Read.Pause();
                                break;
                            case 4:
                                updateStudios();
                                Read.Pause();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                        }
                    } while (repeatSub);
                    break;


                case 4:
                    //Studios
                    do {
                        repeatSub = true;
                        cls();
                        ArrayList<Object> studios = null;
                        System.out.println("+++++++++++++++SALES++++++++++++++++");
                        System.out.println("+         [1] Sale List          +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+         [2] Add Sale           +");
                        System.out.println("+       [3] Delete Sale          +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+        [4] Edit Sale           +");
                        System.out.println("+----------------------------------+");
                        System.out.println("+            [0] Back              +");
                        chooser = Read.Int("++++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                insertStudio();
                                Read.Pause();
                                break;
                            case 2:
                                insertStudio();
                                Read.Pause();
                                break;
                            case 3:
                                deleteStudios();
                                Read.Pause();
                                break;
                            case 4:
                                updateStudios();
                                Read.Pause();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                        }
                    } while (repeatSub);
                    break;

            }
        } while (repeatAll);

    }
}

*/