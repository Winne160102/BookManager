package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Borrow;
import util.DBConnect;

public class BorrowDAO {
    private Connection conn;

    public BorrowDAO() {
        conn = DBConnect.getConn();
    }

    public List<Borrow> getAllBorrows() {
        List<Borrow> borrows = new ArrayList<>();
        String sql = "SELECT * FROM borrows";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Borrow borrow = new Borrow();
                borrow.setBorrowID(rs.getInt("borrowID"));
                borrow.setStudentID(rs.getInt("studentID"));
                borrow.setBookID(rs.getInt("bookID"));
                borrow.setQuantity(rs.getInt("quantity"));
                borrow.setBorrowDate(rs.getDate("borrowDate"));
                borrows.add(borrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrows;
    }
    public void addBorrow(Borrow borrow) {
        String sql = "INSERT INTO borrows (studentID, bookID, quantity, borrowDate) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, borrow.getStudentID());
            ps.setInt(2, borrow.getBookID());
            ps.setInt(3, borrow.getQuantity());
            ps.setDate(4, new java.sql.Date(borrow.getBorrowDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBorrow(Borrow borrow) {
        String sql = "UPDATE borrows SET studentID = ?, bookID = ?, quantity = ?, borrowDate = ? WHERE borrowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, borrow.getStudentID());
            ps.setInt(2, borrow.getBookID());
            ps.setInt(3, borrow.getQuantity());
            ps.setDate(4, new java.sql.Date(borrow.getBorrowDate().getTime()));
            ps.setInt(5, borrow.getBorrowID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBorrow(int borrowID) {
        String sql = "DELETE FROM borrows WHERE borrowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, borrowID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Borrow getBorrowById(int borrowID) {
        Borrow borrow = null;
        String sql = "SELECT * FROM borrows WHERE borrowID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, borrowID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                borrow = new Borrow();
                borrow.setBorrowID(rs.getInt("borrowID"));
                borrow.setStudentID(rs.getInt("studentID"));
                borrow.setBookID(rs.getInt("bookID"));
                borrow.setQuantity(rs.getInt("quantity"));
                borrow.setBorrowDate(rs.getDate("borrowDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrow;
    }

    // Thêm các phương thức khác như thêm phiếu mượn, cập nhật thông tin phiếu mượn, xóa phiếu mượn, vv.
}