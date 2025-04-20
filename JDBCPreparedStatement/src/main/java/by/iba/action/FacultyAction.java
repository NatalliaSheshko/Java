package by.iba.action;

import by.iba.dao.FacultyDao;
import by.iba.model.Faculty;
import by.iba.model.Student;

import java.util.Scanner;

public class FacultyAction {

    FacultyDao dao = new FacultyDao();
    int st;



    public void insert(Faculty faculty) {

        st = dao.insert(faculty);
        if (st == 1) {
            System.out.println("Faculty inserted Successfully");
        } else if (st == -1) {
            System.out.println("Faculty already exists");
        } else {
            System.out.println("Unable to insert Faculty");
        }
    }



    public void update(Faculty faculty) {
        st = dao.update(faculty);
        if (st == 1) {
            System.out.println("Faculty updated Successfully");
        } else {
            System.out.println("Unable to update Faculty");
        }
    }



    public void delete(Long id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Faculty deleted Successfully");
        } else {
            System.out.println("No record found");
        }
    }

    public void searchById(Long id) {
        Faculty faculty = dao.searchById(id);
        if (faculty.getId() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Faculty details are :");
            System.out.println(faculty);
        }
    }



}
