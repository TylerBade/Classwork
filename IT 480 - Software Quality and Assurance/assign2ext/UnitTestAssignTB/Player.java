import java.io.PrintStream;

public class Player {
    public boolean hasSugar = false;
    public boolean hasCream = false;
    public boolean hasCoffee = false;
    
    public Player() {}
    
    public void getSugar()
    {
        System.out.println("SUGAR! You'll probably want this.");
        hasSugar = true;
    }
    
    public void getCream() {
        System.out.println("CREAM! You should probably take this.");
        hasCream = true;
    }
    
    public void getCoffee() {
        System.out.println("COFFEE! Probably for the best that you take this.");
        hasCoffee = true;
    }
    
    public boolean hasAllItems() {
        return (hasCoffee) && (hasCream) && (hasSugar);
    }
    
    public void showInventory() {
        if (hasCoffee) {
            System.out.println("The coffee is in your hands.");
        } else {
            System.out.println("No coffee, go find it.");
        }
        if (hasCream) {
            System.out.println("The cream is yours.");
        } else {
            System.out.println("No cream, go look for it");
        }
        if (hasSugar) {
            System.out.println("Sugar rush is ready to go!");
        } else {
            System.out.println("You'll need more sugar for this.");
        }
    }
    
    public void showHelp() {
    System.out.println("Instructions for Coffee Maker Quest - ");
    System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
    System.out.println("The goal of the game is to collect sugar, coffee, and cream so that you can study.");
    System.out.println("How to Play:\nN = go north\nS = go south\nL = look around\nI = show inventory\nD = drink coffee");
    }
    
    public boolean drink() {
        boolean win = false;
        
        showInventory();
        System.out.println();
        if (hasAllItems()) {
            System.out.println("Your coffee does its job and keeps you awake.");
            win = true;
        } else if (hasCoffee) {
            if (!hasCream) {
                System.out.println("Its too hot without cream.");
            } else {
                System.out.println("Its too bitter without sugar.");
            }
        } else if (hasCream) {
            if (!hasCoffee) {
                System.out.println("Why are you drinking cream without coffee?");
            } else {
                System.out.println("Its too bitter without sugar.");
            }
        } else if (hasSugar) {
            if (!hasCoffee) {
                System.out.println("Sweet cream does not a good drink make.");
            } else {
                System.out.println("Its too hot without cream.");
            }
        } else {
            System.out.println("You have nothing to drink, good luck with that problem.");
        }
        
        return win;
    }
}