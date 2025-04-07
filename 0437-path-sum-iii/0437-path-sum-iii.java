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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        sums(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }
    public void sums(TreeNode root,int targetSum,long sum){
        if(root==null){
            return ;
        }
        sum = sum + root.val;
       
        if(sum==targetSum)
            count++;    
        

        sums(root.left,targetSum,sum);
        sums(root.right,targetSum,sum);

    }
}