package convert_a_number_to_hexadecimal;

public class Solution {
    private static final String[] HEX_VALUES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public String toHex(int initNumber) {
        if (initNumber == Integer.MIN_VALUE) {
            return "80000000";
        }
        int num;
        if (initNumber < 0) {
            num = Integer.MAX_VALUE + initNumber + 1;
        } else {
            num = initNumber;
        }
        StringBuilder result = new StringBuilder();
        do {
            int number = num % 16;
            result.append(HEX_VALUES[number]);
            num /= 16;
        } while (num > 0);

        if (initNumber < 0) {
            while (result.length() < 7) {
                result.append('0');
            }
            int topNibble = (initNumber >>> 28);
            result.replace(7, 8, HEX_VALUES[topNibble]);
        }
        return result.reverse().toString();
    }

    private static void check(int number)  {
        String expectedHex = Integer.toHexString(number);
        String actualHex = new Solution().toHex(number);
        System.out.println(expectedHex.equals(actualHex) + " " + number + " " + expectedHex + " " + actualHex);
    }

    public static void main(String[] args) {
        check(0);
        check(1);
        check(26);
        check(31);
        check(32);
        check(256);
        check(2147483647);
        check(-2147483647);
        check(-2147483646);
        check(-214748366);
        check(-1);
        check(-2);
        check(-50);
        check(-2147483648);
    }
}
