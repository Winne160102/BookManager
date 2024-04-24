<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Student</title>
    <%@include file="../all_compoent/allCss.jsp"%>
</head>
<body>
<%@include file="../all_compoent/navbar.jsp"%>
<div class="container mt-4">
    <h2>Add New Student</h2>
    <form action="StudentController?action=add" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select class="form-control" id="gender" name="gender" required>
                <option value="true">Male</option>
                <option value="false">Female</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Add Student</button>
    </form>
</div>
</body>
</html>