package shutthebox;//package name
//import stuff
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ShuttheBox {//start of class

    public static void main(String[] args) {//start of main method
        //makes the tiles and places them
        ArrayList<Boolean> tiles = new ArrayList<>();
        puttheTiles(tiles);
//makes the dice and tiles
        int d1 = diceroll();
        int d2 = diceroll();
        theGame(tiles);
    }//end of main method

    public static ArrayList<Boolean> puttheTiles(ArrayList<Boolean> a) {//start of the method that places the tiles
        a.clear();
        for (int i = 0; i < 9; i++) {
            a.add(i, true);
        }
        return a;
    }

    public static int diceroll() {//rolls the dice
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        return dice;
    }

    public static void displayTiles(ArrayList<Boolean> a) {//method that displays the tiles
        for (int i = 0; i < 9; i++) {
            if (a.get(i)) {
                System.out.print(i + 1);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public static void fliptheTile(int number, ArrayList<Boolean> a) {//method that flips the tiles down when chosen
        a.set(number - 1, false);

    }

    public static void esc(ArrayList<Boolean> tiles) {//you lose
        System.out.println("You lose");
        System.exit(0);
        puttheTiles(tiles);
        theGame(tiles);
    }

    public static boolean checktheTile(ArrayList<Boolean> a) {//checks the tile of it is down or not
        for (int i = 0; i < 9; i++) {
            if (a.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void theGame(ArrayList<Boolean> tiles) {//the actual game itself
        Scanner reader = new Scanner(System.in);//takes in input
        int d1 = diceroll();//the first dice
        int d2 = diceroll();//second dice
        int sum = d1 + d2;//sum of the two dice values
        int number;
        System.out.println("Your dice are " + d1 + " and " + d2);//prints what the dice are
        System.out.println("Your total is " + (d1 + d2));//prints the total of the dice values
        System.out.println();
        if (checktheTile(tiles) /*&& sum == 0*/) {
            System.out.println("You Win!");//says you win, was going to put the trophy thing but it didn't work
//                System.out.println(" .-=========-.");
//                System.out.println(" \'-=======-'/");
//                System.out.println(" _|   .=.   |_");
//                System.out.println("((|  {{1}}  |))");
//                System.out.println(" \|   /|\   |/");
//                System.out.println("  \__ '`' __/");
//                System.out.println("    _`) (`_");
//                System.out.println("  _/_______\_ ");
//                System.out.println(" /___________\");
            System.exit(0);//exits the game after you have won, found this feature on the internetz
        }
        while (sum >= 0) {

            System.out.println("What tile do you wanna flip?");//asks for input for which number file you want to choose
            number = reader.nextInt();

            if (!tiles.get(number - 1)) {//says you lose
                System.out.println("You Lose!");
                esc(tiles);
            }
            sum -= number;

            if (sum >= 0) {
                fliptheTile(number, tiles);
                displayTiles(tiles);
            }
            if (sum == 0) {
                theGame(tiles);
            }
        }//end of the while loop
        esc(tiles);
    }//end of theGame
}//end of class