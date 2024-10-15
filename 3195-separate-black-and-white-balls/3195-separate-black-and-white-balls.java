class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int pos=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                pos++;
            }else{
                ans = ans + pos;
            }
        }
        return ans;
    }
}