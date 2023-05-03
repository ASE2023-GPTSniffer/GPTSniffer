import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        
        String maxName = "";
        double maxScore = Double.MIN_VALUE;
        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter student " + i + "'s name: ");
            String name = input.next();
            System.out.print("Enter " + name + "'s score: ");
            double score = input.nextDouble();
            
            if (score > maxScore) {
                maxName = name;
                maxScore = score;
            }
        }
        
        System.out.println("The student with the highest score is: " + maxName);
    }
}