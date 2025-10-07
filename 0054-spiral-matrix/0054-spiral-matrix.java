class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int left=0;
        int right=n-1;
        int top=0;
        int down = m-1;

        while(left<=right && top<=down){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=down;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=down){
                for(int i=right;i>=left;i--){
                    list.add(matrix[down][i]);
                }
                down--;
            }
            
            if(left<=right){
                for(int i=down;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            
        }

        return list;
    }
}