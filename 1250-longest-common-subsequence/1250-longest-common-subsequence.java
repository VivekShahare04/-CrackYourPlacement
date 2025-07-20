class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n+1][m+1];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,n,m,memo);
    }
    public int helper(String text1,String text2,int n,int m,int[][] memo){
        if(n==0||m==0)return 0;
        if(memo[n][m]!=-1)return memo[n][m];
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            memo[n][m] = 1 + helper(text1,text2,n-1,m-1,memo);
        }else{
            memo[n][m]= Math.max(helper(text1,text2,n-1,m,memo), helper(text1,text2,n,m-1,memo));
        }

        return memo[n][m];
    }
}