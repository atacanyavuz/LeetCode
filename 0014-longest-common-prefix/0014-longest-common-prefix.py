class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1:
            return strs[0]
        maxPrefixLen = min([len(x) for x in strs])
        commonPrefix = ""
        for i in range(maxPrefixLen):
            for j in range(len(strs) - 1):
                if strs[j][i] != strs[j + 1][i]:
                    break
            else:  # For loop: Without break
                commonPrefix = commonPrefix + strs[0][i]
                continue
            break

        return commonPrefix
