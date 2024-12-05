import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the NPC player
 * @author Maniha
 */
public class NPC {
    // new objects
    List<String> l1 = new ArrayList<>();

    // instance variables
    /**
     * Represents the scanner object for the class
     */
    private Scanner scan;

    /**
     * Represents the map of the game
     */
    private String map;
    /**
     * If the player hit a ship
     */
    private boolean hit;
    /**
     * How many hits the player got
     */
    private int hits;

    // (y, x) --> (Letter, #)
    /**
     * The location of the first ship
     */
    private int ship1;
    /**
     * The location of the second ship
     */
    private int ship2;

    // _____________________________
    // constructor
    /**
     *Creates NPC object
     * @param scan Scanner object
     */
    public NPC(Scanner scan){
        this.scan = scan;
        hit = false;
        hits = 0;
        list();
    }

    //constructor (unused)
    /**
     *Creates unused NPC object
     * @param scan Scanner object
     * @param num Number of hits the player got
     */
    public NPC(Scanner scan, int num){
        this.scan = scan;
        hit = false;
        hits = num;
        list();
    }
    // _____________________________

    // getter method
    /**
     *Gets the number of hits done by the player
     * @return Number of hits by the player
     */
    public int getHits(){
        return hits;
    }

    // method
    /**
     *Creates the map of the game
     * @return The map of the game
     */
    public String map(){
        map = "\n--------------------\n";
        int num = 0;
        while (num < 25){
            map += l1.get(num) + "  ";
            if ((num + 1)% 5 == 0 && num != 24){
                map += "\n\n";
            }
            num++;
        }
        return map;
    }

    // method for 2 ships
    /**
     *Assigns a location for two ships
     * @param num Determined that two ships will be made
     */
    public void shipMaker(int num){
        ship1 = Location();
        ship2 = Location();

        while (ship1 == ship2 || Math.abs(ship1 - ship2) == 1){
            ship2 = Location();
        }
        System.out.println(ship1 + " " + ship2); //test
    }

    // method for 1 ship
    /**
     *Assigns a location for one ship
     * @param num Determined that one ship will be made
     */
    public void shipMaker(double num){
        ship1 = Location();
        System.out.println(ship1); //test

    }

    // method for 2 ships
    /**
     *Determines whether the player's point was a hit or a miss
     * @param num Determined that two ships will be made
     * @param number The player's point
     * @return Whether the point was a hit or miss
     */
    public boolean hitOrMiss(int num, int number){
        if (number == ship1 || number == ship2){
            hit = true;
            hits++;
        }else if (number == ship1 + 1 || number == ship2 + 1){
            hit = true;
            hits++;
        }else{
            hit = false;
        }
        return hit;
    }

    // method for 1 ship
    /**
     *Determines whether the player's point was a hit or a miss
     * @param num Determined that one ship will be made
     * @param number The player's point
     * @return Whether the point was a hit or miss
     */
    public boolean hitOrMiss(double num, int number){
        if (number == ship1){
            hit = true;
            hits++;
        }else if (number == ship1 + 1){
            hit = true;
            hits++;
        }else{
            hit = false;
        }
        return hit;
    }

    // method
    /**
     *Updates map to show the hit
     * @param number The point
     * @return Updated map
     */
    public String hit(int number){
        String num = "" + number;
        int idx = map.indexOf(num);
        int len = num.length();

        String tempMap = map.substring(0, idx) + "X" + map.substring(idx + len);
        map = tempMap;
        return map;
    }

    // method
    /**
     *Updates map to show the miss
     * @param number The point
     * @return Updated map
     */
    public String miss(int number){
        String num = "" + number;
        int idx = map.indexOf(num);
        int len = num.length();

        String tempMap = map.substring(0, idx) + "-" + map.substring(idx + len);
        map = tempMap;
        return map;
    }


    // _____________________________
    // helper method
    /**
     *Private helper method that generates numbers 1-25 in a list
     */
    private void list(){
        for (int i = 1; i != 26; i++){
            l1.add(String.valueOf(i));
        }
    }

    // helper method-
    /**
     *Private helper method that creates a random point on a map
     * @return Random point on a map
     */
    private int Location(){
        int num = 0;
        while(num%5==0){
            num = (int)(Math.random() * 24 + 1);
        }
        return num;
    }
}
