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
  <h2>Student ID: <%= request.getAttribute("borrowerid") %></h2>
  <h2>Phone Number: <%= request.getAttribute("phone") %></h2>
  <h2>Book Title: <%= request.getAttribute("boookname") %></h2>
  <div class="verification-btns">
    <form method="post" action="confarm">
      <button type="submit" class="verification-confirm">Confirm</button>
    </form>
    <form method="post" action="cancel">
      <button type="submit" class="verification-cancel">Cancel</button>
    </form>
  </div>
</div>
</body>
</html>
