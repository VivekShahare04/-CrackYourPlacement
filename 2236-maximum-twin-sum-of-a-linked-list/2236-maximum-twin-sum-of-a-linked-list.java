/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int max = 0;
        int n = list.size();
        for(int i=0;i<n;i++){
            if(i<=(n/2)-1){
                max = Math.max(max,list.get(i)+list.get(n-i-1));
            }
        }
        return max;
    }
}