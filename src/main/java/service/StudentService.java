package service;

import java.util.List;
import model.Student;
import dao.StudentDAO;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int studentID) {
        return studentDAO.getStudentById(studentID);
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentID) {
        studentDAO.deleteStudent(studentID);
    }
}