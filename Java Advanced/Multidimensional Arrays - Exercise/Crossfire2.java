import java.util.*;
import java.util.stream.Collectors;

public class Crossfire2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = size[0] * size[1];
        ArrayList<ArrayList<Integer>> matrix = generateMatrix(size[0], size[1]);
        String input = "";
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = data[0];
            int col = data[1];
            int radius = data[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInBounds(matrix, r, col))
                    matrix.get(r).set(col, 0);

            }
            for (int c = col - radius; c <= col + radius; c++) {
                if (isInBounds(matrix, row, c))
                    matrix.get(row).set(c, 0);

            }
            for (int i = 0; i < matrix.size(); i++) {
                matrix.set(i, matrix.get(i).stream()
                        .filter(e -> e != 0).collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;

                }
            }
        }

        System.out.println(Arrays.deepToString(matrix.toArray()).replace("], ", "\n").replaceAll("\\[|\\]|,", ""));
    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {


        return row >= 0 &&
                row < matrix.size() &&
                col >= 0 &&
                col < matrix.get(row).size();
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(int row, int col) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int i1 = 0; i1 < col; i1++) {
                rowList.add(value);
                value++;
            }
            matrix.add(rowList);
        }
        return matrix;
    }
}
