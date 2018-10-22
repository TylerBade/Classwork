import java.io.PrintStream;

public class House {
    
    public int numRooms = 6;
    private Room[] _rooms = new Room[numRooms];
    public int currentRoom = 0;
    
    public House() {
        generateRooms();
    }
    
    public int getRoomNum() {
        return currentRoom;
    }
    
    public String getCurrentRoomInfo() {
        return _rooms[currentRoom].getDesc();
    }
    
    public void moveNorth() {
        if (currentRoom == numRooms -1) {
            System.out.println("That's as far north as you can go!");
        }
        else {
            currentRoom += 1;
        }
    }
    
    public void moveSouth() {
        if (currentRoom == 0) {
            System.out.println("That's as far south as you can go!");
        }
        else {
            currentRoom -= 1;
        }
    }
    
    public void look(Player player) {
        Room room = _rooms[currentRoom];
        if (room.hasItem()) {
            System.out.println("Something's here...");
            if (room.hasCoffee()) {
                player.getCoffee();
            }
            if (room.hasCream()) {
                player.getCream();
            }
            if (room.hasSugar()) {
                player.getSugar();
            }
        }
        else {
            System.out.println("Nothing here, move along.");
        }
    }
    
    private void generateRooms()
    {
        boolean northDoor = true;
        boolean southDoor = true;
        boolean hasCoffee = false;
        boolean hasCream = false;
        boolean hasSugar = false;
        
        for (int j = 0; j < numRooms; j++) {
            if (j == 0) {hasCream = true;} else {hasCream = false;}
            if (j == 2) {hasCoffee = true;} else {hasCoffee = false;}
            if (j == numRooms - 1) {hasSugar = true;} else { hasSugar = false;}
            if (j == 0) {southDoor = false;} else {southDoor = true;}
            if (j == numRooms -1) {northDoor = false;} else {northDoor = true;}
            _rooms[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
        }
    }
}