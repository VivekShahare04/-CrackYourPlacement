class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n];
        int carry=1;

        for(int i=n-1;i>=0;i--){
            int sum = digits[i]+carry;
            if(sum>9){
                carry=1;
                result[i]=sum-10;
            }else{
                carry=0;
                result[i]=sum;     
            }   
        }
        if(carry==1){
            int[] newresult = new int[n+1];
            newresult[0]=1;
            for(int i=0;i<n;i++){
                newresult[i+1]=result[i];
            }
            return newresult;
        }else{
            return result;
        }
    }
}