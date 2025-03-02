class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1); 
            }
            else{
                countMap.put(nums[i], 1); 
            }
        }
        for (int i : countMap.keySet()) {
            if (countMap.get(i) > nums.length / 2) {
                return i;
            }
        }
        return 0;
    }
}