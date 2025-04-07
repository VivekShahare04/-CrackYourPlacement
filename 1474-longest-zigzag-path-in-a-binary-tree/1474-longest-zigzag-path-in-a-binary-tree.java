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
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(helper(root.left,1,false),helper(root.right,1,true));
    }
    public int helper(TreeNode root,int count,boolean direction){
        if(root==null){
            return count-1;
        }

        if(direction){
            return Math.max(helper(root.left,count+1,false),helper(root.right,1,true));
        }else{
            return Math.max(helper(root.right,count+1,true),helper(root.left,1,false));
        }
    }
}