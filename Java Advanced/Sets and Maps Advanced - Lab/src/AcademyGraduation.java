import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        Map<String,Double> studentGrade = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double[] allGrades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double grade = generateGrade(allGrades);
            studentGrade.put(name,grade);
        }
        studentGrade.forEach((student,grade) ->{
            System.out.print(String.format("%s is graduated with ",student));
            System.out.print(new DecimalFormat("#.###############").format(grade));
            System.out.println();
        });
    }
    private static double generateGrade(double[] allGrades){
        double avrGrade = 0;
        for (int i = 0; i < allGrades.length; i++) {
            avrGrade+=allGrades[i];
        }
        avrGrade/=allGrades.length;
        return avrGrade;

    }
}
