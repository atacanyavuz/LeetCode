romanNums = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}


class Solution:
    def romanToInt(self, s: str) -> int:
        result = 0
        for i in range(len(s) - 1):
            if romanNums[s[i]] < romanNums[s[i + 1]]:
                result = result - romanNums[s[i]]
            else:
                result = result + romanNums[s[i]]
        result = result + romanNums[s[len(s) - 1]]
        return result
