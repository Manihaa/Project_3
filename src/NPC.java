import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NPC {
    // new objects
    List<String> l1 = new ArrayList<>();

    // instance variables
    private Scanner scan;
    private String map;
    private boolean hit;

    // (y, x) --> (Letter, #)
    private int ship1x;
    private String ship1y;
    private int ship2x;
    private String ship2y;

    // _____________________________
    // constructor
    public NPC(Scanner scan){
        this.scan = scan;
        hit = false;
        list();
    }
    // _____________________________

    // method
    public String map(){
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

    // method for 2 ships
    public void shipMaker(int num){
        ship1x = xLocation();
        ship1y = yLocation();
        ship2x = xLocation();
        ship2y = yLocation();

        while (ship1y.compareTo(ship2y) == 0 && (ship1x == ship2x || Math.abs(ship1x-ship1x) == 1)){
            ship2x = xLocation();
            ship2y = yLocation();
        }
    }

    // method for 1 ship
    public void shipMaker(double num){
        ship1x = xLocation();
        ship1y = yLocation();
    }

    // method for 2 ships
    public boolean hitOrMiss(int num, String letter, int number){
        if (ship1y.equals(letter) && (ship1x == number || ship1x + 1 == number)){
            hit = true;
        }else if (ship2y.equals(letter) && (ship2x == number || ship2x + 1 == number)){
            hit = true;
        }else{
            hit = false;
        }
        return hit;
    }

    // method for 1 ship
    public boolean hitOrMiss(double num, String letter, int number){
        if (ship1y.equals(letter) && (ship1x == number || ship1x + 1 == number)){
            hit = true;
        }else{
            hit = false;
        }
        return hit;
    }

    // method
    public String hit(String letter, int number){
        int idx = l1.indexOf(letter);
        map = "      1    2    3    4    5\n";
        for (int i = 0; i > idx - 1; i++){
            map += l1.get(i) + "|  ";

            for (int j = 1; j != 6; j++){
                map += "  o  ";
            }
            map += "\n\n";
        }
        // somehow edit the "o" at the number column when you're already in the letter row
        return map;
    }

    // method
    public String miss(String letter, int number){
        //change map to represent a ship missed
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
        int num = (int)(Math.random() * 3 + 1);
        return num;
    }

    // helper method
    private String yLocation(){
        String lett = "";
        int let = (int)(Math.random() * 4 + 1);
        if (let == 1){
            lett = "A";
        }else if (let == 2){
            lett = "B";
        }else if (let == 3){
            lett = "C";
        }else if (let == 4){
            lett = "D";
        }else if (let == 5){
            lett = "E";
        }
        return lett;
    }
}
