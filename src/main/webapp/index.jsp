<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
</head>
<body>
<h1>Students List:</h1>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Phone</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.firstName}" /></td>
            <td><c:out value="${student.lastName}" /></td>
            <td><c:out value="${student.email}" /></td>
            <td><c:out value="${student.age}" /></td>
            <td><c:out value="${student.phone}" /></td>
        </tr>
    </c:forEach>
</table>

<form method="POST" action="MyServlet">
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    Email: <input type="text" name="email"><br>
    Age: <input type="text" name="age"><br>
    Phone: <input type="text" name="phone"><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>
