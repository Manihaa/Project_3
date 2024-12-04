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
    private int hits;

    // (y, x) --> (Letter, #)
    private int ship1;
    private int ship2;

    // _____________________________
    // constructor
    public NPC(Scanner scan){
        this.scan = scan;
        hit = false;
        hits = 0;
        list();
    }

    public NPC(Scanner scan, int num){
        this.scan = scan;
        hit = false;
        hits = num;
        list();
    }
    // _____________________________

    // getter method
    public int getHits(){
        return hits;
    }

    // method
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
    public void shipMaker(int num){
        ship1 = Location();
        ship2 = Location();

        while (ship1 == ship2 || Math.abs(ship1 - ship2) == 1){
            ship2 = Location();
        }
        System.out.println(ship1 + " " + ship2); //test
    }

    // method for 1 ship
    public void shipMaker(double num){
        ship1 = Location();
        System.out.println(ship1); //test

    }

    // method for 2 ships
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
    public String hit(int number){
        String num = "" + number;
        int idx = map.indexOf(num);
        int len = num.length();

        String tempMap = map.substring(0, idx) + "X" + map.substring(idx + len);
        map = tempMap;
        return map;
    }

    // method
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
    private void list(){
        for (int i = 1; i != 26; i++){
            l1.add(String.valueOf(i));
        }
    }

    // helper method
    private int Location(){
        int num = (int) ((int)(Math.random() * 3 + 1) * (Math.random() * 3 + 1));
        return num;
    }

}
