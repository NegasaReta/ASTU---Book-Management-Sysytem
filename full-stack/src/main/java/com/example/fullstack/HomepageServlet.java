package com.example.fullstack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/howe")

public class HomepageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        List<Map<String, Object>> bookList = new ArrayList<>();
        Connection con = connector.con();
            try {
            Statement st = con.createStatement();
            //st.executeQuery("select * from loginpageServlet");
            ResultSet rs ;
            String sql = "Select pic_url,book_name,book_author,book_quantity,cat_id from booklist";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Map<String, Object> bookData = new HashMap<>();
                bookData.put("pic_url", rs.getString("pic_url"));
                bookData.put("bok_name", rs.getString("book_name"));
                bookData.put("author", rs.getString("book_author"));
                bookData.put("cat_id", rs.getInt("cat_id"));
                bookData.put("qunat", rs.getInt("book_quantity"));
                bookList.add(bookData);
            }
            request.setAttribute("bookList", bookList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
            rd.forward(request, response);
        }       catch (SQLException ex)
            {
            throw new RuntimeException(ex);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}