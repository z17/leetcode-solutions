class Solution:
    INT_TO_ROMAN = {
        1000: 'M',
        500: 'D',
        100: 'C',  # !
        50: 'L',
        10: 'X',  # !
        5: 'V',
        1: 'I'  # !
    }

    ROMAN_SORTED_NUMBERS = [1000, 500, 100, 50, 10, 5, 1]
    ROMAN_SUBTRACT_MAP = {
        1000: 100,
        500: 100,
        100: 10,
        50: 10,
        10: 1,
        5: 1,
    }

    # num: 1 - 3999
    def intToRoman(self, num: int) -> str:
        result = ''
        current_num = num
        prev_roman_number = None

        for i in range(len(self.ROMAN_SORTED_NUMBERS)):
            if prev_roman_number and prev_roman_number in self.ROMAN_SUBTRACT_MAP:
                if (current_num + self.ROMAN_SUBTRACT_MAP[prev_roman_number]) // prev_roman_number > 0:
                    subtract_number = self.ROMAN_SUBTRACT_MAP[prev_roman_number]
                    result += self.INT_TO_ROMAN[subtract_number] + self.INT_TO_ROMAN[prev_roman_number]
                    current_num -= (prev_roman_number - subtract_number)

            current_roman_number = self.ROMAN_SORTED_NUMBERS[i]
            current_symbol_count = current_num // current_roman_number
            if current_symbol_count > 0:
                result += current_symbol_count * self.INT_TO_ROMAN[current_roman_number]
                current_num -= current_roman_number * current_symbol_count

            prev_roman_number = current_roman_number

        print(num, '=>', result)

        return result


print(Solution().intToRoman(10) == 'X')
print(Solution().intToRoman(11) == 'XI')
print(Solution().intToRoman(15) == 'XV')
print(Solution().intToRoman(19) == 'XIX')
