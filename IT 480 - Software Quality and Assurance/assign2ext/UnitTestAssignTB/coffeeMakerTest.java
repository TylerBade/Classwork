import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Field;
import org.junit.Test;

public class coffeeMakerTest {
    
    @Test
    public void houseRoomInfoTest() {
        House ritest = new House();
        String roomInfo = ritest.getCurrentRoomInfo();
        assertNotNull(roomInfo);
    }
    
    @Test
    public void houseNorthTest() {
        House ntest = new House();
        ntest.moveNorth();
        int currroom = ntest.getRoomNum();
        assertEquals(1, currroom);
    }
    
    @Test
    public void houseSouthTest() {
        House stest = new House();
        stest.moveNorth();
        stest.moveSouth();
        int currroom = stest.getRoomNum();
        assertEquals(0, currroom);
    }
    
    @Test
    public void houseLookTest() {
        House ltest = new House();
        Player LtestP = new Player();
        ltest.look(LtestP);
        assertTrue(LtestP.hasCream);
    }
    
    @Test
    public void playerGetSugarTest() {
        House sugartest = new House();
        Player sugarTester = new Player();
        sugartest.currentRoom = sugartest.numRooms - 1;
        sugartest.look(sugarTester);
        assertTrue(sugarTester.hasSugar);
    }
    
    @Test
    public void playerGetCreamTest() {
        House creamtest = new House();
        Player creamTester = new Player();
        creamtest.currentRoom = 0;
        creamtest.look(creamTester);
        assertTrue(creamTester.hasCream);
    }
    
    @Test
    public void playerGetCoffeeTest() {
        House coffeetest = new House();
        Player coffeeTester = new Player();
        coffeetest.currentRoom = 2;
        coffeetest.look(coffeeTester);
        assertTrue(coffeeTester.hasCoffee);
    }
    
    @Test
    public void playerDrinkWinTest() {
        Player wintester = new Player();
        wintester.hasCoffee = true;
        wintester.hasCream = true;
        wintester.hasSugar = true;
        assertTrue(wintester.drink());
    }
    
    @Test
    public void playerDrinkLoseTest() {
        Player losstester = new Player();
        assertFalse(losstester.drink());
    }
    
    @Test
    public void roomHasItemTest() {
        Room hasitem = new Room(true, true, true, true, true);
        assertTrue(hasitem.hasItem());
    }
    
    @Test
    public void roomNotHasItemTest() {
        Room noitem = new Room(false, false, false, true, true);
        assertFalse(noitem.hasItem());
    }
    
    @Test
    public void roomHasSugarTest() {
        Room sugarroom = new Room(false, false, true, true, true);
        assertTrue(sugarroom.hasSugar());
    }
    
    @Test
    public void roomHasCreamTest() {
        Room creamroom = new Room(false, true, false, true, true);
        assertTrue(creamroom.hasCream());
    }
    
    @Test
    public void roomHasCoffeeTest() {
        Room coffeeroom = new Room(true, false, false, true, true);
        assertTrue(coffeeroom.hasCoffee());
    }
    
    @Test
    public void roomNorthExitTest() {
        Room hasNorth = new Room(false, false, false, true, true);
        assertTrue(hasNorth.northExit());
    }
    
    @Test
    public void roomNotHasNorthExitTest() {
        Room noNorth = new Room(false, false, false, false, true);
        assertFalse(noNorth.northExit());
    }
    
    @Test
    public void roomSouthExitTest() {
        Room hasSouth = new Room(false, false, false, true, true);
        assertTrue(hasSouth.southExit());
    }
    
    @Test
    public void roomNotHasSouthExitTest() {
        Room noSouth = new Room(false, false, false, true, false);
        assertFalse(noSouth.southExit());
    }
    
    @Test
    public void roomGetDescTest() {
        Room getDesc = new Room(false, false, false, true, true);
        assertNotNull(getDesc.getDesc());
    }
    
}