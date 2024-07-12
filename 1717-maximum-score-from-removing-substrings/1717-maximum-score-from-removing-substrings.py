class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        highString = ""
        highScore = 0
        lowString = ""
        lowScore = 0

        result = 0

        if x > y:
            highString = "ab"
            highScore = x
            lowString = "ba"
            lowScore = y
        else:
            highString = "ba"
            highScore = y
            lowString = "ab"
            lowScore = x

        stringWithoutHigh = ["x"]
        stringWithoutLow = ["x"]
        for element in s:
            if element == highString[1] and stringWithoutHigh[-1] == highString[0]:
                result += highScore
                stringWithoutHigh.pop()
            else:
                stringWithoutHigh.append(element)
        for element in stringWithoutHigh:
            if element == lowString[1] and stringWithoutLow[-1] == lowString[0]:
                result += lowScore
                stringWithoutLow.pop()
            else:
                stringWithoutLow.append(element)
        return result
