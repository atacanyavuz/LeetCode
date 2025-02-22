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
    String traverseString;

    private boolean controlChild(int depth){
        return traverseString.startsWith("-".repeat(depth + 1));
    }
    private void addChild(TreeNode root, boolean side, int depth){
        traverseString = traverseString.substring(depth + 1);
        int val;
        try{
            val = Integer.parseInt(traverseString.substring(0, traverseString.indexOf("-")));
            traverseString = traverseString.substring(traverseString.indexOf("-"));
        }
        catch(Exception e){
            val = Integer.parseInt(traverseString);
        }

        if (side == false) {
            root.left = new TreeNode(val);
        }
        else if (side == true) {
            root.right = new TreeNode(val);
        }
        return;
    }

    public void recursiveCreateTree(TreeNode node, int depth){
        if (controlChild(depth)) {
            addChild(node, false, depth);
            recursiveCreateTree(node.left, depth + 1);
        }
        if (controlChild(depth)) {
            addChild(node, true, depth);
            recursiveCreateTree(node.right, depth + 1);
        }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root;

        try{
            traverseString = traversal.substring(traversal.indexOf("-"));
            root = new TreeNode(Integer.parseInt(traversal.substring(0, traversal.indexOf("-"))));
            traverseString = traverseString.substring(traverseString.indexOf("-"));
        }
        catch(Exception e){
            int val = Integer.parseInt(traversal);
            root = new TreeNode(val);
            return root;
        }

        
        recursiveCreateTree(root, 0);
        return root;
    }
}