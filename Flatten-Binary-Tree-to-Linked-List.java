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
    public void flatten(TreeNode root) {
        TreeNode nr[]=new TreeNode[1];
        flat(root,nr);
        return;
    }
    public void flat(TreeNode root,TreeNode nr[]){
        if(root==null) return;
        flat(root.right,nr);
        flat(root.left,nr);
        root.left=null;
        root.right=nr[0];
        nr[0]=root;
    }
}