package com.example.fullstack;
import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet ("/confirm")
public class borrowConfirmpageServlet extends HttpServlet {
  static  String id, phone, name,returndate,tempid;
    static int  bookid,phn;
    public static void  getval(String Id, String Name, String Phone, int Bookid,String retr) {
        id=Id;
        name=Name;
        phone=Phone;
        bookid=Bookid;
        returndate=retr;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phn=Integer.parseInt(phone);
        try {
            Connection con = connector.con();
            Statement st = con.createStatement();
            CallableStatement cs=con.prepareCall("{call addborrower(?,?,?,?)}");
            cs.setString(1, id);
            cs.setString(2, name);
            cs.setInt(3,phn);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.execute();
            tempid=cs.getString(4);
            try {
                CallableStatement cs1=con.prepareCall("{call borrow(?,?,?)}");
                cs1.setInt(1, bookid);
                cs1.setString(2, id);
                cs1.setString(3, returndate);
                cs1.execute();

            } catch (SQLException e) {
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/borrowpageerror1.jsp");
                rd.forward(req,resp);
            }
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/borrowpagesuccess.jsp");
            rd.forward(req,resp);
        } catch (SQLException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/borrowpageerror1.jsp");
            rd.forward(req,resp);
        }
        //st.executeQuery("select * from loginpageServlet");

    }
}
