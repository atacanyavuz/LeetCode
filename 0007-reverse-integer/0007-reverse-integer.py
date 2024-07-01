def isNegative(x):
    return not x == abs(x)

def strToDecimal(x):
    result = 0 
    for i in range(len(x)):
        result += (10**i) * int(x[len(x) - 1 - i]) 
    return result

class Solution:
    def reverse(self, x: int) -> int:
        neg = isNegative(x)
        x = abs(x)
        x = str(x)
        x = x[::-1]
        result = strToDecimal(x) 
        if neg:
            result = result * (-1)
        return result

        