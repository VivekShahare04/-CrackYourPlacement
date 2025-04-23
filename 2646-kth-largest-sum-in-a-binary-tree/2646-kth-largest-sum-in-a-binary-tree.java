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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> list = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            long sum=0;

            TreeNode node = new TreeNode();
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
            list.add(sum);
        }
        Collections.sort(list,Collections.reverseOrder());
        if(k>list.size()){
            return -1;
        }
        return list.get(k-1);
    }
}