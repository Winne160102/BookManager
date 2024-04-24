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
      <h2>List of Books</h2>
      <div class="tab-content mt-3">
        <div id="books" class="tab-pane fade show active">
          <table class="table">
            <thead>
            <tr>
              <th>BookID</th>
              <th>Name</th>
              <th>Quantity</th>
              <th>Actions</th>
              <th><button class="btn"><a href="BookController?action=new">Add New Book</a></button></th>
            </tr>
            </thead>
            <tbody>
            <%
              try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM books");
                while (rs.next()) {
            %>
            <tr>
              <td><%= rs.getInt("BookID") %></td>
              <td><%= rs.getString("Name") %></td>
              <td><%= rs.getInt("Quantity") %></td>
              <td>
                <a href="editBook.jsp?StudentID=<%= rs.getInt("BookID") %>&Quantity=<%= rs.getInt("Quantity") %>" class="btn btn-sm btn-primary">Edit</a>
                <button onclick="confirmDelete(<%= rs.getInt("BookID") %>)" class="btn btn-sm btn-danger">Delete</button>

              </td>
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