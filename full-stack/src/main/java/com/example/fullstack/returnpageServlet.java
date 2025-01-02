package com.example.fullstack;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet ("/return")
public class returnpageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> bookList = new ArrayList<>();
        Connection con = connector.con();
        try {
            Statement st = con.createStatement();
            //st.executeQuery("select * from loginpageServlet");
            ResultSet rs;
            String sql = "Select borrower_name,borrower_id,phone_number,book_name,return_date,statas from borrowlist";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("statas").equals("returned")){
                    continue;
                }
                Map<String, Object> bookData = new HashMap<>();
                bookData.put("name", rs.getString("borrower_name"));
                bookData.put("id", rs.getString("borrower_id"));
                bookData.put("number", rs.getString("phone_number"));
                bookData.put("bookname", rs.getString("book_name"));
                bookData.put("returndate", rs.getString("return_date"));

                bookList.add(bookData);
            }
            req.setAttribute("bookList", bookList);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/return.jsp");
            rd.forward(req, resp);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String boookname = req.getParameter("bookname");
        String borrower = req.getParameter("borrowerid");
        String phone = req.getParameter("phone");
        req.setAttribute("boookname", boookname);
        req.setAttribute("borrowerid", borrower);
        req.setAttribute("phone", phone);
        boolean chk = false;
        int bok_id;
        try {
            Connection con = connector.con();
            Statement st = con.createStatement();
            //st.executeQuery("select * from loginpageServlet");
            CallableStatement cs=con.prepareCall("{call chec(?,?,?,?)}");
            cs.setString(1, boookname);
            cs.setString(2,borrower);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.execute();
            chk = cs.getBoolean(3);
            if(chk){

                bok_id = cs.getInt(4);
                returnConfirmpageServelt.getval(borrower,bok_id);

                RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/returnpageverification.jsp");
                rd.forward(req, resp);

            }
            else{
                RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/borrowpagenotfound.jsp");
                rd.forward(req, resp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}

