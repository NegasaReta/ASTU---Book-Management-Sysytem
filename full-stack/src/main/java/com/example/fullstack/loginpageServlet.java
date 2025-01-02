package com.example.fullstack;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login_a")
public class loginpageServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user");

        String pswd = request.getParameter("password");
        List<Map<String, Object>> bookList = new ArrayList<>();
        Connection con = connector.con();
        try {
            Statement st = con.createStatement();
            //st.executeQuery("select * from loginpageServlet");
            ResultSet rs = st.executeQuery("select username, passwd from U_ser");
            while(rs.next()){
                String username = rs.getString("username");
                String passwd = rs.getString("passwd");
                if(username.equals(name) && passwd.equals(pswd)){
                    String pic,bok_name,author;
                    int qunat,cat_id;
                    String sql="Select pic_url,book_name,book_author,book_quantity,cat_id from booklist";
                    rs=st.executeQuery(sql);
                    while(rs.next()){
                        Map<String, Object> bookData = new HashMap<>();
                        bookData.put("pic_url", rs.getString("pic_url"));
                        bookData.put("bok_name", rs.getString("book_name"));
                        bookData.put("author", rs.getString("book_author"));
                        bookData.put("cat_id", rs.getInt("cat_id"));
                        bookData.put("qunat", rs.getInt("book_quantity"));
                        bookList.add(bookData);
                    }request.setAttribute("bookList", bookList);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
                    rd.forward(request,response);
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/passw_usernameincorrect.jsp");
                    rd.forward(request,response);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


        // Hello


}