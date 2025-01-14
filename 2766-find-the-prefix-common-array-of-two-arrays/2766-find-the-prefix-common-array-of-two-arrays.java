class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        int[] C = new int[n];
        for(int i=0;i<n;i++){
            if(!set.add(A[i])){
                count++;
            }
            if(!set.add(B[i])){
                count++;
            }
            C[i]=count;
        }
        return C;
    }
}