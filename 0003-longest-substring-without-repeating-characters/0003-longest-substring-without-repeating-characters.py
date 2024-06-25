class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLen = 0
        substring = ""
        for i in range(len(s)):
            substring = ""
            for j in range(i, len(s)):
                if s[j] in substring:
                    if maxLen < len(substring):
                        maxLen = len(substring)
                    break
                substring = substring + s[j]
        if len(substring) == len(s):
            return len(substring)
        return maxLen
