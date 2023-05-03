
public class GradeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a letter grade (A, B, C, D, or F): ");
        String letterGrade = input.next();

        double numericGrade;

        switch (letterGrade) {
            case "A":
                numericGrade = 4.0;
                break;
            case "B":
                numericGrade = 3.0;
                break;
            case "C":
                numericGrade = 2.0;
                break;
            case "D":
                numericGrade = 1.0;
                break;
            case "F":
                numericGrade = 0.0;
                break;
            default:
                System.out.println("Invalid grade");
                return;
        }

        System.out.println("The numeric value of " + letterGrade + " is " + numericGrade);
    }
}
