import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExplorerSearch {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        int[] start = findStart(island);

        return reachableArea(island, start);
    }

    public static int reachableArea(int[][] island, int[] current) {
         int r = current[0];
        int c = current[1];
        
        if(r < 0 || c < 0 || r >= island.length || c >= island[0].length || island[r][c] > 1) return 0;
        
       
        island[r][c] = 2;
        int area = 1;
        
        for(int[] dir: directions){
            int[] coordinate = {r+dir[0], c+dir[1]};
            area+= reachableArea(island, coordinate);
        }

        return area;

    }


    // working
    public static int[] findStart(int[][] island){
         for(int r=0; r<island.length; r++){
            for(int c=0; c<island[r].length; c++){
                if(island[r][c] == 0){
                    //found
                    int[] location = new int[]{r,c};
                    return location;
                }
            }
        }
        throw new IllegalArgumentException("find start error"); 
    }





}
