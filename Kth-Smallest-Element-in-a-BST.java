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
    public int kthSmallest(TreeNode root, int k) {
        int order[]=new int[1];
        return ksmall(root,k,order);

    }
    public int ksmall(TreeNode root,int k,int order[]){
        if(root==null) return -1;

        if(root.left!=null){
            int leftAns=ksmall(root.left,k,order);
            if(leftAns!=-1) return leftAns;
        }
        order[0]++;
        if(order[0]==k){
            return root.val;
        }
        if(root.right!=null){
            int rightAns=ksmall(root.right,k,order);
            if(rightAns!=-1) return rightAns;
        }
        return -1;
    }
}