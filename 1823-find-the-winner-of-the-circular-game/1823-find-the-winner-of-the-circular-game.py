def findSelected(startingIndex, elementsList, target):
    return (startingIndex + target - 1) % len(elementsList)

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        elementsList = list(range(1, n + 1))
        sIndex = 0
        while len(elementsList) != 1:
            target = findSelected(sIndex, elementsList, k)
            elementsList.pop(target)
            sIndex = target

        return elementsList[0]