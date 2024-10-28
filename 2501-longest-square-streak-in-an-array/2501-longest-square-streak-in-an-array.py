class Solution:
    def addCounterInDict(self, x, addNum=1):
        if x in self.counterDict.keys():
            self.counterDict[x] += addNum
        else:
            self.counterDict[x] = addNum

    def longestSquareStreak(self, nums: List[int]) -> int:
        nums = sorted(set(nums))
        self.counterDict = {}
        longest = 0

        for x in nums:
            self.addCounterInDict(x)
            if x**2 in nums:
                self.addCounterInDict(x**2, self.counterDict[x])
            if longest < self.counterDict[x]:
                longest = self.counterDict[x]

        if longest > 1:
            return longest
        else:
            return -1
