class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(nums[i]!=0)continue;

            if(allcombin(nums,i,true))count++;
            if(allcombin(nums,i,false))count++;
        }
        return count;
    }
    public static boolean allcombin(int[] arr,int start,boolean isleft){
        int n = arr.length;
        int[] nums = arr.clone();
        int i = start;
        while(i>=0 && i<n){
            if(nums[i]==0){
                if(isleft){
                    i--;
                }else{
                    i++;
                }
            }else if(nums[i]>0){
                nums[i]--;
                isleft = !isleft;
                if(isleft)i--;
                else i++;
            }

            // if(isleft)i--;
            // else i++;
        }
        for(int x:nums){
            if(x!=0)return false;
        } 
        return true;
    }
}