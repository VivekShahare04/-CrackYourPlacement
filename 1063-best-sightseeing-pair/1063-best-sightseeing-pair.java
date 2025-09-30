class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max=Integer.MIN_VALUE;
        int best = values[0]+0;

        for(int i=1;i<n;i++){
            max = Math.max(max,best+values[i]-i);
            best = Math.max(best,values[i]+i);
        }
        return max;
    }
}