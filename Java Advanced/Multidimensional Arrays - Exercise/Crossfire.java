import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = size[0] * size[1];
        ArrayList<ArrayList<Integer>> matrix = generateMatrix(size[0], size[1]);
        String input = "";
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int coordinatesOne = data[0];
            int coordinatesTwo = data[1];
            int radiusExplosion = data[2];
            int saveRad = radiusExplosion*2+1;
            while (saveRad-- > 0) {
                try {

                    matrix.get(coordinatesOne).set(coordinatesTwo-radiusExplosion+saveRad, 0);
                } catch (Exception ignored) {
                }
            }
            saveRad = radiusExplosion*2+1;
            while (saveRad-- > 0) {
                try {

                    matrix.get(coordinatesOne - radiusExplosion+saveRad).set(coordinatesTwo, 0);
                } catch (Exception ignored) {
                }
            }
            for (int r = 0; r < matrix.size(); r++) {
                for (int c = matrix.get(r).size()-1; c >= 0; c--) {
                    if (matrix.get(r).get(c) == 0)
                        matrix.get(r).remove(c);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix.toArray()).replace("], ","\n").replaceAll("\\[|\\]|,",""));
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
