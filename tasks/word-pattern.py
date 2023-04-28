# chatgpt testing


class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(pattern) != len(words):
            return False

        pattern_to_words = {}
        for i in range(len(pattern)):
            char = pattern[i]
            word = words[i]
            if char not in pattern_to_words:
                if word not in pattern_to_words.values():
                    pattern_to_words[char] = word
                else:
                    return False
            else:
                if pattern_to_words[char] != word:
                    return False

        return True


print(Solution().wordPattern("abba", "dog dog dog dog"))
print(Solution().wordPattern("abba", "dog cat cat dog"))
print(Solution().wordPattern("abba", "dog cat cat dfog"))
