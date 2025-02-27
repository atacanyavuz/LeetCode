class Solution {
    HashMap<Integer, Integer> counter;

    private void countRecursive(TreeNode root) {
        if (root.left != null) {
            countRecursive(root.left);
        }
        if (root.right != null) {
            countRecursive(root.right);
        }
        if (counter.containsKey(root.val)) {
            counter.put(root.val, counter.get(root.val) + 1);
        } else {
            counter.put(root.val, 1);
        }
        return;
    }

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList();
        counter = new HashMap<Integer, Integer>();

        countRecursive(root);
        int maxCounter = Collections.max(counter.values());
        for (Integer key : counter.keySet()) {
            if (counter.get(key) == maxCounter) {
                arr.add(key);
            }
        }

        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}