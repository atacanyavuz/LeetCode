def findNumberOutParanthesis(formula, index):
    if not formula[index + 1].isdigit():
        return 1, 0
    i = 2
    while len(formula) > index + i and formula[index + i].isdigit():
        i += 1
    return int(formula[index + 1: index + i]), i - 1


def dictMultipy(parathesisDict, multiplier):
    for key in parathesisDict.keys():
        parathesisDict[key] *= multiplier
    return parathesisDict


def dictSum(dictA, dictB):
    for key in dictB.keys():
        if key in dictA.keys():
            dictA[key] += dictB[key]
        else:
            dictA[key] = dictB[key]
    return dictA


def calculateParanthesis(formula, index):
    parathesisResult = dict()
    while index < len(formula):
        if formula[index] == "(":
            inParanthesisResult, index = calculateParanthesis(formula, index + 1)
            parathesisResult = dictSum(parathesisResult, inParanthesisResult)
        elif formula[index] == ")":
            multiplier = 1
            numDigit = 0
            if index < len(formula) - 1:
                multiplier, numDigit = findNumberOutParanthesis(formula, index)
            parathesisResult = dictMultipy(parathesisResult, multiplier)
            return parathesisResult, index + numDigit + 1
        else:
            element, count, index = findElement(formula, index)
            addElementToDict(element, count, parathesisResult)
    return parathesisResult


def findElement(formula, index):
    if index == len(formula) - 1:
        return formula[index], 1, index + 1
    if formula[index + 1].isdigit():
        i = 2
        while len(formula) > index + i and formula[index + i].isdigit():
            i += 1
        return formula[index], int(formula[index + 1:index + i]), index + i
    elif formula[index + 1].islower():
        if not formula[index + 2].isdigit():
            return formula[index: index + 2], 1, index + 2
        i = 3
        while len(formula) > index + i and formula[index + i].isdigit():
            i += 1
        return formula[index: index + 2], int(formula[index + 2: index + i]), index + i
    else:
        return formula[index], 1, index + 1


def addElementToDict(element, count, outputDict):
    if element in outputDict:
        outputDict[element] += count
    else:
        outputDict[element] = count


def finalStringBuilder(result):
    output = ""
    sortedList = sorted(result.items(), key=lambda item: item[0])
    for i, j in sortedList:
        output += i
        if j > 1:
            output += str(j)
    return output


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        result = calculateParanthesis(formula, 0)
        return finalStringBuilder(result)
