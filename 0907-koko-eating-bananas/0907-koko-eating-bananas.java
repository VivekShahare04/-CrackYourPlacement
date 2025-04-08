class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = findmax(piles);

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalhr = calculatetotalhrs(piles, mid);
            if (totalhr <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int findmax(int[] piles){
        int max = Integer.MIN_VALUE;
        int n = piles.length;

        for(int i=0;i<n;i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
    public int calculatetotalhrs(int[] piles,int hrs){
        int totalhr = 0;
        int n = piles.length;

        for(int i=0;i<n;i++){
            totalhr += Math.ceil((double)(piles[i])/(double)(hrs));
        }
        return totalhr;
    }
}