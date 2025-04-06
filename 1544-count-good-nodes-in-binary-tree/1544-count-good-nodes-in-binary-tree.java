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
    public int dfs(TreeNode root,int m){
        if(root==null){
            return 0;
        }
        int ans=0;
        if(root.val>=m){
            ans++;
            m = root.val;
        }
        return ans+dfs(root.left,m)+dfs(root.right,m);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
}