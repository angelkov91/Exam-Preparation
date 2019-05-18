import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(matrixSize[0]);
        System.out.println(matrixSize[1]);
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];
        int sum = 0;
        for (int row = 0; row < matrixSize[0]; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrixSize[1]; col++) {
                sum+=data[col];

            }
        }
        System.out.println(sum);
    }
}
