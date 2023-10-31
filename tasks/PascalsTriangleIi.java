import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(1));
    }
}


class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] prevStep = new int[]{1};

        int[] currentStep = new int[]{1};
        for (int i = 1; i <= rowIndex; i++) {
            currentStep = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                int x = 0;
                if (j - 1 >= 0) {
                    x += prevStep[j - 1];
                }
                if (j < i) {
                    x += prevStep[j];
                }
                currentStep[j] = x;
            }
            prevStep = currentStep;
        }
        return List.of(Arrays.stream(currentStep)
                .boxed()
                .toArray(Integer[]::new));
    }
}