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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(head!=null){
            ls.add(head.val);
            head = head.next;
        }
        Collections.sort(ls);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int n:ls){
            curr.next = new ListNode(n);
            curr = curr.next;
        }
        return dummy.next;
    }
}