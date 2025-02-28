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
    ArrayList<Integer> sortedSmallestList;
    int target;
    boolean resFind;

    private void addElementToList(int element){
        sortedSmallestList.add(element);
        Collections.sort(sortedSmallestList);
    }

    private void findKThSmallestRecursive(TreeNode root){
        if (resFind) { return; }
        if (root.left != null) {
            findKThSmallestRecursive(root.left);
            if (sortedSmallestList.size() >= target) {
                resFind = true;
            }
        }
        if (root.right != null) {
            findKThSmallestRecursive(root.right);
        }
        if (sortedSmallestList.size() < target) {
            addElementToList(root.val);
        }
        else if(root.val < sortedSmallestList.get(target - 1)){
            addElementToList(root.val);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        sortedSmallestList = new ArrayList<>();
        target = k;
        resFind = false;
        findKThSmallestRecursive(root);

        return sortedSmallestList.get(target - 1);
    }
}