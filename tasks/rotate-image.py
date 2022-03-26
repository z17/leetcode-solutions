import math
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        middle = math.floor(n / 2)
        for i in range(middle):
            for j in range(i, n - i - 1):
                current_i = i
                current_j = j
                prev_value = matrix[n - current_j - 1][current_i]
                for x in range(4):
                    current = matrix[current_i][current_j]
                    matrix[current_i][current_j] = prev_value
                    prev_value = current
                    old_i = current_i
                    old_j = current_j
                    current_i = old_j
                    current_j = n - old_i - 1

                current_j += 1

    def print(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        for i in range(n):
            for j in range(n):
                print(matrix[i][j], end='\t')
            print()
        print('---')


s = Solution()
s.rotate([[1, 2, 3], [4, 5, 6], [7, 8, 9]])

s.rotate([[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]])
