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
    <link rel="stylesheet" href="css/home.css">
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
        <div class="back-drop"></div>

    <main>
        <h1 class="title">Available Books</h1>
        <div class="filter">
            <ul class="filter-items">
                <li data="All" class="filter-item active">All</li>
                <li data="1" class="filter-item">SE</li>
                <li data="2" class="filter-item">CSE</li>
                <li data="3" class="filter-item">CEA</li>
                <li data="4" class="filter-item">Applied</li>
                <li data="5" class="filter-item">MCE</li>
                <li data="6" class="filter-item">Other</li>
            </ul>
        </div>
        <div class="books">
            <%
                String pic,bok_name,author,cat_id,qunat;
                List<Map<String, Object>> book =(List<Map<String, Object>>) request.getAttribute("bookList");
                for (Map<String, Object> bookMap : book) {
                    // Assign values to the strings
                     pic =bookMap.get("pic_url").toString();
                    bok_name =bookMap.get("bok_name").toString();
                    author =bookMap.get("author").toString();
                     cat_id = bookMap.get("cat_id").toString();
                    qunat =bookMap.get("qunat").toString();
            %>
            <div id="book-container" class="book-container selected <%=cat_id%>">
                <div class="book-cover">
                    <img src="${pageContext.request.contextPath}<%=pic%>" alt="book-Cover">
                </div>
                <h3 class="book-title"><%= bok_name %></h3>
                <h4 class="author"><%= author %></h4>
                <h5 class="book_quantity">Quantity =<%= qunat %></h5>
            </div>
<%}%>
        </div>

    </main>
    <script src="JS/app.js"></script>
</body>
</html>