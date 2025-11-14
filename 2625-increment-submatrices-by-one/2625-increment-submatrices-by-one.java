class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans [][]=new int [n][n];
        for(int i=0;i<queries.length;i++){
            ///get a particualr query 
            int []curr=queries[i];
            for(int j=curr[0];j<=curr[2];j++){
                for(int k=curr[1];k<=curr[3];k++){
                    ans[j][k]+=1;
                }
            }
        }
        return ans;
    }
    //tc->O(n3)
}