package ransom_note;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count = 26;
        int offset = 'a';
        int[] chars = new int[count];
        for (char c : magazine.toCharArray()) {
            chars[c - offset]++;
        }

        for (char c : ransomNote.toCharArray()) {
            int charNumber = (int) c - offset;
            chars[charNumber]--;
            if (chars[charNumber] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(!new Solution().canConstruct("a", "b"));
        System.out.println(!new Solution().canConstruct("aa", "ab"));
        System.out.println(new Solution().canConstruct("aa", "aab"));
        System.out.println(new Solution().canConstruct("aaz", "aabz"));
    }
}
