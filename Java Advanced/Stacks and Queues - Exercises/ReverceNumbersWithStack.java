import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverceNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> nums = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split(" ")).forEach(nums::push);
        for (String num : nums) {
            System.out.print(num+" ");
        }
    }
}
