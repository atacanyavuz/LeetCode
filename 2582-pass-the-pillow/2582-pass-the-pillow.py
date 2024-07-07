class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        time = time % ((n * 2) - 2)
        if time > n - 1:
            return (n - 1) - time + n
        else:
            return time + 1
