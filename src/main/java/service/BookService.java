package service;

import java.util.List;
import model.Book;
import dao.BookDAO;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(int bookID) {
        return bookDAO.getBookById(bookID);
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int bookID) {
        bookDAO.deleteBook(bookID);
    }
}
