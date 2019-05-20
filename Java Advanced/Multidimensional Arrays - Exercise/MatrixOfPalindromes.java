import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (char)(97+row)+""+(char)('a'+row+col)+""+(char)('a'+row);
            }
        }
        System.out.println(Arrays.deepToString(matrix).replaceAll("], ","\n").replaceAll("\\[|\\]|,",""));
    }
}
