class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;

        for(int i=0;i<=s.length()-3;i++){
            String str = s.substring(i,i+3);

            if(isgoodstring(str)){
                count++;
            }
        }
        return count;
    }
    public static boolean isgoodstring(String s){
       return s.charAt(0)!=s.charAt(1)&&s.charAt(1)!=s.charAt(2)&&s.charAt(2)!=s.charAt(0);
    }
}