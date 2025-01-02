package com.example.fullstack;
import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/borrowm")
public class borrowservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String student_id = req.getParameter("student id");
        String book_id = req.getParameter("book");
        String phone_number = req.getParameter("phone number");
        String return_date = req.getParameter("Return Date");
        req.setAttribute("name",name);
        req.setAttribute("student_id",student_id);
        req.setAttribute("book_id",book_id);
        req.setAttribute("phone_number",phone_number);
        req.setAttribute("return_date",return_date);


        boolean chk=false,chkk=false;
        int id;
        try {
            Connection con = connector.con();
            Statement st = con.createStatement();
            //st.executeQuery("select * from loginpageServlet");
            CallableStatement cs=con.prepareCall("{call chek(?,?,?,?,?)}");
            cs.setString(1, book_id);
            cs.setString(2, student_id);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.registerOutParameter(4, Types.BOOLEAN);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.execute();
            chkk=cs.getBoolean(3);
            chk = cs.getBoolean(4);
            id=cs.getInt(5);

            if(chk) {
                if(chkk){
                borrowConfirmpageServlet.getval(student_id,name, phone_number,id,return_date);
                RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/borrowpageverification.jsp");
                rd.forward(req, resp);
                }
                else{
                    RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/borrowduplcationmsgpage.jsp");
                    rd.forward(req, resp);
                }

            }
            else{
                RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/borrowpagenotfound.jsp");
                rd.forward(req, resp);
            }



             } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }


/*
        req.setAttribute("right",true);
        RequestDispatcher rd=req.getRequestDispatcher("/borrow.jsp");
        rd.forward(req,resp);
        PrintWriter out = resp.getWriter();
        out.println("<html> <div class=\"verifiaction\">  <h1>Are you sure?</h1>  <h2 class=\"verify_name\"></h2>  <h2 class=\"verify_id\"></h2>  <h2 class=\"verify_phone\"></h2>  <h2 class=\"verify_book\"></h2>  <div class=\"verificatoin-btns\">  <button class=\"verificatoin-confirm verificatoin-btn\" name=\"confirm\">Confirm</button> <button class=\"verificatoin-cancel verificatoin-btn\" name=\"cancel\">Cancel</button> </div> </div> <div class=\"back-drop\"></div> </main> <script src=\"JS/borrow.js\"></script> ");
*/

    }
}
