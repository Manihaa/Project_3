import java.util.Scanner;
import java.util.*;
public class Game {
    // new objects
    List<String> l1 = new ArrayList<>();

    // instance variables
    private Scanner scan;
    private NPC npc = new NPC(scan);

    private String name;
    private String answer;
    private int tempInt;
    private double tempDouble;
    private boolean twoShips;

    private String letter;
    private String number;
    private String point;

    // __________________________________
    // constructor - add a parameter
    public Game(Scanner scan){
        this.scan = scan;
        tempInt = 1;
        tempDouble = 1.0;
        twoShips = false;
    }
    // ___________________________________

    // method
    public void start(){
        System.out.print("Welcome to BattleShips!\nEnter your name: ");
        name = scan.nextLine();
        System.out.print("Hello, " + name + ", would you like to hear the rules? (y/n) ");
        answer = scan.nextLine();
        if (answer.equals("y")){
            System.out.println("BattleShips is a game created by Hasbro.\n" +
                    "In it there are two players; You and an NPC.\n" +
                    "You will be presented by a 5 by 5 grid, representing the ocean\n" +
                    "On it, invisible to you, are ships, two units long, placed by the NPC.\n" +
                    "The goal is to guess where the ships are in the fewest number of tries.\n" +
                    "To win, you need to guess where the entire ship is.\n\n" +
                    "\"o\" --> unselected unit\n" +
                    "\"-\" --> selected and missed unit\n" +
                    "\"X\" --> selected and hit unit\n\n" +
                    "Good luck!");
        }
        System.out.print("How many ships should there be? (1 or 2) ");
        answer = scan.nextLine();
        if (answer.equals("2")){
            twoShips = true;
            npc.shipMaker(tempInt);
        }else{
            npc.shipMaker(tempDouble);
        }
        System.out.println(npc.map());

        // create some way for the game to stop asking
        while (){
            ask();
        }
    }

    // method
    public void ask(){
        System.out.println("Call your shot (Letter, #) ---> ");
        point = scan.nextLine();
        letter = point.substring(1, 2);
        number = point.substring(4, 5);
        tempInt = Integer.parseInt(number);
        if (twoShips){
            if (npc.hitOrMiss(tempInt, letter, tempInt)){
                npc.hit();
            }else{
                npc.miss();
            }
        }else{
            if (npc.hitOrMiss(tempDouble, letter, tempInt)){
                npc.hit();
            }else{
                npc.miss();
            }
        }
    }

}
