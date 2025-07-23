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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mainList=new ArrayList<>();
         if (root == null) return mainList;

        Queue<TreeNode> qt = new LinkedList<>();
        qt.add(root);


      while(!qt.isEmpty()){
          int size=qt.size();
          List<Integer> currentLevel=new ArrayList<>();
          for(int i=0;i<size;i++){
            TreeNode currentNode=qt.poll();
            currentLevel.add(currentNode.val);
            if(currentNode.left!=null) qt.add(currentNode.left);
            if(currentNode.right!=null) qt.add(currentNode.right);
          }
          mainList.add(currentLevel);
      }
            return mainList;
    }
}