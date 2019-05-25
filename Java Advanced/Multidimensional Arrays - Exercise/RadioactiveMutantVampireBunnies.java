import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[size[0]][size[1]];
        int peopleRow = 0;
        int peopleCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    peopleRow = row;
                    peopleCol = col;
                }
            }
        }
        String directions = scanner.nextLine();
        boolean isLive = false;
        boolean dead = false;
        for (int i = 0; i < directions.length(); i++) {
            ArrayDeque<Integer> bunniesPosition = new ArrayDeque<>();
            char dir = directions.charAt(i);
            switch (dir) {
                case 'L':
                    if (isInBounds(matrix, peopleRow, peopleCol - 1)) {
                        if (matrix[peopleRow][peopleCol - 1].equals(".")) {
                            matrix[peopleRow][peopleCol] = ".";
                            matrix[peopleRow][peopleCol - 1] = "P";
                            peopleCol--;
                        } else {
                            peopleCol--;
                            dead = true;
                        }
                    } else {
                        matrix[peopleRow][peopleCol] = ".";
                        isLive = true;
                        break;
                    }
                    break;
                case 'R':
                    if (isInBounds(matrix, peopleRow, peopleCol + 1)) {
                        if (matrix[peopleRow][peopleCol + 1].equals(".")) {
                            matrix[peopleRow][peopleCol] = ".";
                            matrix[peopleRow][peopleCol + 1] = "P";
                            peopleCol++;
                        } else {
                            peopleCol++;
                            dead = true;
                        }
                    } else {
                        matrix[peopleRow][peopleCol] = ".";
                        isLive = true;
                        break;
                    }
                    break;
                case 'U':
                    if (isInBounds(matrix, peopleRow - 1, peopleCol)) {
                        if (matrix[peopleRow - 1][peopleCol].equals(".")) {
                            matrix[peopleRow][peopleCol] = ".";
                            matrix[peopleRow - 1][peopleCol] = "P";
                            peopleRow--;
                        } else {
                            peopleRow--;
                            dead = true;
                        }
                    } else {
                        matrix[peopleRow][peopleCol] = ".";
                        isLive = true;
                        break;
                    }
                    break;
                case 'D':
                    if (isInBounds(matrix, peopleRow + 1, peopleCol)) {
                        if (matrix[peopleRow + 1][peopleCol].equals(".")) {
                            matrix[peopleRow][peopleCol] = ".";
                            matrix[peopleRow + 1][peopleCol] = "P";
                            peopleRow++;
                        } else {
                            peopleRow++;
                            dead = true;
                        }
                    } else {
                        matrix[peopleRow][peopleCol] = ".";
                        isLive = true;
                        break;
                    }
                    break;
            }

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col].equals("B")) {
                        bunniesPosition.push(row);
                        bunniesPosition.push(col);
                    }
                }
            }
            while (bunniesPosition.size() > 0) {
                int bunnyCol = bunniesPosition.pop();
                int bunnyRow = bunniesPosition.pop();
                if (isInBounds(matrix, bunnyRow + 1, bunnyCol)) {
                    if (!matrix[bunnyRow + 1][bunnyCol].equals("P"))
                        matrix[bunnyRow + 1][bunnyCol] = "B";
                    else {
                        matrix[bunnyRow + 1][bunnyCol] = "B";
                        dead = true;
                    }
                }
                if (isInBounds(matrix, bunnyRow - 1, bunnyCol)) {
                    if (!matrix[bunnyRow - 1][bunnyCol].equals("P"))
                        matrix[bunnyRow - 1][bunnyCol] = "B";
                    else {
                        matrix[bunnyRow - 1][bunnyCol] = "B";
                        dead = true;
                    }
                }
                if (isInBounds(matrix, bunnyRow, bunnyCol + 1)) {
                    if (!matrix[bunnyRow][bunnyCol + 1].equals("P"))
                        matrix[bunnyRow][bunnyCol + 1] = "B";
                    else {
                        matrix[bunnyRow][bunnyCol + 1] = "B";
                        dead = true;
                    }
                }
                if (isInBounds(matrix, bunnyRow, bunnyCol - 1)) {
                    if (!matrix[bunnyRow][bunnyCol - 1].equals("P"))
                        matrix[bunnyRow][bunnyCol - 1] = "B";
                    else {
                        matrix[bunnyRow][bunnyCol - 1] = "B";
                        dead = true;

                    }
                }
            }
            if (dead)
                break;
        }

        if (isLive) {
            System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("\\[|\\]|,| ", ""));
            System.out.println(String.format("won: %d %d", peopleRow, peopleCol));
        } else {
            System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("\\[|\\]|,| ", ""));
            System.out.println(String.format("dead: %d %d", peopleRow, peopleCol));
        }

    }
    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 &&
                row < matrix.length &&
                col >= 0 &&
                col < matrix[row].length;
    }
}
