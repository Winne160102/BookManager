package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BorrowDAO;
import model.Borrow;

@WebServlet("/BorrowController")
public class BorrowController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BorrowDAO borrowDAO;

    public void init() {
        borrowDAO = new BorrowDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý các request từ view tương ứng với entity Borrow
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
