class NumArray {
    SegmentTree tree;
    public NumArray(int[] nums) {
        this.tree = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        tree.update(index,val);
    }
    
    public int sumRange(int left, int right) {
        return tree.query(left,right);
    }

    class SegmentTree{
        int n;
        int[] segment;

        public SegmentTree(int[] nums){
            this.n = nums.length;
            this.segment = new int[4*n];
            construct(nums,0,0,n-1);
        }

        public void construct(int[] nums,int idx, int low,int high){
            if(low==high){
                segment[idx] = nums[low];
                return;
            }
            int mid = (low+high)/2;
            construct(nums,2*idx+1,low,mid);
            construct(nums,2*idx+2,mid+1,high);
            segment[idx] = segment[2*idx+1] + segment[2*idx+2];
        }

        public void update(int idx,int val){
            updateutil(0,0,n-1,idx,val);
        }
        public void updateutil(int idx,int low,int high,int index,int val){
            if(low==high){
                segment[idx] = val;
                return;
            }
            int mid = (low+high)/2;
            if(index<=mid){
                updateutil(2*idx+1,low,mid,index,val);
            }else{
                updateutil(2*idx+2,mid+1,high,index,val);
                //segment[idx] = segment[2*idx+1] + segment[2*idx+2];
            }
            segment[idx] = segment[2 * idx + 1] + segment[2 * idx + 2];
        }
        public int query(int low,int high){
            return queryutil(0,0,n-1,low,high);
        }
        public int queryutil(int idx,int low,int high,int left,int right){
            if(right<low || left>high)return 0;
            if(left<=low && high<=right)return segment[idx];

            int mid = (low+high)/2;
            int l = queryutil(2*idx+1,low,mid,left,right);
            int r = queryutil(2*idx+2,mid+1,high,left,right);
            return l+r;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */