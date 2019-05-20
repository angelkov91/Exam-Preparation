import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        int[][] bestMatrix = new int[3][3];
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {

                int sumMethod = sumMatrix(matrix, row, col);
                if (sumMethod > sum) {
                    sum = sumMethod;
                    bestMatrix = checkedMatrix(matrix, row, col);
                }

            }
        }
        System.out.println("Sum = " + sum);
        System.out.println(Arrays.deepToString(bestMatrix).replace("], ", "\n").replaceAll("\\[|\\]|,", ""));
    }

    private static int sumMatrix(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row - 1][col - 1];

        return sum;
    }

    private static int[][] checkedMatrix(int[][] matrix, int row, int col) {
        int[][] checkedMatrix = new int[3][3];
        checkedMatrix[0][0] = matrix[row-1][col-1];
        checkedMatrix[0][1] = matrix[row-1][col];
        checkedMatrix[0][2] = matrix[row-1][col+1];
        checkedMatrix[1][0] = matrix[row][col-1];
        checkedMatrix[1][1] = matrix[row][col];
        checkedMatrix[1][2] = matrix[row][col+1];
        checkedMatrix[2][0] = matrix[row+1][col-1];
        checkedMatrix[2][1] = matrix[row+1][col];
        checkedMatrix[2][2] = matrix[row+1][col+1];

        return checkedMatrix;
    }
}

