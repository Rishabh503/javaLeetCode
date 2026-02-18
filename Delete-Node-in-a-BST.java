1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root==null) return null;
19        //finding the key 
20
21        //in the left half
22        if(key<root.val) root.left=deleteNode(root.left,key);
23        // in the right half
24        else if(key>root.val) root.right=deleteNode(root.right,key);
25        //say we found it 
26        else{
27            //no child
28            if(root.left==null && root.right==null) return null;
29            //one child
30            if(root.left==null){
31                return root.right;
32            }else if(root.right==null){
33                return root.left;
34            }
35               //2 child
36            else{
37                TreeNode node=findPredecessor(root.left);
38
39                root.val=node.val;
40
41                root.left=deleteNode(root.left,node.val);
42            }
43         
44        }
45        return root;
46    }
47
48    public TreeNode findPredecessor(TreeNode node){
49        while(node.right!=null){
50            node=node.right;
51        }
52        return node;
53    }
54}