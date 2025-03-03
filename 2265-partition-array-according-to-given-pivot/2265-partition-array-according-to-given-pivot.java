class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] lowerPivotArray = new int[nums.length];
        int[] upperPivotArray = new int[nums.length];
        int index1 = 0, index2 = 0, pivotCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                lowerPivotArray[index1] = nums[i];
                index1++;
            } else if (nums[i] > pivot) {
                upperPivotArray[index2] = nums[i];
                index2++;
            } else {
                pivotCounter++;
            }
        }
        for (int i = 0; i < index1; i++) {
            nums[i] = lowerPivotArray[i];
        }
        for (int i = 0; i < pivotCounter; i++) {
            nums[index1 + i] = pivot;
        }
        for (int i = 0; i < index2; i++) {
            nums[index1 + pivotCounter + i ] = upperPivotArray[i];
        }
        return nums;
    }
}