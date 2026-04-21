class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int l=0,h=n-1;
        int max=0;


        while(l<h){
            int w = h-l;
            int area = w*Math.min(height[l],height[h]);
            max = Math.max(area,max);
            if(height[l]<height[h]){
                l++;
            }else{
                h--;
            }
        }
        return max;
    }
}