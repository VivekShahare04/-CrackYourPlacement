class Solution {
    public int largestAltitude(int[] gain) {
        int[] arr = new int[gain.length+1];
        arr[0]=0;
        int  max=arr[0];
        for(int i=0;i<gain.length;i++){
            arr[i+1] = arr[i] + gain[i]; 
            max = Math.max(max,arr[i+1]);
        }
        return max;
    }
}