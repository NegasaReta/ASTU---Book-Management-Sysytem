<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verification</title>
    <link rel="stylesheet" href="css/verification.css">
</head>
<body>
<div class="back-drop"></div>
<div class="verification">
    <h1>Are you sure?</h1>
    <h2>Name: <%= request.getAttribute("name") %></h2>
    <h2>Student ID: <%= request.getAttribute("student_id") %></h2>
    <h2>Phone Number: <%= request.getAttribute("phone_number") %></h2>
    <h2>Book Title: <%= request.getAttribute("book_id") %></h2>
    <H2>Return Date: <%=request.getAttribute("return_date")%></H2>
    <div class="verification-btns">
        <form method="post" action="confirm">
            <button type="submit" class="verification-confirm">Confirm</button>
        </form>
        <form method="get" action="cancel">
            <button type="submit" class="verification-cancel">Cancel</button>
        </form>
    </div>
</div>
</body>
</html>
