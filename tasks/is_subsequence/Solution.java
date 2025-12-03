package is_subsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int pointer = 0;
        char[] charTArray = t.toCharArray();
        char[] charSArray = s.toCharArray();
        for (char currentTChar : charTArray) {
            if (charSArray[pointer] == currentTChar) {
                pointer++;
            }

            if (pointer == s.length()) {
                return true;
            }
        }

        return false;
    }
    
    public static void check(String s, String t, boolean expected) {
        boolean result = new Solution().isSubsequence(s, t);
        System.out.println((result == expected) + " " + s + " " + t);
    }

    public static void main(String[] args) {
        check("abc", "ahbgdc", true);
        check("axc", "ahbgdc", false);
        check("", "", true);
        check("", "asdad", true);
        check("b", "abc", true);
        check("ba", "abc", false);
        check("ba", "abcsdsadddfgdsfv", true);
    }
}
