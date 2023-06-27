from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = {}
        for x in nums:
            if x not in counter:
                counter[x] = 1
            else:
                counter[x] += 1

        min_count = 0
        min_index = 0
        top_list = []
        for val, count in counter.items():
            if len(top_list) < k:
                if min_count > count or min_count == 0:
                    min_count = count
                    min_index = len(top_list)
                top_list.append((val, count, len(top_list)))
            else:
                if count > min_count:
                    top_list[min_index] = (val, count, min_index)
                    _, min_count, min_index, = min(top_list, key=lambda q: q[1])
        result = []
        for val, _, _ in top_list:
            result.append(val)
        return result


s = Solution()
print(s.topKFrequent([4, 1, -1, 2, -1, 2, 3], 2))
