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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum,res,new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root,int sum,List<List<Integer>> res,List<Integer> ls){
        if(root==null)return;

        ls.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(ls));
        } else {
            dfs(root.left, sum - root.val, res,ls);
            dfs(root.right, sum - root.val, res,ls);
        }

        ls.remove(ls.size()-1);
    }
}