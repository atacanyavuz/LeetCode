class Solution:
    def minOperations(self, logs: List[str]) -> int:
        depth = 0
        for op in logs:
            if op == "../":
                depth -= 1 if depth > 0 else 0
            elif op != "./":
                depth += 1

        return depth
