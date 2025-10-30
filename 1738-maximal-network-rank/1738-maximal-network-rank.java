class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] deg = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road:roads){
            int a = road[0];
            int b = road[1];
            deg[a]++;
            deg[b]++;
            connected[a][b]=true;
            connected[b][a]=true;
        }

        int maxrank=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank = deg[i]+deg[j];
                if(connected[i][j])rank--;
                maxrank = Math.max(maxrank,rank);
            }
        }
        return maxrank;
    }
}