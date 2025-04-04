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
    public ListNode deleteMiddle(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int n = list.size()/2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i=0;i<list.size();i++){
            if(i==n){
                continue;
            }else{
                curr.next = new ListNode(list.get(i));
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}