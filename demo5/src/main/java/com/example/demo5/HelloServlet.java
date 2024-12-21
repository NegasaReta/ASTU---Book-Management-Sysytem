package com.example.demo5;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
 private  String aa,pp;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user");
        aa=name;
        String message = request.getParameter("password");
        pp=message;
        response.setContentType("text/html");
    if("admin".equals(name) && "123".equals(message)) {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/new.html");
        rd.forward(request,response);
}
        // Hello
      else{  PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"name= " + name+" password= " +message+" password or username is incorrect"+ "</h1>");
        out.println("</body></html>");}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/new.html");
        rd.forward(request,response);
    }
}