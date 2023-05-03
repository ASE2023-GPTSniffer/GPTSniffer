public class Course {
    private String courseName;
    private String[] students = new String[1];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents == students.length) {
            String[] newStudents = new String[students.length * 2];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
        }
        students[numberOfStudents++] = student;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                System.arraycopy(students, i + 1, students, i, numberOfStudents - i - 1);
                numberOfStudents--;
                break;
            }
        }
    }

    public void clear() {
        students = new String[1];
        numberOfStudents = 0;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}
