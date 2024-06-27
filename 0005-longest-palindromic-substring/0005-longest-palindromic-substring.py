# If the length of palindromic string is odd.
def findIfLenOdd(s, index):
    for j in range(1, len(s)):
        if index - j < 0:
            if index + j >= len(s):
                return s[0 : len(s)]
            return s[0 : index + j]
        if index + j == len(s):
            return s[index - j + 1 : len(s)]
        if s[index - j] != s[index + j]:
            return s[index - j + 1 : index + j]


# If the length of palindromic string is even.
def findIfLenEven(s, index):
    if index + 1 == len(s):
        return s[index]
    if s[index] != s[index + 1]:
        return s[index]
    secondIndex = index + 1
    for j in range(1, len(s)):
        if index - j < 0:
            if secondIndex + j >= len(s):
                return s[0 : len(s)]
            return s[0 : secondIndex + j]
        if secondIndex + j == len(s):
            return s[index - j + 1 : len(s)]
        if s[index - j] != s[secondIndex + j]:
            return s[index - j + 1 : secondIndex + j]


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return ""
        elif len(s) == 1:
            return s
        longest_palindromic = ""
        odd_Answer = ""
        even_Answer = ""

        for i in range(len(s)):
            odd_Answer = findIfLenOdd(s, i)
            even_Answer = findIfLenEven(s, i)
            if len(longest_palindromic) < len(odd_Answer):
                longest_palindromic = odd_Answer
            if len(longest_palindromic) < len(even_Answer):
                longest_palindromic = even_Answer

        return longest_palindromic
