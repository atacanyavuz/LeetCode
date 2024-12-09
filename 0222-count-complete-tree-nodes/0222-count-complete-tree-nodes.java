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
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) return 0;
        if (root.left != null) {
            int leftCounter = countNodes(root.left);
            count += leftCounter;
        }
        if (root.right != null) {
            int rightCounter = countNodes(root.right);
            count += rightCounter;
        }
        count++;
        return count;
    }
}