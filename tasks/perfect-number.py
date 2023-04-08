import math


class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False
        perfect_sum = 1
        i = 2
        while i <= math.sqrt(num):
            if num % i == 0:
                perfect_sum += i + (num / i)
            i += 1

        return perfect_sum == num


print(Solution().checkPerfectNumber(1))
print(Solution().checkPerfectNumber(7))
print(Solution().checkPerfectNumber(28))
print(Solution().checkPerfectNumber(99999993))
