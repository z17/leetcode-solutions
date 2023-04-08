class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        last_space = s.rfind(' ')
        return len(s) - last_space - 1


print(Solution().lengthOfLastWord('one last world'))
print(Solution().lengthOfLastWord('double space  here'))
print(Solution().lengthOfLastWord('nothing'))
print(Solution().lengthOfLastWord('   fly me   to   the moon  '))

