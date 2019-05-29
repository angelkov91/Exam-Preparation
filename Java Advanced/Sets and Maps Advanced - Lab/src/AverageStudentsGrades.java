import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsAndGrades = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);
            if (!studentsAndGrades.containsKey(student)){
                studentsAndGrades.put(student, new ArrayList<>());
                studentsAndGrades.get(student).add(grade);
            }
            else
                studentsAndGrades.get(student).add(grade);
        }
        studentsAndGrades.forEach((student,grade) ->{
            double avgGrade = grade.stream().mapToDouble(e -> e).average().getAsDouble();
            String allGrades = grade.stream().map(e -> String.format("%.2f",e)).collect(Collectors.joining(" "));
            System.out.println(String.format("%s -> %s (avg: %.2f)",student,allGrades,avgGrade));
        });
    }
}
