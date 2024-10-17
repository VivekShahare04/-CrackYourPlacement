class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr = new char[word1.length()+word2.length()];
        int i=0,j=0,k=0;

        while(i<word1.length() && j<word2.length()){
            arr[k++]=word1.charAt(i++);
            arr[k++]=word2.charAt(j++);
        }
            while(i<word1.length()){
                arr[k++]=word1.charAt(i++);
            }

            while(j<word2.length()){
                arr[k++]=word2.charAt(j++);
            }
        return new String(arr);
    }
}