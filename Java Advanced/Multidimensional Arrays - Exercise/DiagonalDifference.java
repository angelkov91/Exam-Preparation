import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        int first = 0 ;
        int second = 0 ;
        for (int i = 0; i < size; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = data;
        }
        for (int i = 0; i < size; i++) {
            first += matrix[i][i];
        }
        for (int i = 0; i < size; i++) {
            second += matrix[size-1-i][i];
        }
        System.out.println(Math.abs(first-second));

    }
}
