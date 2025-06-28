class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();
        int[] ans = new int[k];
        int i=0;
        for(int n:nums){
            hp.add(n);
            if(hp.size()>k){
                hp.poll();
            }
        }

        while(hp.size()>0){
            for(int n:nums){
                if(hp.contains(n)){
                    ans[i]=n;
                    i++;
                    hp.remove(n);
                }
            }
        }
        return ans;
        
    }
}