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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root==q || root==p) return root;

        TreeNode lca=lowestCommonAncestor(root.left,p,q);
        TreeNode rca=lowestCommonAncestor(root.right,p,q);

        if(lca!=null && rca!=null) return root;

        return (lca!=null)?lca:rca;

    }
}