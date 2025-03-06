class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int[] numbers = new int[grid.length * grid.length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                numbers[grid[i][j]]++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) res[1] = i;
            if (numbers[i] == 2) res[0] = i;
        }
        return res;
    }
}