<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookManager</title>
    <%@include file="../all_compoent/allCss.jsp"%>
</head>
<body>
    <%@include file="../all_compoent/navbar.jsp"%>
<div class="container mt-4">
    <h2>Borrow Book Information</h2>
    <div class="tab-content mt-3">
        <div id="books" class="tab-pane fade show active">
            <table class="table">
                <thead>
                <tr>
                    <th>BorrowID</th>
                    <th>StudentID</th>
                    <th>BookID</th>
                    <th>Quantity</th>
                    <th>BorrowDate</th>
                </tr>
                </thead>
                <tbody>
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM borrows");
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("BorrowID") %></td>
                    <td><%= rs.getInt("StudentID") %></td>
                    <td><%= rs.getInt("BookID") %></td>
                    <td><%= rs.getInt("Quantity") %></td>
                    <td><%= rs.getDate("BorrowDate") %></td>
                </tr>
                <%
                        }
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
