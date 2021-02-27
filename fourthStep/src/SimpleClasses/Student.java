package SimpleClasses;

import java.util.List;

public class Student {

    private String lastname;

    private String initials;

    private int groupNumber;

    private int[] marks;

    public Student(String lastname, String initials, int groupNumber, int[] marks) {
        this.lastname = lastname;
        this.initials = initials;
        this.groupNumber = groupNumber;
        this.marks = marks;
    }

    public static void printStudentsWithGoodMarks(List<Student> students) {
        for (Student student : students) {
            boolean isGood = true;
            for (int mark : student.marks) {
                if (mark < 9) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                System.out.println(student.lastname + " " + student.groupNumber);
            }
        }
    }
}
