class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum=0;
        int maxtime = neededTime[0];
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i-1)==colors.charAt(i)){
                sum += Math.min(maxtime,neededTime[i]);
                maxtime = Math.max(maxtime,neededTime[i]);
            }else{
                maxtime = neededTime[i];
            }
        }
        return sum;
    }
}