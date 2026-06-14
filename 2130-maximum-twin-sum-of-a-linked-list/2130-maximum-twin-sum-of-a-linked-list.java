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
        ArrayList<Integer> ls = new ArrayList<>();
        int count=0;
        while(head!=null){
            ls.add(head.val);
            count++;
            head = head.next;
        }
        //count++;
        int maxsum = 0;
        boolean[] vis = new boolean[count];

        for(int i=0;i<count;i++){
            int sum=ls.get(i);
            vis[i] = true;
            if(i>=0 && i<= (count/2)-1 && !vis[count-1-i]){
                sum += ls.get(count-1-i);
                vis[count-1-i] = true;
            }
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum;
    }
}