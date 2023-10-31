import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        System.out.println(new IsomorphicStrings().isIsomorphic("title", "paper"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> aMap = new HashMap<>();
        int aMaxValue = 1;
        Map<Character, Integer> bMap = new HashMap<>();
        int bMaxValue = 1;

        for (int i = 0; i < s.length(); i++) {
            int aVal;
            char aChar = s.charAt(i);
            if (aMap.containsKey(aChar)) {
                aVal = aMap.get(aChar);
            } else {
                aMap.put(aChar, aMaxValue);
                aVal = aMaxValue;
                aMaxValue++;
            }

            int bVal;
            char bChar = t.charAt(i);
            if (bMap.containsKey(bChar)) {
                bVal = bMap.get(bChar);
            } else {
                bMap.put(bChar, bMaxValue);
                bVal = bMaxValue;
                bMaxValue++;
            }

            if (aVal != bVal) {
                return false;
            }
        }

        return true;
    }
}
