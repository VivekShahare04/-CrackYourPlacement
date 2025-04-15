class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int n:nums1){
            list.add(n);
        }
        for(int n:nums2){
            list.add(n);
        }
        Collections.sort(list);
        int mid = list.size()/2;
        if(list.size()%2==0){
            return (double)(list.get(mid) + list.get(mid-1))/2;
        }
        return (double)(list.get(mid));
    }
}