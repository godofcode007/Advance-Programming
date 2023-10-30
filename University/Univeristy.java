package University;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Univeristy {

    ArrayList<Department> departments = new ArrayList<Department>();

    public void newDepartment() {

        Department dept = new Department();

        dept.deptID = Integer.parseInt(JOptionPane.showInputDialog("Enter department ID"));
        dept.title = JOptionPane.showInputDialog("Enter department title");

        dept.courses = new ArrayList<Course>();
        dept.students = new ArrayList<Student>();

        this.departments.add(dept);

        JOptionPane.showMessageDialog(null, "Department added successfully");
    }

    public void displayDepartments() {
        // show all the departments stored in the departments arraylist

        for (Department d : departments) {
            System.out.println(d.deptID + " " + d.title);
            System.out.println("Courses: " + d.title);

            for (Course c : d.courses) {
                System.out.println(c.id + " " + c.title);
            }

            System.out.println("Students in: " + d.title);
            for (Student s : d.students) {
                System.out.println(s.Name + " " + s.Surname);
            }
        }

    }

    public void displayDepartment(int deptID) {
        // show the department with the given deptID

        for (Department d : departments) {

            if (d.deptID == deptID) {
                System.out.println(d.deptID + " " + d.title);
                System.out.println("Courses: " + d.title);

                for (Course c : d.courses) {
                    System.out.println(c.id + " " + c.title);
                }

                System.out.println("Students in: " + d.title);
                for (Student s : d.students) {
                    System.out.println(s.Name + " " + s.Surname);
                }
            }
        }
    }

    public void newCourse(int deptID) {
        // add a new course to the department with the given deptID

        int courseid = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID"));
        String title = JOptionPane.showInputDialog("Enter course title");

        Course course = new Course(courseid, title);

        for (Department d : departments) {
            if (d.deptID == deptID) {
                d.addCourse(course);
            }
        }
    }

    public void newStudent(int deptID) {
        // add a new student to the department with the given deptID

        int stuid = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID"));
        String name = JOptionPane.showInputDialog("Enter student name");
        String surname = JOptionPane.showInputDialog("Enter student surname");

        Student stu = new Student(stuid, name, surname);

        for (Department d : departments) {
            if (d.deptID == deptID) {
                d.addStudent(stu);
            }
        }
    }

    public static void main(String[] args) {

        Univeristy univ = new Univeristy();
        univ.newDepartment();
        univ.newDepartment();

        univ.newCourse(1);
        univ.newCourse(1);

        univ.newStudent(1);
        univ.newStudent(1);

        univ.newCourse(2);
        univ.newStudent(2);

        univ.displayDepartments();
        System.out.println("****************************");

        univ.displayDepartment(1);

        System.out.println(univ.departments);

    }
}