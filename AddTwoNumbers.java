/**
* You are given two non-empty linked lists representing two non-negative integers. 
* The digits are stored in reverse order and each of their nodes contain a single digit. 
* Add the two numbers and return it as a linked list
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
    	if (l1 == null && l2 == null && carryOver == 0){
            return null;
        }
        else if (l1 == null && carryOver == 0){
            return l2;
        }
        else if(l2 == null && carryOver == 0){
            return l1;
        }
        else {
            int val1 = (l1 != null)? l1.val : 0;
            int val2 = (l2 != null)? l2.val : 0;
        	int sum = val1 + val2 + carryOver ;
            int remainder = sum % 10;
            carryOver = sum / 10;
            ListNode result = new ListNode(remainder );
            
            l1 = (l1 != null)? l1.next : l1;
            l2 = (l2 != null)? l2.next : l2;
            result.next = addTwoNumbers(l1, l2, carryOver);
            return result;
        }
    }

}
