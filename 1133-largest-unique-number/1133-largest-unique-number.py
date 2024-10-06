class Solution:
    def checkUnique(self, nums, index):
        print(index)
        if index + 1 < len(nums):
            if nums[index] == nums[index + 1]:
                return False
        if index - 1 >= 0:
            if nums[index] == nums[index - 1]:
                return False
        return True

    def largestUniqueNumber(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        nums = sorted(nums)
        for i in range(len(nums) - 1, -1, -1):
            if self.checkUnique(nums, i):
                return nums[i]
        return -1
