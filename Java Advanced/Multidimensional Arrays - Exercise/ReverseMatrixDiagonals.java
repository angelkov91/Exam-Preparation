import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int row = matrixSize[0] - 1;
        int col = matrixSize[1] - 1;

        while (row >= 0){

            int r = row;
            int c = col;

            while (c < matrixSize[1] && r >= 0){
                System.out.print(matrix[r--][c++]+" ");
            }
            System.out.println();
            col --;
            if (col==-1){
                col = 0;
                row--;
            }

        }

    }
}
