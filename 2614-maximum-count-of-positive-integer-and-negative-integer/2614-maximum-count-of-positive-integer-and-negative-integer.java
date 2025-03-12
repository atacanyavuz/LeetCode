class Solution {
    private int centerOfRange(int[] range){
        return (range[0] + range[1]) / 2;
    }

    public int maximumCount(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 0;
            }      
            else{
                return 1;
            }
        }

        int[] negativeRange = {0, nums.length - 1};
        int maxOfNegatives = 0;
        int[] positiveRange = {0, nums.length - 1};
        int minOfPositives = 0;

        while (true) {
            int centerOfNegatives = centerOfRange(negativeRange);
            if (nums[centerOfNegatives] < 0 && nums[centerOfNegatives + 1] >= 0) {
                maxOfNegatives = centerOfNegatives;                
                break;
            }
            if (nums[centerOfNegatives] < 0) {
                if(negativeRange[0] == centerOfNegatives){
                    negativeRange[0] = centerOfNegatives + 1;
                }
                else{
                    negativeRange[0] = centerOfNegatives;
                }
            }
            else{
                negativeRange[1] = centerOfNegatives;
            }            
            if (negativeRange[0] == negativeRange[1]) {
                if (negativeRange[1] == 0) {
                    maxOfNegatives = -1;
                }                
                else if(negativeRange[0] == nums.length - 1){
                    maxOfNegatives = nums.length - 1;
                }
                break;
            }
        }
        while (true) {
            int centerOfPositives = centerOfRange(positiveRange);
            if (nums[centerOfPositives] <= 0 && nums[centerOfPositives + 1] > 0) {
                minOfPositives = centerOfPositives + 1;                
                break;
            }
            if (nums[centerOfPositives] <= 0) {
                if(positiveRange[0] == centerOfPositives){
                    positiveRange[0] = centerOfPositives + 1;
                }
                else{
                    positiveRange[0] = centerOfPositives;
                }
            }
            else{
                positiveRange[1] = centerOfPositives;
            }            

            if (positiveRange[0] == positiveRange[1]) {
                if (positiveRange[1] == 0) {
                    minOfPositives = 0;
                }                
                else if(positiveRange[0] == nums.length - 1){
                    minOfPositives = -1;
                }
                break;
            }
        }
        if (minOfPositives == -1 && maxOfNegatives == -1) {
            return 0;            
        }
        if (minOfPositives == -1) {
            return maxOfNegatives + 1;            
        }
        if (maxOfNegatives == -1) {
            return nums.length - minOfPositives;            
        }

        return Math.max(maxOfNegatives + 1, nums.length - minOfPositives);
    }
}