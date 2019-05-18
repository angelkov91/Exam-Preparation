import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMatrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = new int[firstMatrixData[0]][firstMatrixData[1]];
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < firstMatrix[row].length; col++) {
                firstMatrix[row][col] = input[col];
            }
        }
        int[] secondMatrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (firstMatrixData[0]!=secondMatrixData[0] || firstMatrixData[1]!=secondMatrixData[1]){
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[secondMatrixData[0]][secondMatrixData[1]];
        for (int row = 0; row < secondMatrix.length; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < secondMatrix[row].length; col++) {
                secondMatrix[row][col] = input[col];
            }
        }
        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
