class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
         if(n==1){
            ans[0] = 0;
            return ans;
        }
        if(n%2!=0){
            for(int i=1;i<n-1;i+=2){
                ans[i] = i;
                ans[i+1] = -i;
            }
        ans[0] = 0;
        }else{
            for(int i=0;i<n-1;i++){
                ans[i] = i+1;
                ans[n-i-1] = -(i+1);
            }
        }
        return ans;
    }
}