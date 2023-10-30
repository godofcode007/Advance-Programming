package University;

import java.util.ArrayList;

public class Department {

    int deptID;
    String title;

    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Course> courses = new ArrayList<Course>();

    void addStudent(Student stu) {
        students.add(stu);
    }

    void addCourse(Course cou) {
        courses.add(cou);
    }

}
