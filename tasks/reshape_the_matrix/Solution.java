package reshape_the_matrix;

class Solution {
    public int[][] matrixReshape(int[][] input, int r, int c) {
        int[][] result = new int[r][c];

        if (input.length * input[0].length != r * c) {
            return input;
        }

        int resultI = 0;
        int resultJ = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++){
                result[resultI][resultJ] = input[i][j];
                resultJ++;
                if (resultJ >= c ) {
                    resultJ = 0;
                    resultI++;
                }
            }
        }
        return result;
    }


    private static void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void check(int[][] mat, int r, int c) {
        int[][] result = new Solution().matrixReshape(mat, r, c);
        print(mat);
        print(result);
        System.out.println("-------");
    }

    public static void main(String[] args) {
        check(
                new int[][]{
                        {1, 2},
                        {3, 4}
                },
                1, 4
        );


        check(
                new int[][]{
                        {1, 2},
                        {3, 4}
                },
                15, 12
        );
    }
}