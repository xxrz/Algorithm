import java.util.*;

class Solution {
    public int maxValue(int[][] grid) {

        return dfs(grid,0,0);
    }

    public int dfs(int[][] grid,int i,int j){
        if(i == grid.length || j == grid[0].length){
            return 0;
        }

        int r = dfs(grid,i,j+1);
        int b = dfs(grid,i+1,j);

        return Math.max(r,b) + grid[i][j];
    }
}