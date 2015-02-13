//leetcode 2nd 2015/2/10
//Mingxuan Wang
//deleteDuplicates

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode t = head;
        while (t.next != null){
            if (t.val == t.next.val){
                t.next = t.next.next;
            }else{
                t = t.next;
            }
        }
        return head;
    }
}