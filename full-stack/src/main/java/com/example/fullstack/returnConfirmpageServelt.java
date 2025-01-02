package com.example.fullstack;
import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet ("/confarm")
public class returnConfirmpageServelt extends HttpServlet {
    static  String  borower_id;
    static  int  bokid;

    public static void  getval(String borrower_id, int bookid) {
        borower_id=borrower_id;
        bokid=bookid;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Connection con = connector.con();
            Statement st = con.createStatement();
            CallableStatement cs=con.prepareCall("{call r_eturn(?,?)}");
            cs.setString(1,borower_id);
            cs.setInt(2,bokid);


            cs.execute();

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/returnpagesuccess1.jsp");
            rd.forward(req,resp);


            } catch (SQLException e) {

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/returnpageerror.jsp");
            rd.forward(req,resp);
            e.printStackTrace();
            }
        //st.executeQuery("select * from loginpageServlet");

    }
}
