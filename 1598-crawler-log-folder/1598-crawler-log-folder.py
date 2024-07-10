class Solution:
    def minOperations(self, logs: List[str]) -> int:
        depth = 0
        for op in logs:
            if op == "../":
                if depth > 0:
                    depth -= 1
            elif op != "./":
                depth += 1

        return depth
