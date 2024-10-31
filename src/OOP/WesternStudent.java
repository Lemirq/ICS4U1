package OOP;

public class WesternStudent extends WesternPerson {
    String major, minor;
    int year;

    public WesternStudent(String fName, String lName, int id, String major, String minor, int year) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.major = major;
        this.minor = minor;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("Name: " + fName + " " + lName);
        System.out.println("ID: " + id);
        System.out.println("Major: " + major);
        System.out.println("Minor: " + minor);
        System.out.println("Year: " + year);
    }
}
