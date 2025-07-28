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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ll=new ArrayList<>();
        path(root,"",ll);
        return ll;
    }
    public void path(TreeNode root,String ans,List<String> ll){
        if(root.left==null && root.right==null){
            ll.add(ans+root.val);
            return;
        }
         if(root.left!=null) path(root.left,ans+root.val+"->",ll);
        if(root.right!=null) path(root.right,ans+root.val+"->",ll);
    }
}