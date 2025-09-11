class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;
        int n = s.length()/2; //2
        char[] chars = s.substring(0,n).toCharArray(); // b, a 
        Arrays.sort(chars); // a,b
        String curr = new String(chars); //ab
        StringBuilder sb = new StringBuilder(curr).reverse(); //ba
        if(s.length()%2!=0){ //!=
            curr = curr + s.charAt(n);//abb
        }

        return curr + sb.toString();// abbba
    }
}