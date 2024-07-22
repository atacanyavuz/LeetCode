class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        return [p[0] for p in sorted(zip(names, heights), key=lambda person: -person[1])]