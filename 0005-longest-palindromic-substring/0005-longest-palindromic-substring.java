class Solution {
        int start=0;
		int end=0;
		int maxlen=0;
    public String longestPalindrome(String s) {
        int n =s.length();
	    for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(ispalindrome(s,i,j)==true){
					if((j-i+1)>maxlen){
						maxlen=j-i+1;
						start=i;
						end=j;
					}
				}
			}
		}
		return s.substring(start,end+1);
    }
    public static boolean ispalindrome(String str,int i,int j){
		while(i<j){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}