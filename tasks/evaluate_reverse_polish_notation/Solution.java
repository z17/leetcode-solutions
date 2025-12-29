package evaluate_reverse_polish_notation;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    private static final Set<String> OPERATIONS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (OPERATIONS.contains(current)) {
                int b = queue.pollLast();
                int a = queue.pollLast();
                int result = calculate(current, a, b);
                queue.add(result);
            } else {
                queue.add(Integer.parseInt(current));
            }
        }
        return queue.poll();
    }

    private int calculate(String operation, int a, int b) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    private static void test(String[] tokens, int expected) {
        int result = new Solution().evalRPN(tokens);
        System.out.printf("result: %s, tokens: %s, expected: %s, actual: $%s%n", result == expected, Arrays.toString(tokens), expected, result);

    }

    public static void main(String[] args) {
        test(new String[]{"2"}, 2);
        test(new String[]{"2", "2", "+"}, 4);
        test(new String[]{"2", "1", "+", "3", "*"}, 9);
        test(new String[]{"4", "13", "5", "/", "+"}, 6);
    }
}
