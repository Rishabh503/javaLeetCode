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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
    public int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
         int lh=hieght(root.left);
        int rh=hieght(root.right);
         int ld=diameter(root.left);
        int rd=diameter(root.right);
        int op3=lh+rh;
        return Math.max(ld,(Math.max(rd,op3)));
    }
    public int hieght(TreeNode root){
            if(root==null){
                return 0;
            }
        
        int lh=hieght(root.left);
        int rh=hieght(root.right);
        return Math.max(lh,rh)+1;
    }
}