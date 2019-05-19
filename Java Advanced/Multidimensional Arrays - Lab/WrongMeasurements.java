import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeRows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeRows][];
        for (int i = 0; i < matrix.length; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = data;
        }
        int[] wrongValue = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = wrongValue[0];
        int col = wrongValue[1];
        int searchedNum = matrix[row][col];
        int[][] finalMatrix = newMatrix(matrix,searchedNum,sizeRows);
        for (int i = 0; i < finalMatrix.length; i++) {
            System.out.println(Arrays.toString(finalMatrix[i]).replaceAll("\\[|\\]|,",""));
        }
    }
    private static int[][] newMatrix (int[][] matrixW, int searchedNum, int size){
        int[][] newMatrix = new int[size][];
        List<Integer> data = new ArrayList<>();
        int rightValue = 0;


        for (int i = 0; i < matrixW.length; i++) {
            for (int j = 0; j < matrixW[i].length; j++) {

                if (matrixW[i][j] == searchedNum){
                    if (i-1 >=0 && i-1< matrixW.length && j<matrixW[i].length && matrixW[i-1][j]!=searchedNum)
                        rightValue+=matrixW[i-1][j];
                    if (i+1< matrixW.length && j<matrixW[i].length && matrixW[i+1][j]!=searchedNum)
                        rightValue+=matrixW[i+1][j];
                    if (j-1>=0 && j-1<matrixW[i].length && matrixW[i][j-1]!=searchedNum)
                        rightValue+=matrixW[i][j-1];
                    if (j+1<matrixW[i].length && matrixW[i][j+1]!=searchedNum)
                        rightValue+=matrixW[i][j+1];
                    data.add(rightValue);
                }
                else
                    data.add(matrixW[i][j]);
                rightValue = 0 ;
            }
            int[] toMatrix = data.stream().mapToInt(e->e).toArray();
            newMatrix[i] = toMatrix;
            data = new ArrayList<>();
        }
        return newMatrix;
    }


}
