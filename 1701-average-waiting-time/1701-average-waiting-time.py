class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        chefTime = 0
        totalWaitTime = 0
        for i, j in customers:
            if chefTime < i:
                chefTime = i
            chefTime = chefTime + j
            totalWaitTime += chefTime - i

        return totalWaitTime / len(customers)
