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

    // sbse pehle pair banana hai 
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode n , int i){
            node=n;
            index=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        //base case ki root hi null to 0
        if (root==null) return 0;
        // lets make  the queue ans and add the first node with 0 based inedexing
        Queue<Pair> qt=new LinkedList<>();
        qt.offer(new Pair(root,0));
        int ans=0; // for further comparision
        while(!qt.isEmpty()){
            int size=qt.size();
            int last=0;
            int first=0;
            int min=qt.peek().index;
            for(int i=0;i<size;i++){
                //taking current node
                TreeNode currentNode=qt.peek().node; 
                //updating the indexigng to be from mon again
                int newIndex=qt.peek().index-min;
                // pair uda do queue se 
                qt.poll();         
                // now checking if its firsr ot last
                if(i==0) first=newIndex;   
                if(i==size-1) last=newIndex;  
                // left jao 
                if(currentNode.left!=null) qt.offer(new Pair(currentNode.left,newIndex*2+1));
                // right jao 
                if(currentNode.right!=null) qt.offer(new Pair(currentNode.right,newIndex*2+2));
                }
                // compare kro ans ko
                ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}