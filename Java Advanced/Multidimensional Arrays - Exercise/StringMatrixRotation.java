import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = new ArrayList<>();
        String rotation = scanner.nextLine();
        System.out.println();
        int rotationNum = Integer.parseInt(rotation.substring(7, rotation.length() - 1));
        String input = "";
        int max = 0;
        while (!"END".equals(input = scanner.nextLine())) {
            data.add(input);
            if (input.length() > max)
                max = input.length();
        }
        String[][] matrix = new String[data.size()][max];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (data.get(i).length() > j) {
                    char symbol = data.get(i).charAt(j);
                    matrix[i][j] = symbol + "";
                } else
                    matrix[i][j] = " ";

            }
        }
        matrixRotation(rotationNum, matrix, max);
    }


    private static void matrixRotation(int rotation, String[][] matrix, int l) {
        if (rotation == 0 ||rotation % 360 == 0)
            System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("\\[|\\]|, ", ""));
        else if (rotation== 270 ||rotation % 360 == 270) {
            for (int row = l - 1; row >= 0; row--) {
                for (int col = 0; col < matrix.length; col++) {
                    System.out.print(matrix[col][row]);
                }
                System.out.println();
            }

        }
        else if (rotation == 180 || rotation % 360 == 180) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = l - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
        else if (rotation == 90|| rotation % 360 == 90) {
            for (int row = 0; row < l; row++) {
                for (int col = matrix.length - 1; col >= 0; col--) {
                    System.out.print(matrix[col][row]);
                }
                System.out.println();
            }
        }
    }
}
