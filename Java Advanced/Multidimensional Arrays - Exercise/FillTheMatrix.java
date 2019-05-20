import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(", ");
        int size = Integer.parseInt(data[0]);
        String type = data[1];
        if (type.equals("A"))
            typeA(size);
        else {
            typeB(size);
        }

    }

    private static void typeA(int size) {
        int[][] matrixA = new int[size][size];

        int rows = 1;
        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < matrixA[row].length; col++) {
                matrixA[col][row] = rows;
                rows++;
            }
        }
        System.out.println(Arrays.deepToString(matrixA).replace("], ", "\n")
                .replaceAll("\\[|\\]|,", ""));
    }

    private static void typeB(int size) {
        int[][] matrixA = new int[size][size];

        int rows = 1;
        for (int row = 0; row < matrixA.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrixA[row].length; col++) {
                    matrixA[col][row] = rows;
                    rows++;
                }
            } else if (row % 2 == 1) {
                for (int col = matrixA[row].length - 1; col >= 0; col--) {
                    matrixA[col][row] = rows;
                    rows++;
                }
            }

        }
        System.out.println(Arrays.deepToString(matrixA).replace("], ", "\n")
                .replaceAll("\\[|\\]|,", ""));
    }


}
