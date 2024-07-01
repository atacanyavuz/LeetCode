def isOdd(x):
    return x % 2


class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        for i in range(len(arr) - 2):
            if isOdd(arr[i]) and isOdd(arr[i + 1]) and isOdd(arr[i + 2]):
                return True
        return False
