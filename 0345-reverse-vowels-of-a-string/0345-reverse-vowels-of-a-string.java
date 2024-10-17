class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char[] arr = s.toCharArray();
        while(i<j){  
            if(isvowel(arr[i])){
                if(isvowel(arr[j])){
                    char tmp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                    i++;
                    j--;
                }else{
                j--;
            }
            }
            else{
                i++;
            }
        }
        return new String(arr);
    }
    public boolean isvowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}