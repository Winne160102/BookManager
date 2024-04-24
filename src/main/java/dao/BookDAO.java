package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import util.DBConnect;

public class BookDAO {
    private Connection conn;

    public BookDAO() {
        conn = DBConnect.getConn();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setName(rs.getString("name"));
                book.setTotalPage(rs.getInt("totalPage"));
                book.setType(rs.getString("type"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books (name, totalPage, type, quantity) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setInt(2, book.getTotalPage());
            ps.setString(3, book.getType());
            ps.setInt(4, book.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        String sql = "UPDATE books SET name = ?, totalPage = ?, type = ?, quantity = ? WHERE bookID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setInt(2, book.getTotalPage());
            ps.setString(3, book.getType());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getBookID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookID) {
        String sql = "DELETE FROM books WHERE bookID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Book getBookById(int bookID) {
        Book book = null;
        String sql = "SELECT * FROM books WHERE bookID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setName(rs.getString("name"));
                book.setTotalPage(rs.getInt("totalPage"));
                book.setType(rs.getString("type"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    // Các phương thức khác tùy thuộc vào yêu cầu cụ thể của ứng dụng.
}