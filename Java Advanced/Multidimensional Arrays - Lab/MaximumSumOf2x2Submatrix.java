import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        int[][] submatrix = new int[2][2];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = data[col];
            }
        }
        for (int row = 0; row < matrix.length - 1; row++) {
            int sumTwo = 0;
            for (int col = 0; col < matrix[row].length - 1; col++) {
                sumTwo = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sumTwo > sum) {
                    sum = sumTwo;
                    submatrix[0][0] = matrix[row][col];
                    submatrix[0][1] = matrix[row][col + 1];
                    submatrix[1][0] = matrix[row + 1][col];
                    submatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int[] print : submatrix) {
            System.out.println(Arrays.toString(print).replaceAll("\\[|\\]|,", ""));
        }
        System.out.println(sum);
    }
}
