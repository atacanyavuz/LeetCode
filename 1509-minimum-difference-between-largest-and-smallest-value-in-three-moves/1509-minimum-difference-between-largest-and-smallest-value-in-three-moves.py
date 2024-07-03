def qsort(inlist):
    if inlist == []: 
        return []
    else:
        pivot = inlist[0]
        lesser = qsort([x for x in inlist[1:] if x < pivot])
        greater = qsort([x for x in inlist[1:] if x >= pivot])
        return lesser + [pivot] + greater

class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0

        nums = qsort(nums)
        possibleDiff = [
            nums[-1] - nums[3],
            nums[-2] - nums[2],
            nums[-3] - nums[1],
            nums[-4] - nums[0],
        ]
        return min(possibleDiff)
