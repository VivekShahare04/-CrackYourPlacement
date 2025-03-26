class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int ans=0;
        int[] a = new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i*n+j] = grid[i][j];
            }   
        }
        if(Arrays.stream(a).anyMatch(num->(num-a[0])%x!=0)){
            return -1;
        }
        Arrays.sort(a);
        for(int num:a){
            ans = ans + Math.abs(num - a[a.length/2])/x;
        }
        return ans;
    }
}