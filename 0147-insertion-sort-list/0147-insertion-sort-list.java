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
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(head!=null){
            ls.add(head.val);
            head = head.next;
        }
        int n = ls.size();
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && ls.get(j-1)>ls.get(j)){
                int t = ls.get(j);
                ls.set(j, ls.get(j - 1));
                ls.set(j - 1, t);
                j--;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int num:ls){
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }
}