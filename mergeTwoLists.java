//leetcode 2nd 2015/2/7
//Mingxuan Wang
//mergeTwoLists

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = null;
        ListNode proc = null;
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null && l2 != null){
            return l2;
        }
        if (l2 == null && l1 != null){
            return l1;
        }
        
        if (p.val <= q.val){
            head = p;
            p=p.next;
        }
        else{
            head = q;
            q = q.next;
        }
        proc=head;
        while(p!=null && q!=null){
            if (p.val <= q.val){
                proc.next=p;
                proc=p;
                p=p.next;
            }
            else{
                proc.next=q;
                proc=q;
                q=q.next;
            }
        }
        if (p == null){
            while(q!=null){
                proc.next=q;
                proc=q;
                q=q.next;
            }
        }
        else{
            while(p!=null){
                proc.next=p;
                proc=p;
                p=p.next;
            }
        }
        return head;
    }
}