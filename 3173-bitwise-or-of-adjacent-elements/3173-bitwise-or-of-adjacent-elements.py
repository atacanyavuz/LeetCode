class Solution:
    def orArray(self, nums: List[int]) -> List[int]:
        res = [0] * (len(nums) - 1)
        for i in range(len(nums) - 1):
            res[i] = (nums[i] | nums[i + 1])
        return res