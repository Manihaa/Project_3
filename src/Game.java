import java.util.Scanner;
import java.util.*;
public class Game {
    // new objects
    List<String> l1 = new ArrayList<>();

    // instance variables
    private Scanner scan;
    private String name;
    private String temp;
    private String letter;
    private String number;
    private String point;


    // __________________________________
    // constructor - add a parameter
    public Game(Scanner scan){
        this.scan = scan;
        NPC npc = new NPC(scan);
    }

    // ___________________________________
    public void start(){
        System.out.print("Welcome to BattleShips!\nEnter your name: ");
        name = scan.nextLine();
        System.out.println("Hello, " + name + ", would you like to hear the rules? (y/n) ");
        temp = scan.nextLine();
        if (temp.equals("y")){
            System.out.println();
            // bunch of rules explained here
        }

    }

    public void ask(){
        System.out.println("Call your shot (Letter, #) ---> ");
        point = scan.nextLine();
        letter = point.substring(1, 2);
        number = point.substring(4, 5);
    }
}
