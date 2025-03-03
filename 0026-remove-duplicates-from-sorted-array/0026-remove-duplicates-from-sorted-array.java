class Solution {
    public int removeDuplicates(int[] nums) {
        int index1 = 1; // Represent true Index
        int lastArrayVal = nums[0]; // For Control Duplicates

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastArrayVal) {
                nums[index1] = nums[i];
                index1++;
                lastArrayVal = nums[i];
            }
        }
        return index1;
    }
}