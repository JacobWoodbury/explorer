import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

     @Test
    public void testReachableArea_Surrounded() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,2,3,2,3,1},
            {1,2,0,1,3,1},
            {1,2,2,2,2,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(2, actual);
    }

     @Test
    public void testReachableArea_Surrounding() {
        int[][] island = {
            {0,1,1,1,1,1},
            {1,2,3,2,3,1},
            {1,2,1,1,3,1},
            {1,2,2,2,2,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(18, actual);
    }

    @Test
    public void testReachableArea_OnlyWater() {
        int[][] island = {
            {2,2,2,3,2,2},
            {3,2,3,2,3,2},
            {2,2,2,2,3,3},
            {3,2,2,2,0,2},
            {2,2,2,2,2,2},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_AllLand() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }
    

    @Test
    public void testReachableArea_NoStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,1},
            {1,1,1,2,1,1},
        };
        assertThrows(IllegalArgumentException.class,() ->{
            int actual = ExplorerSearch.reachableArea(island);
        });
        
    }

      @Test
    public void testFindStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int [] actual = ExplorerSearch.findStart(island);
        int x = actual[0];
        int y = actual[1];
        assertEquals(3, x);
        assertEquals(4, y);
    }

      @Test
    public void testFindStart_last() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,0},
        };
        int [] actual = ExplorerSearch.findStart(island);
        int x = actual[0];
        int y = actual[1];
        assertEquals(4, x);
        assertEquals(5, y);
    }
}
