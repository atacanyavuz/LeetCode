class Solution:
    def __init__(self):
        self.results = list()
    def generate(self, num_a, num_b, ans):
        if num_a > 0:
            self.generate(num_a - 1, num_b + 1, ans + "(")
        if num_b > 0:
            self.generate(num_a, num_b - 1, ans + ")")
        if num_a == 0 and num_b == 0:
            self.results.append(ans)

    def generateParenthesis(self, n: int) -> List[str]:
        self.generate(n, 0, "")
        return self.results
