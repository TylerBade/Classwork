import java.io.PrintStream;

public class newCoffee {
    private int runLoop() {
        Player p = new Player();
        House h = new House();
        Game g = new Game(p,h);
        int toReturn = g.run();
        return toReturn;
    }
    
    public static void main(String[] args) {
        System.out.println("CoffeeMakerQuest 2.0");
        System.out.println("Instructions for Coffee Maker Quest - ");
        System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
        System.out.println("The goal of the game is to collect sugar, coffee, and cream so that you can study.");
        System.out.println("How to Play:\nN = Go North\nS = Go South\nL = Look Around\nI = Show Inventory\nD = Drink Coffee\nH = Show Instructions Again");
        int returnValue = 0;
        newCoffee cm = new newCoffee();
        returnValue = cm.runLoop();
        System.out.println("Exiting with error code " + returnValue);
    }
}