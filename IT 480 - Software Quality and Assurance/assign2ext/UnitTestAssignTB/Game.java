import java.io.PrintStream;

public class Game
{
    private Player _player = null;
    private House _house = null;
    
    public Game(Player p, House h) {
        _player = p;
        _house = h;
    }
    
    public int run() {
        int toReturn = 0;
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        String move = null;
        
        boolean gameOver = false;
        boolean win = false;
        
        while (!gameOver) {
            System.out.println(_house.getCurrentRoomInfo());
            System.out.println(" INSTRUCTINS (N,S,L,H,I,D) >");
            move = in.nextLine();
            if (move.equalsIgnoreCase("N")) {
                _house.moveNorth();
            } else if (move.equalsIgnoreCase("S")) {
                _house.moveSouth();
            } else if (move.equalsIgnoreCase("L")) {
                _house.look(_player);
            } else if (move.equalsIgnoreCase("I")) {
                _player.showInventory();
            } else if (move.equalsIgnoreCase("H")) {
                _player.showHelp();
            } else if (move.equalsIgnoreCase("D")) {
                win = _player.drink();
                gameOver = true;
            } else {
                System.out.println("What?");
            }
        }
        
        if (win) {
            System.out.println("You Win!");
            toReturn = 0;
        } else {
            System.out.println("You Lost, Better Luck Next Time!");
            toReturn = 1;
        }
        
        return toReturn;
    }
}