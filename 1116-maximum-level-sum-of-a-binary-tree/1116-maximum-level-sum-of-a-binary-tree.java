/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=1;
        int maxlevel=1;
        int maxsum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n = q.size();
            int sum=0;

            TreeNode node  = new TreeNode();
            for(int i=0;i<n;i++){
                node = q.poll();
                sum = sum + node.val;

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            if(sum>maxsum){
                maxsum=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}