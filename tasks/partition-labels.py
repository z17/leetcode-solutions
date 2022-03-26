from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_positions = {}
        l = len(s)
        for i in range(l):
            char = s[i]
            if char not in last_positions:
                last_positions[char] = i
            else:
                last_positions[char] = i

        first_part_char_index = 0
        parts = []
        while first_part_char_index < l:
            last_index = last_positions[s[first_part_char_index]]
            if first_part_char_index == last_index:
                parts.append(1)
                first_part_char_index = last_index + 1
                continue

            new_last_index = last_index
            flag = True
            loop_start = first_part_char_index
            while last_index != new_last_index or flag:
                flag = False
                last_index = new_last_index
                for i in range(loop_start, last_index):
                    new_last_index = max(new_last_index, last_positions[s[i]])
                if last_index != new_last_index:
                    loop_start = last_index
            parts.append(new_last_index - first_part_char_index + 1)
            first_part_char_index = new_last_index + 1
        return parts
