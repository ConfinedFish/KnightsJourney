
package knightsjourney;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
public class KnightTest {
    
    public KnightTest() {
    }

    /**
     * Test of getStart method, of class Knight.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Knight instance = new Knight(5,5,new Position());
        Position result = instance.getStart();
        assertEquals(new Position().column, result.column);
        assertEquals(new Position().row, result.row);
    }
    
    @Test
    public void testGetGrid(){
        System.out.print("getGrid");
        Knight instance = new Knight(5,5,new Position());
        assertEquals("0", Byte.toString(instance.getGrid()[0][0]));
    }
    
    @Test
    public void testMarkAsPossible(){
        System.out.println("markAsPossible");
        Knight instance = new Knight(5,5,new Position());
        Position pos = new Position(0,0);
        instance.markAsPossible(pos);
        assertEquals("1", Byte.toString(instance.getGrid()[0][0]));
    }
    
    /**
     * Test of isOK method, of class Knight.
     */
    @Test
    public void testIsOK() {
        Knight instance = new Knight(5,5,new Position());
        Position pos = new Position(-1,-1);
        assertEquals(instance.isOK(pos), false);
    }

    /**
     * Test of isGoal method, of class Knight.
     */
    @Test
    public void testIsGoal() {
        Knight instance = new Knight(5,5,new Position());
        Position pos = new Position(1,1);
        assertEquals(instance.isGoal(pos), false);
    }

    /**
     * Test of iterator method, of class Knight.
     */
    @Test
    public void testIterator() {
        Position pos = new Position(1,1);
        Iterator<Position> instance = new Knight(5,5,new Position()).iterator(pos);
        assertEquals(instance.next().column, 2);
        assertEquals(instance.next().row, 2);
    }

    /**
     * Test of toString method, of class Knight.
     */
    @Test
    public void testToString() {
        Knight instance = new Knight(5,5,new Position());
        assertEquals(instance.toString(), new Knight(5,5,new Position()).toString());
    }
}
