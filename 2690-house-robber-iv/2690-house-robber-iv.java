class Solution {
    public int minCapability(int[] nums, int k) {
        int minRew = 1;
        int maxRew = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;

        while (minRew < maxRew) {
            int midRew = (minRew + maxRew) / 2;
            int thefts = 0;

            for (int i = 0; i < totalHouses; ++i) {
                if (nums[i] <= midRew) {
                    thefts += 1;
                    i++;
                }
            }
            
            if (thefts >= k) {
                maxRew = midRew;
            }
            else {
                minRew = midRew + 1;
            }
        }
        return minRew;
    }
}