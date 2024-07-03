class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0

        nums.sort()
        startingDiff = [nums[1] - nums[0], nums[2] - nums[1], nums[3] - nums[2]]
        endingDiff = [nums[-1] - nums[-2], nums[-2] - nums[-3], nums[-3] - nums[-4]]

        changePlan = [
            sum(startingDiff),
            startingDiff[0] + startingDiff[1] + endingDiff[0],
            startingDiff[0] + endingDiff[0] + endingDiff[1],
            sum(endingDiff),
        ]
        plan = changePlan.index(max(changePlan))

        if plan == 0:
            return nums[-1] - nums[3]
        elif plan == 1:
            return nums[-2] - nums[2]
        elif plan == 2:
            return nums[-3] - nums[1]
        elif plan == 3:
            return nums[-4] - nums[0]
