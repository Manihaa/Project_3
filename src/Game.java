import java.util.Scanner;
import java.util.*;
public class Game {
    // new objects
    Scanner scan = new Scanner(System.in);
    List<String> l1 = new ArrayList<>();

    // instance variables
    private String name;
    private String temp;
    private String map;
    private String letter;
    private String number;
    private String point;

    private String ship1x;
    private int ship1y;
    private String ship2x;
    private int ship2y;

    // __________________________________
    // constructor - add a parameter
    public Game(){

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

    public String map(){
        list();
        map = "      1    2    3    4    5\n";
        for (int i = 0; i != 5; i++){
            map += l1.get(i) + "|  ";

                for (int j = 1; j != 6; j++){
                    map += "  o  ";
                }
            map += "\n\n";
        }
        return map;
    }

    // _____________________________
    // helper method
    private void list(){
        l1.add("A");
        l1.add("B");
        l1.add("C");
        l1.add("D");
        l1.add("E");
    }

    // helper method
    private int xLocation(){
        int num = (int)(Math.random() * 4 + 1);
        return num;
    }

    // helper method
    private String yLocation(){
        String lett = "";
        int let = (int)(Math.random() * 4 + 1);
        if (let == 1){

        }else if (let == 2){

        }else if (let == 3){

        }else if (let == 4){

        }else if (let == 5){

        }
        return lett;
    }
}
