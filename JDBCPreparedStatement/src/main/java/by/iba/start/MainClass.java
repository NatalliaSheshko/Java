package by.iba.start;

import by.iba.action.FacultyAction;
import by.iba.model.Faculty;
import by.iba.model.Student;
import by.iba.action.StudentAction;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;


public class MainClass {

    StudentAction action = new StudentAction();
    FacultyAction action1 = new FacultyAction();

    public static void main(String[] args) {
        String DbOperation = "EXIT(0), ADDSTUDENT(1), UPDATESTUDENT(2), DELETESTUDENT(3), FETCHSTUDENTBYID(4), FETCHSTUDENTBYEMAIL(5), FETCHSTUDENTBYMOBNO(6), FETCHSTUDENTBYNAME(7),"
                + "FETCHSTUDENTBYCITY(8), FETCHSTUDENTBYSALRANGE(9), FETCHSTUDENTBYDOB(10), FETCHSTUDENTBYDOJRANGE(11), FETCHALLSTUDENT(12),"
                + "ADDFACULTY(13), UPDATEFACULTY(14), DELETEFACULTY(15), SEARCHFACULTYBYID(16)";

        MainClass mainclass = new MainClass();
        int value = 0;
        do {
            System.out.println("valid operations are");

            System.out.println(DbOperation);
            System.out.println("Enter valid operation number 0-16");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    mainclass.addStudent();
                    break;
                case 2:
                    mainclass.updateStudent();
                    mainclass.fetchAllStudent();
                    break;
                case 3:
                    mainclass.deleteStudent();
                    break;
                case 4:
                    mainclass.fetchStudentById();
                    break;
                case 5:
                    mainclass.fetchStudentByEmail();
                    break;
                case 6:
                    mainclass.fetchStudentByMobileNo();
                    break;
                case 7:
                    mainclass.searchStudentByName();
                    break;
                case 8:
                    mainclass.fetchStudentByCity();
                    break;
                case 9:
                    mainclass.fetchStudentBySalaryRange();
                    break;
                case 10:
                    mainclass.fetchStudentByDob();
                    break;
                case 11:
                    mainclass.fetchStudentByDOjRange();
                    break;
                case 12:
                    mainclass.fetchAllStudent();
                    break;
                case 13:
                    mainclass.addFaculty();
                    break;
                case 14:
                    mainclass.updateFaculty();
                    break;
                case 15:
                    mainclass.deleteFaculty();
                    break;
                case 16:
                    mainclass.searchFacultyById();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);

    }

    public void addStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.insert(student);
    }

    public void updateStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        student.setId(insert.nextLong());
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.update(student);
    }

    public void deleteStudent() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.delete(id);
    }

    public void fetchStudentById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.fetchById(id);
    }

    public void fetchStudentByEmail() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mail Id");
        String mailId = insert.next();
        action.fetchByEmailId(mailId);
    }

    public void fetchStudentByMobileNo() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mobile Number");
        String mobileNo = insert.next();
        action.fetchByMobileNo(mobileNo);
    }

    public void searchStudentByName() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String fname = insert.next();
        String lname = insert.next();
        action.searchByName(fname, lname);
    }

    public void fetchStudentByCity() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student City");
        String city = insert.next();
        action.fetchByCity(city);
    }

    public void fetchStudentBySalaryRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Salary Start Range");
        BigDecimal salaryRange1 = insert.nextBigDecimal();
        System.out.println("Enter Salary End Range");
        BigDecimal salaryRange2 = insert.nextBigDecimal();

        action.fetchBySalaryRange(salaryRange1, salaryRange2);
    }

    public void fetchStudentByDob() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Date of Birth (yyyy-mm-dd)");
        String dob = insert.next();
        action.fetchByDob(Date.valueOf(dob));
    }

    public void fetchStudentByDOjRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Start Date of Joining (yyyy-mm-dd)");
        String dob1 = insert.next();
        System.out.println("Enter End Date of Joining (yyyy-mm-dd)");
        String dob2 = insert.next();
        action.fetchByRangeDoj(Date.valueOf(dob1), Date.valueOf(dob2));
    }

    public void fetchAllStudent() {
        action.fetchAll();
    }

    public void addFaculty() {
        Faculty faculty = new Faculty();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter faculty's name");
        faculty.setName(insert.next());
        System.out.println("Enter faculty's chief");
        faculty.setChiefOfFaculty(insert.next());
        System.out.println("Enter number of students");
        faculty.setNumberOfStudents(Integer.valueOf(insert.next()));
        System.out.println("Enter number of professors");
        faculty.setNumberOfProfessors(Integer.valueOf(insert.next()));
        System.out.println("Enter faculty's location");
        faculty.setLocation(insert.next());
        action1.insert(faculty);
    }

    public void updateFaculty() {
        Faculty faculty = new Faculty();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter faculty's id");
        faculty.setId(Long.parseLong(insert.next()));
        System.out.println("Enter faculty's name");
        faculty.setName(insert.next());
        System.out.println("Enter faculty's chief");
        faculty.setChiefOfFaculty(insert.next());
        System.out.println("Enter number of students");
        faculty.setNumberOfStudents(Integer.valueOf(insert.next()));
        System.out.println("Enter number of professors");
        faculty.setNumberOfProfessors(Integer.valueOf(insert.next()));
        System.out.println("Enter faculty's location");
        faculty.setLocation(insert.next());
        action1.update(faculty);
    }

    public void deleteFaculty() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter faculty's id");
        long id = insert.nextLong();
        action1.delete(id);
    }

    public void searchFacultyById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter faculty's id");
        long id = insert.nextLong();
        action1.searchById(id);
    }
}

