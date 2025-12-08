package power_of_four;

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        String binaryString = Integer.toBinaryString(n);
        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != '0') {
                return false;
            }
        }

        return (binaryString.length() - 1) % 2 != 1;
    }

    public static void check(int n, boolean expected) {
        boolean result = new Solution().isPowerOfFour(n);
        System.out.println((result == expected) + " " + n);
    }

    public static void main(String[] args) {
        check(1, true);
        check(4, true);
        check(16, true);
        check(256, true);
        check(5, false);
        check(8, false);
        check(234324, false);
    }
}