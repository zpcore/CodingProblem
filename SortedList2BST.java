/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private ListNode curNode;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        curNode = head;
        while(head!=null){
            head=head.next;
            size++;
        }
        return helper(0,size-1);
    }
    public TreeNode helper(int min, int max){
        if(min>max) return null;
        TreeNode newNode;
        /* This block is useless actually
        if(min==max){
            newNode = new TreeNode(curNode.val);
            curNode = curNode.next;
        }else{
        */
            int mid = min+(max-min)/2;
            TreeNode leftNode = helper(min,mid-1);//important, mid-1!!!
            newNode = new TreeNode(curNode.val);
            curNode = curNode.next;
            TreeNode rightNode = helper(mid+1,max);
            newNode.left = leftNode;
            newNode.right = rightNode;
        }
        return newNode;
    }
}