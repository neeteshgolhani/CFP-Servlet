package com.servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String username = request.getParameter("user");
            String password = request.getParameter("password");

            if(username.equals("admin") && password.equals("password")){
                response.sendRedirect("LoginSuccess.jsp");
            }else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Incorrect Credential</font>");
                requestDispatcher.include(request,response);
            }
        }
    }
