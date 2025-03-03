class Solution {
    public int removeElement(int[] nums, int val) {
        int [] otherNums = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                otherNums[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            nums[i] = otherNums[i];
        }
        return index;
    }
}