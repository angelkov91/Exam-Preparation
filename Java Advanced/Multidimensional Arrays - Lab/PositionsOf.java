import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[data[0]][data[1]];
        for (int row = 0; row < matrix.length; row++) {
            data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int cel = 0; cel < matrix[row].length; cel++) {
                matrix[row][cel] = data[cel];
            }
        }
        boolean isFound = false;
        int searchedNumber = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < matrix.length; row++) {
            for (int cel = 0; cel < matrix[row].length; cel++) {
                if (matrix[row][cel] == searchedNumber){
                    System.out.println(row+" "+cel);
                    isFound = true;
                }
            }
        }
        if (!isFound)
            System.out.println("not found");

    }
}
