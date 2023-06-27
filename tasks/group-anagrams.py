from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagramsStorage = {}
        for s in strs:
            sortedS = ''.join(sorted(s))
            if sortedS not in anagramsStorage:
                anagramsStorage[sortedS] = []

            anagramsStorage[sortedS].append(s)
        result = []
        for key in anagramsStorage:
            result.append(anagramsStorage[key])
        return result


s = Solution()
print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
