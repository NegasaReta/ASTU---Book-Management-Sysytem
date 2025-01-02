<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Managment System</title>
    <link rel="stylesheet" href="css/shared.css">
    <link rel="stylesheet" href="css/return.css">
    <link rel="icon" href="img/logo.png" />
</head>
<body>
    <header class="main-header">
        <nav class="main-nav">
            <div class="logo">
                <a href="howe">
                    <img src="img/logo.png" alt="" width="40" height="40">
                </a>
            </div>
            <a href="howe" class="astu">A.S.T.U</a>
            <ul class="main-nav-items">
                <li class="main-nav-item"><a href="borrow">Borrowed</a></li>
                <li class="main-nav-item"><a href="return">Return</a></li>
                <li class="main-nav-item"><a href="about">About</a></li>
                <li class="main-nav-item"><a href="logout">Logout</a></li>
                </ul>
            </nav>
        </header>
    <main>
        <form   action="return" method="post">
        <h1 class="title">Return a Book</h1>
        <%
        String name,id,number,bookname,returndate;
        List<Map<String, Object>> book =(List<Map<String, Object>>) request.getAttribute("bookList");
        for (Map<String, Object> bookMap : book) {
        // Assign values to the strings
            name =bookMap.get("name").toString();
            id =bookMap.get("id").toString();
            number =bookMap.get("number").toString();
            bookname = bookMap.get("bookname").toString();
            returndate =bookMap.get("returndate").toString();
        %>
        <div class="book">
            <input type="radio" name="borrowerid" value="<%=id%>">
            <input type="hidden" name="bookname" value="<%=bookname%>">
            <input type="hidden" name="phone" value="<%=number%>">
            <h2 class="book-name"><%=bookname%></h2>
            <h2> - </h2>
            <h2 class="Borrower_name"><%=name%></h2>
            <h2> - </h2>
            <h2 class="Borrower_Id"><%=id%></h2>
            <h2> - </h2>
            <h2 class="phone_number"><%=number%></h2>
            <h2> - </h2>
            <h2 class="return_date"><%=returndate%></h2>
        </div>
        <%}%>
        <div class="return"><button class="return-btn" type="submit">Return</button></div>
        </form>
    </main>
</body>