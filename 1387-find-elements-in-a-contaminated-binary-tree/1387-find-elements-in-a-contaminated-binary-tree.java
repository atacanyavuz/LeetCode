import com.sun.source.tree.Tree;

class FindElements {
    TreeNode root;
    Queue<TreeNode> preparationTreeQueue = new LinkedList<TreeNode>();

    private void ConstructTree(TreeNode root) {
        if (root.val == -1) {
            root.val = 0;
        }

        if (root.left != null) {
            preparationTreeQueue.add(root.left);
            root.left.val = root.val * 2 + 1;
        }
        if (root.right != null) {
            preparationTreeQueue.add(root.right);
            root.right.val = root.val * 2 + 2;
        }
        TreeNode temp = preparationTreeQueue.peek();
        if (temp != null) {
            preparationTreeQueue.remove();
            ConstructTree(temp);
        }
    }

    public FindElements(TreeNode root) {
        this.root = root;
        ConstructTree(root);
    }

    private boolean findRecursive(TreeNode node, int target) {
        boolean leftRes = false;
        boolean rightRes = false;

        if (node.val == target) {
            return true;
        }
        if (node.left != null) {
            leftRes = findRecursive(node.left, target);
        }
        if (node.right != null) {
            rightRes = findRecursive(node.right, target);
        }
        return leftRes || rightRes;
    }

    public boolean find(int target) {
        return findRecursive(this.root, target);
    }
}
