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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return null; 
        int rootValue=preorder[preStart];
        TreeNode root=new TreeNode(rootValue);
        int rootIndex=findIndex(inorder,inStart,inEnd,rootValue);
        int leftSize=rootIndex-inStart;

        //left call
        root.left=build(preorder,inorder,preStart+1,preStart+leftSize,inStart,rootIndex-1);
        // rihght calll 
        root.right=build(preorder,inorder,preStart+leftSize+1,preEnd,rootIndex+1,inEnd);

        return root;
    }
     public int findIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1; // shouldn't happen if inputs are valid
    }
}