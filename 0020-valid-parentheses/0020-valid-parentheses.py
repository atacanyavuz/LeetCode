closeParanthesis = {
    "[": "]",
    "(": ")",
    "{": "}",
}

class Solution:
    def isValid(self, s: str) -> bool:
        stack = list()
        for item in s:
            if item in closeParanthesis.keys():
                stack.append(item)
            else:
                if len(stack) == 0 or not closeParanthesis[stack.pop()] == item:
                    return False

        if len(stack) == 0:
            return True
        else:
            return False
