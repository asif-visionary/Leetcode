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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
//Beginner-friendly
// class Solution {
//     public ListNode middleNode(ListNode head) {

//         int c = 0;
//         ListNode temp = head;

//         // Step 1: count nodes
//         while (temp != null) {
//             c++;
//             temp = temp.next;
//         }

//         // Step 2: find middle
//         int mid = c / 2;

//         // Step 3: move to middle node
//         temp = head;
//         for (int i = 0; i < mid; i++) {
//             temp = temp.next;
//         }

//         return temp;
//     }
// }
