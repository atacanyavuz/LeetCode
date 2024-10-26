class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        counter = 0
        while i < len(nums):
            counter += 1
            try:
                while nums[i] == nums[i + 1]:
                    nums.pop(i + 1)
            except IndexError:
                break
            i += 1
        return counter