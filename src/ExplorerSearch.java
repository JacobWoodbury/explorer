import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExplorerSearch {

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
        boolean[][] visited = new boolean[island.length][island[0].length];


        return reachableArea(island, 1, start, visited);
    }

    public static int reachableArea(int[][] island, int area, int[] current, boolean[][] visited) {
        if(visited[current[0]][current[1]] || current[0] < 0 || current [1] < 0 || current[0] > island.length || current[1] > island[0].length) return 0;
        Set<int[]> reachable = getReachable(island, current, visited);
        for(int[] coordinate: reachable){

            area += reachableArea(island, area, coordinate, visited)+1;
        }
        return area;
    }

    public static Set<int[]> getReachable(int[][] island, int[] current, boolean[][] visited){
        Set<int[]> reachable = new HashSet<>();
        int r = current[0];
        int c = current[1];
       
        
        //up 
        int newR = r -1;
        int newC = c;
        if(newR>=0 && island[newR][newC] == 1){
            reachable.add(new int[] {newR, newC});
        }
        //down
        newR = r +1;
        newC = c;
        if(newR< island.length && island[newR][newC] == 1){
            reachable.add(new int[] {newR, newC});
        }
        //left
        newR = r;
        newC = c -1;
        if(newC >= 0 && island[newR][newC] == 1){
            reachable.add(new int[] {newR, newC});
        }
        //right
        newR = r;
        newC = c +1;
        if(newC < island[newR].length && island[newR][newC] == 1){
            reachable.add(new int[] {newR, newC});
        }

        return reachable;
    }

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
