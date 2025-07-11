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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traversal(root,ls);
        return ls;
    }
    public void traversal(TreeNode root,List<Integer> ls){
        if(root==null)return;
        traversal(root.left,ls);
        ls.add(root.val);
        traversal(root.right,ls);
    }
}