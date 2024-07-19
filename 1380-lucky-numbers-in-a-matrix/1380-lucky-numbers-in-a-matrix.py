def isMinInRow(i, j, matrix):
    for index in range(len(matrix[0])):
        if index == j:
            continue
        if matrix[i][index] < matrix[i][j]:
            return False
    return True


def isMaxInColumn(i, j, matrix):
    for index in range(len(matrix)):
        if index == i:
            continue
        if matrix[index][j] > matrix[i][j]:
            return False
    return True


def checkLucky(i, j, matrix):
    return isMaxInColumn(i, j, matrix) and isMinInRow(i, j, matrix)


class Solution:
    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        result = list()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if checkLucky(i, j, matrix):
                    result.append(matrix[i][j])
        return result
