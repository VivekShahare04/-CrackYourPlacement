class Solution {
    public int equalPairs(int[][] grid){
        int n = grid.length;
       Map<String,Integer> map = new HashMap<>();
       for(int[] row:grid){
        String rowpattern = arraytostring(row);
        map.put(rowpattern,map.getOrDefault(rowpattern,0)+1);
       }

       int count=0;

       for(int j=0;j<n;j++){
        int[] col = new int[n];
        for(int i=0;i<n;i++){
            col[i] = grid[i][j];
        }
        String colpattern = arraytostring(col);
        count = count + map.getOrDefault(colpattern,0);
       }
       return count; 
    }
    public String arraytostring(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int num:arr){
            sb.append(num).append(',');
        }
        return sb.toString();
    }
}