package service;

import java.util.List;
import model.Borrow;
import dao.BorrowDAO;

public class BorrowService {
    private BorrowDAO borrowDAO;

    public BorrowService() {
        this.borrowDAO = new BorrowDAO();
    }

    public List<Borrow> getAllBorrows() {
        return borrowDAO.getAllBorrows();
    }

    public Borrow getBorrowById(int borrowID) {
        return borrowDAO.getBorrowById(borrowID);
    }

    public void addBorrow(Borrow borrow) {
        borrowDAO.addBorrow(borrow);
    }

    public void updateBorrow(Borrow borrow) {
        borrowDAO.updateBorrow(borrow);
    }

    public void deleteBorrow(int borrowID) {
        borrowDAO.deleteBorrow(borrowID);
    }
}