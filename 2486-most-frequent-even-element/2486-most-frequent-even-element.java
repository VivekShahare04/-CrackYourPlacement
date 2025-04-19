class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int ans=-1;
        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(count>max || (count==max && num<ans)){
                max=count;
                ans=num;
            }
        }
        return ans;
    }
}