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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> qt=new LinkedList<>();
        qt.add(root);
        while(!qt.isEmpty()){
            int size=qt.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode=qt.poll();
                if(i==size-1){
                    ans.add(currentNode.val);
                }
                if(currentNode.left!=null) qt.add(currentNode.left);
                if(currentNode.right!=null) qt.add(currentNode.right);
            }
        }
        return ans;
    }
}