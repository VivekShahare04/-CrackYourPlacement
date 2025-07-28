class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int or = nums[0];
        for(int i=1;i<nums.length;i++){
            or|=nums[i];
        }
        return find(0,nums,or,0);
    }
    public static int find(int i,int[] nums,int or,int x){
        if(i==nums.length){
            return x==or?1:0;
        }
        int take = find(i+1,nums,or,x|nums[i]);
        int not = find(i+1,nums,or,x);
        return take + not;
    }
}