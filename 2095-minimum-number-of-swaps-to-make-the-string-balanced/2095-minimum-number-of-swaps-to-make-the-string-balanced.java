class Solution {
    public int minSwaps(String s) {
        int imbalance=0;
        int maxbalance=0;
        for(char c:s.toCharArray()){

            if(c=='['){
                imbalance--;
            }
            else if(c==']'){
                imbalance++;
            }

            maxbalance = Math.max(maxbalance,imbalance);
        }
        return (maxbalance+1)/2;
    }
}