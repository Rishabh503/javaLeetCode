class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainList = new ArrayList<>();
        if (root == null) return mainList;

        Queue<TreeNode> qt = new LinkedList<>();
        qt.add(root);
        boolean leftToRight = true;

        while (!qt.isEmpty()) {
            int size = qt.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = qt.poll();

                if (leftToRight) {
                    level.addLast(currentNode.val);  
                } else {
                    level.addFirst(currentNode.val); 
                }

                if (currentNode.left != null) qt.add(currentNode.left);   
                if (currentNode.right != null) qt.add(currentNode.right); 
            }

            mainList.add(level);
            leftToRight = !leftToRight;
        }

        return mainList;
    }
}
