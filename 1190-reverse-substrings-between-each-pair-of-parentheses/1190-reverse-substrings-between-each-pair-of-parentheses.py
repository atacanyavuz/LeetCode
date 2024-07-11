def calculateString(mainString, i):
    result = ""
    while i < len(mainString):
        if mainString[i] == "(":
            inParanthesis, endIndex = calculateString(mainString, i + 1)
            result += inParanthesis
            i = endIndex
        elif mainString[i] == ")":
            return result[::-1], i
        else:
            result += mainString[i]
        i += 1
    return result, len(mainString)


class Solution:
    def reverseParentheses(self, s: str) -> str:
        return calculateString(s, 0)[0]
