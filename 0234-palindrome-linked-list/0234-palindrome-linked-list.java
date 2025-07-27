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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(head!=null){
            ls.add(head.val);
            head = head.next;
        }
        int first=0;
        int last = ls.size()-1;
        while(first<last){
            if(ls.get(first)!=ls.get(last)){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}