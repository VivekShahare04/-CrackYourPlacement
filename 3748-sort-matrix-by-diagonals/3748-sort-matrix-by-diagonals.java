import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int[] arr = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            arr[i] = grid[i][i];
        }
        Arrays.sort(arr);
        int n = arr.length - 1;
        for (int i = 0; i < grid.length; i++) {
            grid[i][i] = arr[n];
            n--;
        }        
        for (int i = 1; i < grid.length; i++) {
            arr = new int[grid.length - i];
            n = 0;
            for (int j = 0; j < grid.length - i; j++) {
                arr[n] = grid[j + i][j];  
                n++;
            }
            Arrays.sort(arr);
            n = arr.length - 1;
            for (int j = 0; j < grid.length - i; j++) {
                grid[j + i][j] = arr[n];  
                n--;
            }
        }
        for (int i = 1; i < grid.length; i++) {
            arr = new int[grid.length - i];
            n = 0;
            for (int j = 0; j < grid.length - i; j++) {
                arr[n] = grid[j][j + i];
                n++;
            }
            Arrays.sort(arr);
            n = 0;
            for (int j = 0; j < grid.length - i; j++) {
                grid[j][j + i] = arr[n];
                n++;
            }
        }
        return grid;
    }
}