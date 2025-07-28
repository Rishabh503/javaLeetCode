/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
      int arr[]=new int[1];
      arr[0]=-1;
      count(root,arr);
      return arr[0];
    }
    public void count(TreeNode root,int arr[]){
        if(root==null){
            arr[0]+=1;
            return;
        }
        count(root.right,arr);
        count(root.left,arr);
    }
}