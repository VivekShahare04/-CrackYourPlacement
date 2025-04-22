class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int skip = 0;
        int end = Integer.MIN_VALUE;

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<end){
                skip++;
            }else{
                end = Math.max(end,intervals[i][1]);
            }
        }
        return skip;
    }
}