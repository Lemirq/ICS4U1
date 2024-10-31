package OOP;

public class Western {
    public static void main(String[] args) {
        WesternStaff staff = new WesternStaff("John", "Doe", 123456, "Science", "Professor", 100000);
        WesternStudent student = new WesternStudent("Jane", "Doe", 654321, "Computer Science", "Math", 2);

        staff.getInfo();
        System.out.println();
        student.getInfo();
    }
}
