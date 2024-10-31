package OOP;

// The University of Western Ontario is creating a new software to keep track of people on campus. It consists of several classes, including an abstract superclass called WesternPerson, and several subclasses called WesternStaff and WesternStudent. All people have a name and ID number. Staff members belong to a faculty, have a job title, and are paid a salary. Students have a major, a minor, and the year of their program they are enrolled in. The WesternPerson class has an abstract method called getInfo() that displays all the information about a person in a formatted way. Write some code that could be used with this software. Write some driver code to test your classes.
public class WesternStaff extends WesternPerson {
    String faculty, jobTitle;
    double salary;

    public WesternStaff(String fName, String lName, int id, String faculty, String jobTitle, double salary) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.faculty = faculty;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public void getInfo() {
        System.out.println("Name: " + fName + " " + lName);
        System.out.println("ID: " + id);
        System.out.println("Faculty: " + faculty);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
    }

}
