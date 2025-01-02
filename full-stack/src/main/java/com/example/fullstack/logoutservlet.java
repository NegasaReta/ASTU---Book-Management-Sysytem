package com.example.fullstack;
import java.io.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/logout")
public class logoutservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Get the current session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        RequestDispatcher rd = req.getRequestDispatcher("/index.html");
        rd.forward(req,resp);
    }
}