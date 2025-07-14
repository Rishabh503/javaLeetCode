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
    class Pair{
        int hieght;
        boolean balance;

        Pair(int h,boolean b){
            this.hieght=h;
            this.balance=b;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return checkIsBalanced(root).balance;
    }

    public Pair checkIsBalanced(TreeNode root){
        if(root==null){
            return new Pair(0,true);
        }

        Pair lt=checkIsBalanced(root.left);
        Pair rt=checkIsBalanced(root.right);

        int maxH=1+Math.max(lt.hieght,rt.hieght);

        boolean balanced=lt.balance && rt.balance && (Math.abs(lt.hieght-rt.hieght)<=1);
        return new Pair(maxH,balanced);
    }
}