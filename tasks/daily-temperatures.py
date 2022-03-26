class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = list(temperatures)
        stack = []
        for current_index in range(len(temperatures)):
            current_temp = temperatures[current_index]
            while stack and temperatures[stack[-1]] < current_temp:
                last_stack_index = stack.pop()
                result[last_stack_index] = current_index - last_stack_index
            stack.append(current_index)

        while stack:
            last_stack_index = stack.pop()
            result[last_stack_index] = 0
        return result