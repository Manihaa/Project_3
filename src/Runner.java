import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Game game = new Game(scan);
        game.start();
    }
}
