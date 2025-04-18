class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        for(int i = 0;i<nums2.length;i++){
             set.add(nums2[i]);
        }
        for(int i=0;i<nums3.length;i++){
            if(set.contains(nums3[i])){
                res.add(nums3[i]);
            }
        }
        return res.stream().toList();
        
    }
}