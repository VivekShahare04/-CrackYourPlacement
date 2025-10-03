class Solution {
    int mod = 1000000007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();
        for(int n:nums){
            hp.add(n);
        }
        long prd=1;
        while(k>0){
            int curr = hp.poll();
            curr = curr+1;
            hp.add(curr);
            k--;
        }
        while(!hp.isEmpty()){
            prd = (prd*hp.poll())%mod;
        }
        return (int)prd;
    }
}