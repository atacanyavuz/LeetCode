def sort(l):
    p = 0
    while p < len(l) - 1:
        if l[p] > l[p + 1]:
            l[p], l[p + 1] = l[p + 1], l[p]
            if not (p == 0):
                p = p - 1
        else:
            p += 1
    return l


class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0

        nums = sort(nums)
        possibleDiff = [
            nums[-1] - nums[3],
            nums[-2] - nums[2],
            nums[-3] - nums[1],
            nums[-4] - nums[0],
        ]
        return min(possibleDiff)
