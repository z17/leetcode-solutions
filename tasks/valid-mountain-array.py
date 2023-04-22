from typing import List


class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        prev_value = arr[0]
        direction = 0
        for i in range(1, len(arr)):
            diff = arr[i] - prev_value
            if direction == 0:
                if diff > 0:
                    direction = 1
                else:
                    return False

            if direction > 0 and diff < 0:
                direction = -1

            if diff == 0:
                return False

            if direction < 0 and diff > 0:
                return False

            prev_value = arr[i]

        return direction < 0


print(Solution().validMountainArray([0, 1, 2, 3, 2]))
print(Solution().validMountainArray([0, 1, 1, 2, 3, 2]))
print(Solution().validMountainArray([0, 1, 2, 3, 3, 2]))
print(Solution().validMountainArray([5, 3, 1]))
print(Solution().validMountainArray([2, 1, 2, 3, 5, 7, 9, 10, 12, 14, 15, 16, 18, 14, 13]))
