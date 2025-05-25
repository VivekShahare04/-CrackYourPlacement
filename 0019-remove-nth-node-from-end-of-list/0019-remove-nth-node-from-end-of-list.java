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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int pos = list.size() - n;
        list.remove(pos);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int ele : list){
            curr.next = new ListNode(ele);
            curr = curr.next;
        }
        return dummy.next;
    }
}