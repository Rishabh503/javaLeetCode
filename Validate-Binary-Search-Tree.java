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
    public boolean isValidBST(TreeNode root) {
      return valid(root,null,null);
    }

    public boolean valid(TreeNode root,TreeNode min,TreeNode max){
  //base case
            if(root==null) return true;
        //left check kr
            if(min!=null && root.val>=min.val) return false;
        //right check kr 
            if(max!=null && root.val<=max.val) return false;
        // dono ka and 
        return valid(root.left,root,max) && valid(root.right,min,root);
    }
}