class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int a[] = new int[n];
       Arrays.fill(a,1); //sabhi ko atleast ek candy toh deni hi hai

       //left  to right pass krunga 
       for(int i=1;i<n;i++){
        if(ratings[i]>ratings[i-1]){
            a[i] = a[i-1]+1;
        }
       }

       //right to left oass
       for(int i=n-2;i>=0;i--){
        if(ratings[i]>ratings[i+1]){
            a[i] = Math.max(a[i],a[i+1]+1);
        }
       }
       int total = 0;
       for(int c:a){
        total = total+c;
       }
       return total;
    }
}