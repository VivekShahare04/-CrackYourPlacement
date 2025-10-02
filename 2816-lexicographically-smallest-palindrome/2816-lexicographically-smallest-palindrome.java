class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l=0;
        int h=s.length()-1;

        while(l<=h){
            if(!ispalindrome(arr[l],arr[h])){
                if(arr[l]>arr[h]){
                    arr[l] = arr[h];
                }else{
                    arr[h]=arr[l];
                }
            }
            l++;
            h--;
        }
        return new String(arr);

    }
    public static boolean ispalindrome(Character i,Character j){
        if(i==j){
            return true;
        }
        return false;
    }
}