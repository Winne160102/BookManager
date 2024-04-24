package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.DBConnect;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        conn = DBConnect.getConn();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DBConnect.getConn();

            // Tạo câu lệnh SQL để thêm sinh viên mới vào bảng students
            String sql = "INSERT INTO students (Name, Age, Gender) VALUES (?, ?, ?)";

            // Tạo đối tượng PreparedStatement để thực thi câu lệnh SQL
            statement = conn.prepareStatement(sql);

            // Thiết lập các tham số trong câu lệnh SQL từ đối tượng Student
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setBoolean(3, student.isGender());

            // Thực thi câu lệnh SQL để thêm sinh viên mới vào cơ sở dữ liệu
            statement.executeUpdate();

            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tuyên bố PreparedStatement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, gender = ? WHERE studentID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setBoolean(3, student.isGender());
            ps.setInt(4, student.getStudentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentID) {
        String sql = "DELETE FROM students WHERE studentID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student getStudentById(int studentID) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE studentID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Các phương thức khác tùy thuộc vào yêu cầu cụ thể của ứng dụng.
}