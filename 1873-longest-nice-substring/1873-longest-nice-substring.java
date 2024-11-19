class Solution {
    public String longestNiceSubstring(String s) {
        int maxlen=0;
        String res="";

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String str = s.substring(i,j);
                if(isnicestring(str) && str.length()>maxlen){
                    maxlen = str.length();
                    res = str;
                }
            }
        }
        return res;
    }
    public static boolean isnicestring(String s){
        Set<Character> set = new HashSet<>();

        for(char c:s.toCharArray()){
            set.add(c);
        }

        for(char c:set){
            if(!set.contains(Character.toUpperCase(c))||!set.contains(Character.toLowerCase(c))){
                return false;
            }
        }
        return true;
    }
}