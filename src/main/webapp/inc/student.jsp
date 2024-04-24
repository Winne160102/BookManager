<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>BookManager</title>
    <%@include file="../all_compoent/allCss.jsp"%>
    <script type="text/javascript">
        function confirmDelete(studentID) {
            if (confirm("Are you sure you want to delete this student?")) {
                window.location.href = "StudentController?action=delete&studentID=" + studentID;
            }
        }
    </script>
</head>
<body>
    <%@include file="../all_compoent/navbar.jsp"%>
<div class="container mt-4">
    <h2>List of Students</h2>
    <div class="tab-content mt-3">
        <div id="books" class="tab-pane fade show active">
            <table class="table">
                <thead>
                <tr>
                    <th>StudentID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Actions</th>
                    <th><button class="btn"><a href="addStudent.jsp">Add New Student</a></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("StudentID") %></td>
                    <td><%= rs.getString("Name") %></td>
                    <td><%= rs.getInt("Age") %></td>
                    <td><%= rs.getBoolean("Gender") ? "Male" : "Female" %></td>

                    <td>
                        <a href="editStudent.jsp?StudentID=<%= rs.getInt("StudentID") %>&Name=<%= rs.getString("Name") %>&Age=<%= rs.getInt("Age") %>&Gender=<%= rs.getBoolean("Gender") %>" class="btn btn-sm btn-primary">Edit</a>
                        <button onclick="confirmDelete(<%= rs.getInt("StudentID") %>)" class="btn btn-sm btn-danger">Delete</button>
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
