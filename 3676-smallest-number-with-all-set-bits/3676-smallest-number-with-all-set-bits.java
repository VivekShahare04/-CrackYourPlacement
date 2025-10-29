class Solution {
    public int smallestNumber(int n) {
        int x = n;
        while(true){
            int i=x;
            boolean flag=true;
            while(i!=0){
                int rem = i%2;
                if(rem==0){
                    flag=false;
                    break;
                }
                i=i/2;
            }
            if(flag)return x;
            x++;
        }
    }
}