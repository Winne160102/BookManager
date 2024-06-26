package model;

public class Book {
    private int bookID;
    private String name;
    private int totalPage;
    private String type;
    private int quantity;

    // Constructors
    public Book() {
    }

    public Book(int bookID, String name, int totalPage, String type, int quantity) {
        this.bookID = bookID;
        this.name = name;
        this.totalPage = totalPage;
        this.type = type;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", name='" + name + '\'' +
                ", totalPage=" + totalPage +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
