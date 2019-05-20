import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrixSize[0]; i++) {
            String[] data = scanner.nextLine().split(" ");
            matrix[i] = data;
        }
        String loopRotate = "";
        while (!"END".equals(loopRotate = scanner.nextLine())){
            String[] data = loopRotate.split(" ");
            if (data.length!=5){
                System.out.println("Invalid input!");
                continue;
            }
            int firstOne = Integer.parseInt(data[1]);
            int firstTwo = Integer.parseInt(data[2]);
            int secondOne = Integer.parseInt(data[3]);
            int secondTwo = Integer.parseInt(data[4]);
            try {
                String save = matrix[firstOne][firstTwo];
                matrix[firstOne][firstTwo] = matrix[secondOne][secondTwo];
                matrix[secondOne][secondTwo] = save;
                System.out.println(Arrays.deepToString(matrix).replaceAll("], ","\n").replaceAll("\\[|\\]|,",""));
            }
            catch (Exception e){
                System.out.println("Invalid input!");
            }
        }

    }
}
