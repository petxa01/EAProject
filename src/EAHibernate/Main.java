package EAHibernate;

import EA.Read;

import java.io.IOException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Tools.cls;
import static EAHibernate.Franchises.*;
import static EAHibernate.Games.*;
import static EAHibernate.Sales.*;
import static EAHibernate.Studios.*;

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
                                break;
                        }
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
                        System.out.println("+       [4] Edit Franchise        +");
                        System.out.println("+---------------------------------+");
                        System.out.println("+            [0] Back             +");
                        chooser = Read.Int("+++++++++++++++++++++++++++++++++++");
                        switch (chooser) {
                            case 1:
                                printFranchises();
                                Read.Pause();
                                break;
                            case 2:
                                insertFranchise();
                                Read.Pause();
                                break;
                            case 3:
                                deleteFranchises();
                                Read.Pause();
                                break;
                            case 4:
                                updateFranchises();
                                Read.Pause();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                        }

                    } while (repeatSub);
                    break;

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
                                printStudios();
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
                    //Sales
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
                                printSales();
                                Read.Pause();
                                break;
                            case 2:
                                insertSale();
                                Read.Pause();
                                break;
                            case 3:
                                deleteSales();
                                Read.Pause();
                                break;
                            case 4:
                                updateSales();
                                Read.Pause();
                                break;
                            case 0:
                                repeatSub = false;
                                break;
                        }
                    } while (repeatSub);
                    break;
                default:
                    repeatAll = false;
                    break;
            }
        } while (repeatAll);

    }
}

