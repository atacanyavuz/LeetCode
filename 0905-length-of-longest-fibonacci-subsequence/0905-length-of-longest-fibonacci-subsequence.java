class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            numSet.add(arr[i]);
        }

        for (int start = 0; start < arr.length; ++start) {
            for (int next = start + 1; next < arr.length; ++next) {
                int len = 2;
                int f1 = arr[start];
                int f2 = arr[next];

                while (numSet.contains(f1 + f2)) {
                    int temp = f1 + f2;
                    f1 = f2;
                    f2 = temp;
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;

    }
}