package model;

import java.util.Date;

public class Borrow {
    private int borrowID;
    private int studentID;
    private int bookID;
    private int quantity;
    private Date borrowDate;

    // Constructors
    public Borrow() {
    }

    public Borrow(int borrowID, int studentID, int bookID, int quantity, Date borrowDate) {
        this.borrowID = borrowID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
    }

    // Getters and Setters
    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Borrow{" +
                "borrowID=" + borrowID +
                ", studentID=" + studentID +
                ", bookID=" + bookID +
                ", quantity=" + quantity +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
