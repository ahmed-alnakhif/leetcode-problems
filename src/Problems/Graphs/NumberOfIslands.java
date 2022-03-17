package Problems.Graphs;

import java.util.HashSet;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

public class NumberOfIslands {
    HashSet<String> seenCells = new HashSet<>();

    public int numIslands(char[][] grid) {
        int numbOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (dfs(grid, row, col)) {
                    numbOfIslands++;
                }
            }
        }

        return numbOfIslands;
    }

    private boolean dfs(char[][] grid, int row, int col) {
        String key = row + "," + col;

        if (!isValidCell(grid, row, col)) return false;
        if (isWater(grid, row, col)) return false;
        if (seenCells.contains(key)) return false;

        seenCells.add(key);

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        return true;
    }

    private boolean isValidCell(char[][] grid, int row, int col) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        return rowInBounds && colInBounds;
    }

    private boolean isWater(char[][] grid, int row, int col) {
        return grid[row][col] == '0';
    }

    char[][] generateGrid() {
        char[][] grid = {
                { 'W', 'L', 'W', 'W', 'L' },
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'W', 'L', 'W' },
                { 'W', 'W', 'L', 'L', 'W' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'L', 'L', 'W', 'W', 'W' },
        };

        return grid;
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = n.generateGrid();
        System.out.println(n.numIslands(grid));
    }
}