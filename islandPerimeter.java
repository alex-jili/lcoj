/**
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes"
 (water inside that isn't connected to the water around the island). One cell is a square with side length
 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 **/

import com.google.common.base.Preconditions;

public class islandPerimeter {

    private int countIslandEdges(int[][] grid, int x, int y) {
        /* num rows */
        int maxHeight = grid.length;
        /* num columns */
        int maxWidth = grid[0].length;
        int totalEdges = 0;

        /* check surrounded four grids */
        totalEdges += (y - 1 < 0 || grid[x][y - 1] == 0) ? 1 : 0;
        totalEdges += (y + 1 >= maxWidth || grid[x][y + 1] == 0) ? 1 : 0;
        totalEdges += (x - 1 < 0 || grid[x - 1][y] == 0) ? 1 : 0;
        totalEdges += (x + 1 >= maxHeight || grid[x + 1][y] == 0) ? 1 : 0;
        return totalEdges;
    }

    public int islandPerimeter(int[][] grid) {
        Preconditions.checkNotNull(grid);
        Preconditions.checkNotNull(grid[0]);
        Preconditions.checkArgument(grid[0].length != 0);
        Preconditions.checkArgument(grid.length != 0);

        int perimeter = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1) {
                    System.out.println("row is: " + row + " column is: " + column);
                    perimeter += countIslandEdges(grid, row, column);
                }
            }
        }
        return perimeter;
    }



    public void testIslandPerimeter() {
        /* one single grid */
        int[][] test1 = new int[][]{
                {1}
        };
        int result1 = islandPerimeter(test1);
        int expected = 4;
        if(result1 != expected) {
            throw new RuntimeException("test1 failed");
        }

        /* empty grid - no island */
        int[][] test2 = new int[][]{{0}};
        int result2 = islandPerimeter(test2);
        expected = 0;
        if(result2 != expected) {
            throw new RuntimeException("test2 failed");
        }

        /* island on first column */
        int[][] test3 = new int[][]{
                {1,0,0},
                {1,0,0},
                {1,0,0}
        };
        int result3 = islandPerimeter(test3);
        expected = 8;
        if(result3 != expected) {
            throw new RuntimeException("test3 failed");
        }

        /* island on first row */
        int[][] test4 = new int[][]{
                {1,1,1},
                {0,0,0},
                {0,0,0}
        };
        int result4 = islandPerimeter(test4);
        expected = 8;
        if(result4 != expected) {
            throw new RuntimeException("test4 failed");
        }

        /* island on last row */
        int[][] test5 = new int[][]{
                {0,0,0},
                {0,0,0},
                {1,1,1,}
        };
        int result5 = islandPerimeter(test5);
        expected = 8;
        if(result5 != expected) {
            throw new RuntimeException("test5 failed");
        }

        /* island on last column */
        int[][] test6 = new int[][]{
                {0,0,1},
                {0,0,1},
                {0,0,1}
        };
        int result6 = islandPerimeter(test6);
        expected = 8;
        if(result6 != expected) {
            throw new RuntimeException("test6 failed");
        }

        /* arbitrary island */
        int[][] test7 = new int[][]{
                {0,1,0,0},
                {1,1,0,0},
                {0,1,1,0},
                {1,1,1,1}
        };
        int result7 = islandPerimeter(test7);
        expected = 18;
        if(result7 != expected) {
            throw new RuntimeException("test7 failed, result7 is" + result7);
        }

        /* arbitrary island 2 */
        int[][] test8 = new int[][]{
                {1,0}
        };
        expected = 4;
        int result8 = islandPerimeter(test8);
        if(result8 != expected) {
            throw new RuntimeException("test8 failed, result 8 is" + result8);
        }
    }

    public static void main(String args[]) {
        islandPerimeter a = new islandPerimeter();
        a.testIslandPerimeter();
    }
}