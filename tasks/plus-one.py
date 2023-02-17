from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        reverse = list(reversed(digits))
        current_to_add = 1
        for i in range(0, len(digits)):
            if current_to_add == 0:
                break
            x = reverse[i]
            if x == 9:
                x = 0
            else:
                x = x + 1
                current_to_add = 0
            reverse[i] = x

        if current_to_add != 0:
            reverse.append(1)
        return list(reversed(reverse))


a = Solution()
print(a.plusOne([9, 9, 9]))
print(a.plusOne([1, 2, 3]))
