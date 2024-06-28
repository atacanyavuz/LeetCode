def findElementRow(numRows, i, divider):
    x = i % divider
    underElementIndex = divider // 2
    if x <= underElementIndex:
        return x
    return underElementIndex - x + underElementIndex
    



class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        divider = numRows * 2 - 2
        rows_dict = dict()
        for i in range(numRows):
            rows_dict[i] = list()
        
        for i in range(len(s)):
            index = findElementRow(numRows, i, divider)
            rows_dict[index].append(s[i])
        
        answer = list()
        for i in range(numRows):
            answer.extend(rows_dict[i])
        answer ="".join(answer)
        return answer         
            
        