import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NPC {
    // new objects
    List<String> l1 = new ArrayList<>();

    // instance variables
    private String map;
    private Scanner scan;

    private int ship1x;
    private String ship1y;
    private int ship2x;
    private String ship2y;

    // _____________________________
    // constructor
    public NPC(Scanner scan){
        this.scan = scan;
    }
    // _____________________________

    // method
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

    public void shipMaker(){
        ship1x = xLocation();
        ship1y = yLocation();
        ship2x = xLocation();
        ship2y = yLocation();

        if ( // the coordinates of the two ships should not overlap
    }

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

        }else if (let == 2){

        }else if (let == 3){

        }else if (let == 4){

        }else if (let == 5){

        }
        return lett;
    }
}
