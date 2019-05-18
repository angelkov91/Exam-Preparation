import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize = Integer.parseInt(scanner.nextLine());
        int celSize = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rowSize][celSize];
        char[][] secondMatrix = new char[rowSize][celSize];
        for (int row = 0; row < firstMatrix.length; row++) {
            List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            for (int cel = 0; cel < firstMatrix[row].length; cel++) {
                firstMatrix[row][cel] = data.get(cel).charAt(0);
            }
        }
        for (int row = 0; row < secondMatrix.length; row++) {
            List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            for (int cel = 0; cel < secondMatrix[row].length; cel++) {
                   secondMatrix[row][cel]  = data.get(cel).charAt(0);
                   if (secondMatrix[row][cel]==(firstMatrix[row][cel]))
                       System.out.print(secondMatrix[row][cel]+" ");
                   else
                       System.out.print("* ");
            }
            System.out.println();
        }
    }
}
